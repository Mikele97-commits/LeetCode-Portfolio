package org.example.bookmarkbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.bookmarkbackend.dto.ExerciseDto;
import jakarta.annotation.PostConstruct;
import org.example.bookmarkbackend.dto.InputParamDto;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class ExerciseMarkdownService {

    private final Map<String, ExerciseDto> exerciseCache = new HashMap<>();
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    @PostConstruct
    public void loadExercisesFromMarkdown() {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:exercises/*.md");

            for (Resource resource : resources) {
                try (InputStream inputStream = resource.getInputStream()) {
                    String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                    ExerciseDto exercise = parseMarkdown(content);
                    exerciseCache.put(exercise.id(), exercise);
                }
            }
            System.out.println("Loaded " + exerciseCache.size() + " exercises from Markdown!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ExerciseDto parseMarkdown(String content) throws Exception {
        // 1. Split Front Matter from Body using "---"
        String[] parts = content.split("---");
        String yamlHeader = parts[1].trim();
        String markdownBody = parts[2].trim();
        String inputs=parts[3].trim();

        // 2. Read Front Matter into temporary map
        Map<String, String> meta = yamlMapper.readValue(yamlHeader, Map.class);

        // 3. Separate Description and Code block from body
        String description = markdownBody;
        String code = "";

        if (markdownBody.contains("```")) {
            int codeStart = markdownBody.indexOf("```");
            description = markdownBody.substring(0, codeStart).trim();

            // Extract code between triple backticks
            int firstLineEnd = markdownBody.indexOf("\n", codeStart);
            int codeEnd = markdownBody.lastIndexOf("```");
            if (firstLineEnd != -1 && codeEnd > firstLineEnd) {
                code = markdownBody.substring(firstLineEnd + 1, codeEnd).trim();
            }
        }
        List<InputParamDto> inputParams = yamlMapper.readValue(
                inputs,
                new TypeReference<List<InputParamDto>>() {}
        );


        return new ExerciseDto(
                meta.get("id"),
                meta.get("title"),
                meta.get("category"),
                meta.get("difficulty"),
                meta.get("link"),
                description,
                code,
                inputParams
        );
    }

    public List<ExerciseDto> getByCategory(String categoryId) {
        return exerciseCache.values().stream()
                .filter(ex -> ex.category().equalsIgnoreCase(categoryId))
                .toList();
    }

    public Optional<ExerciseDto> getById(String id) {
        return Optional.ofNullable(exerciseCache.get(id));
    }
}

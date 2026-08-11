package org.example.bookmarkbackend.controller;

import org.example.bookmarkbackend.dto.DataDto;
import org.example.bookmarkbackend.dto.ExerciseDto;
import org.example.bookmarkbackend.service.ExerciseMarkdownService;
import org.example.bookmarkbackend.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseController {

    private final ExerciseMarkdownService exerciseService;

    public ExerciseController(ExerciseMarkdownService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ExerciseDto>> getExercisesByCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(exerciseService.getByCategory(categoryId));
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<ExerciseDto> getExerciseById(@PathVariable String id) {
        return exerciseService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/execute")
    public String executeExercise(@RequestBody DataDto dataDto) {
        System.out.println("Running exercise execution on id " + dataDto.id());
        return ExerciseService.executeExercise(dataDto.id(), dataDto);
    }
}

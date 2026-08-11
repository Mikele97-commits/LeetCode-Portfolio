import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Exercise } from '../../models/exercise.model';
import { ExerciseService } from '../../services/exercise.service';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent implements OnInit {
  private route = inject(ActivatedRoute);
  private exerciseService = inject(ExerciseService);

  categoryId: string = '';
  filteredExercises: Exercise[] = [];

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.categoryId = params.get('id') || '';

      this.exerciseService.getExercisesByCategory(this.categoryId).subscribe({
        next: (data) => {
          this.filteredExercises = data.sort((a, b) => Number(a.id) - Number(b.id));;
        },
        error: (err) => {
          console.error('Failed to load exercises from backend', err);
        }
      });
    });
  }

  // Returns CSS class based on difficulty
  getDifficultyClass(difficulty: string): string {
    switch (difficulty?.toLowerCase()) {
      case 'easy':
        return 'diff-easy';
      case 'medium':
        return 'diff-medium';
      case 'hard':
        return 'diff-hard';
      default:
        return 'diff-default';
    }
  }
}

import {Component, inject, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import { Exercise } from '../../models/exercise.model';
import{ExerciseService} from '../../services/exercise.service';
import {FormsModule} from '@angular/forms';
import {ExerciseExecutionDto} from '../../models/toSend.model';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-exercise',
  standalone: true,
  imports: [RouterLink, FormsModule],
  templateUrl: 'exercise.component.html',
  styleUrl: 'exercise.component.css'
})
export class ExerciseComponent implements OnInit {
  private route = inject(ActivatedRoute);
  private exerciseService = inject(ExerciseService);

  paramValues: Record<string, string> = {};
  exerciseId: string = '';
  exercise: Exercise | null = null;
  outputResult: string | null = null;

  ngOnInit() {
    this.route.paramMap.subscribe(params => {

      this.exerciseId = params.get('id') || '';
      this.exerciseService.getExerciseById(this.exerciseId).subscribe({

        next: (data) => {
          this.exercise = data;
        },
        error: (err) => {
          console.error('Exercise not found', err);
        }
      });
    });
  }
  private http = inject(HttpClient);
  runSolution(): void {
    if (!this.exercise) return;

    const payload: ExerciseExecutionDto = {
      id: this.exercise.id,
      params: this.exercise.inputs.map(input => ({
        name: input.name,
        type: input.type,
        value: this.paramValues[input.name]
      }))
    };

    console.log('Sending payload:', payload);


    this.http.post('http://localhost:8080/api/execute', payload, {
      responseType: 'text'
    }).subscribe({
      next: (result) => {
        this.outputResult = result;
      },
      error: (err) => {
        console.error('Execution error:', err);
      }
    });
  }

}


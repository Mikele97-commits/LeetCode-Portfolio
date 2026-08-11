import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Exercise } from '../models/exercise.model';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/api';

  getExercisesByCategory(categoryId: string): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(`${this.baseUrl}/category/${categoryId}`);
  }

  getExerciseById(id: string): Observable<Exercise> {
    return this.http.get<Exercise>(`${this.baseUrl}/exercise/${id}`);
  }
}

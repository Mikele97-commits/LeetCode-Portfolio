import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CategoryComponent } from './pages/category/category.component';
import { ExerciseComponent } from './pages/exercise/exercise.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },                 // URL: /
  { path: 'category/:id', component: CategoryComponent }, // URL: /category/arrays
  { path: 'exercise/:id', component: ExerciseComponent }  // URL: /exercise/two-sum
];

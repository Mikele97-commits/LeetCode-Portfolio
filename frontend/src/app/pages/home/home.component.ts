import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import { Exercise } from '../../models/exercise.model';

export interface Category {
  id: string;
  title: string;
  description: string;
  count: number;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl:'home.component.html',
  styleUrl: 'home.component.css'
})
export class HomeComponent {
  categories: Category[] = [
    {
      id: 'by-id',
      title: 'By ID',
      description: 'Exercises i have done, based on their order on LeetCode "Problems" section',
      count: 15
    },
    {
      id: 'leetcode75',
      title: 'LeetCode75',
      description: 'Exercises from list "LeetCode75"',
      count: 8
    }
  ];
}

export interface Exercise {
  id: string;          // e.g., 'two-sum'
  title: string;       // e.g., 'Two Sum'
  category: string;    // e.g., 'arrays'
  difficulty: 'Easy' | 'Medium' | 'Hard';
  description: string;
  code: string;
  link: string;
  inputs: Inputs[];
}

interface Inputs{
  name: string;
  label: string;
  type: string;
}

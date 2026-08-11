export interface ExerciseExecutionDto {
  id: string;
  params: params[];
}
interface params {
  name: string;
  type: string;
  value: string;
}

package grades;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades;

    Student(String name){
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public double getGradeAverage(){
        double numOfGrades = this.grades.size();
        double gradeTotal = 0;

        for(int i = 0; i < numOfGrades; i ++){
            gradeTotal += grades.get(i);
        }

        return gradeTotal / numOfGrades;
    }
    public ArrayList<Integer> getAllGrades(){

        return this.grades;
    }
}

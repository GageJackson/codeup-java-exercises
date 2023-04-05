package grades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import util.Input;

public class GradesApplication {
    static HashMap<String, Student> students = new HashMap<>();
    static Input input = new Input();

    public static void setGrades(){
        for (Object student: students.keySet()) {
            Student retrievedStudent = students.get(student);

            for (int i = 0; i < 10; i++) {
                retrievedStudent.addGrade((int)(Math.random() * 50 + 50));
            }
        }
    }

    public static void main(String[] args) {
        setStudents();
        setGrades();
        setCLI();
    }
    
    public static void setCLI(){
        boolean userContinue = true;
        System.out.println("Welcome!\n");
        System.out.println("Here are the GitHub usernames of our students\n");
        setStudentInfo();
        do{
            System.out.println("What student would you like to see more information on?");
            String userResponse = input.getString("");
            getStudentInfo(userResponse);
            userContinue = input.yesNo("\n\nWould you like to see another student?");
        }while(userContinue);
            System.out.println("Goodbye, and have a wonderful day!");
    }

    public static void setStudents(){
        Student gage = new Student("Gage");
        Student rynda = new Student("Rynda");
        Student hubert = new Student("Hubert");
        Student kiera = new Student("Kiera");
        Student jenny = new Student("Jenny");

        students.put("Gagermeister", gage);
        students.put("RynerRyner", rynda);
        students.put("Hubertus", hubert);
        students.put("BestPetVet", kiera);
        students.put("HeyImJenny", jenny);
    }

    public static void getValidStudent(){

    }

    public static void setStudentInfo(){
        for (Object student: students.keySet()) {
            Student retrievedStudent = students.get(student);

            System.out.print("| " + student + " |");
        }
        System.out.println("\n");
    }

    public static void getStudentInfo(String studentUsername){
        if(!(students.containsKey(studentUsername))){
            System.out.println("Sorry, no student found with the GitHub username of \"studentUsername\".");
        } else {
            Student retrievedStudent = students.get(studentUsername);
            String studentRealName = retrievedStudent.getName();

            System.out.printf("Name: " + studentRealName + " GitHub Username: " + studentUsername + "%n");
            System.out.printf("Current Average: " + retrievedStudent.getGradeAverage() + "%n");
            System.out.print("Grades: ");
            for (int userGrade: retrievedStudent.getAllGrades())
            {
                System.out.printf(" |" + userGrade + "| ");
            }
        }
    }
}

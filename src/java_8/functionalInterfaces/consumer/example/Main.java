package java_8.functionalInterfaces.consumer.example;


import java_8.functionalInterfaces.data.Student;
import java_8.functionalInterfaces.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());


    public static void printName() {
        System.out.println("Main.printName");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void printNameAndActivities() {
        System.out.println("Main.printNameAndActivities");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c3.andThen(c4));
    }

    public static void filterAccordingToCondition() {
        System.out.println("Main.filterAccordingToCondition");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.5) {
                c3.andThen(c4).accept(student);
            }
        }));
    }

    public static void main(String[] args) {
        printName();
        printNameAndActivities();
        filterAccordingToCondition();
    }
}

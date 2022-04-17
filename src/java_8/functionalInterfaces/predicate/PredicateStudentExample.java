package java_8.functionalInterfaces.predicate;

import java_8.functionalInterfaces.data.Student;
import java_8.functionalInterfaces.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {
    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >=3;
    static Predicate<Student> p2 = s -> s.getGpa() >= 3.9;
    public static void filterStudentsByGradeLevel() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGpa() {
        System.out.println("PredicateStudentExample.filterStudentsByGpa");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        });

    }

    public static void main(String[] args){
        filterStudentsByGradeLevel();
        filterStudentsByGpa();

    }
}

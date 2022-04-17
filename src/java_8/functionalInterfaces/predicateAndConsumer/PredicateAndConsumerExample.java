package java_8.functionalInterfaces.predicateAndConsumer;

import java_8.functionalInterfaces.data.Student;
import java_8.functionalInterfaces.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {
    Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
    Predicate<Student> p2 = (s) -> s.getGpa() >=3.9;
    BiConsumer<String, List<String>> studentBiConsume = (name, activities) -> System.out.println(name+ " : " + activities);

    Consumer<Student> studentConsumer = (student) -> {
        if(p1.and(p2).test(student)){
            studentBiConsume.accept(student.getName(), student.getActivities());
        }
    };
    public void printNameAndActivities(List<Student> students) {
        students.forEach(studentConsumer);
    }
    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        new PredicateAndConsumerExample().printNameAndActivities(students);
    }
}

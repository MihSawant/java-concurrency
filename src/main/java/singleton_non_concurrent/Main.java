package singleton_non_concurrent;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // working fine with non concurrent
        Student[] mcaStudents = Student.getStudents();
        System.out.println(Arrays.toString(mcaStudents));

    }
}

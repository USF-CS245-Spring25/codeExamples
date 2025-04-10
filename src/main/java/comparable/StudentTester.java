package comparable;

public class StudentTester {
    public static void main(String[] args) {
        Student st1 = new Student(0, "Jane");
        Student st2 = new Student(1, "Anna");
        int res = st1.compareTo(st2);
        // System.out.println(res);

        if (res < 0) {  // st1 < st2, because st1.compareTo(st2) returned a negative value
            System.out.println("Student (0, 'Jane') < Student (1, 'Anna') based on the id");
        }
        else if (res > 0) // st1 > st2, because st1.compareTo(st2) returned a positive value)
            System.out.println("student1 > student2 based on the id");
        else { // s1.compareTo(s2) returned a 0
            System.out.println("two students are equal based on their id");
        }

    }
}

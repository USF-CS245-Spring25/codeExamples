package comparable;

// Class Student implements Comparable in a way that allows us to compare students by their id
public class Student implements Comparable<Student> {
    private int id;
    private String
            name;   // name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        // Compare "this" student  with the "other" student based on the id
        return this.id - other.id;
    }

}
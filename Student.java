package RaghavaKethuri.springdi; ;

public class Student {
    private Course course;

    // Constructor Injection
    public Student(Course course) {
        this.course = course;
    }

    public void showDetails() {
        System.out.println("Student object created successfully!");
        course.displayCourse();
    }
}

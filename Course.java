package RaghavaKethuri.springdi;

public class Course {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void displayCourse() {
        System.out.println("Enrolled in course: " + courseName);
    }
}

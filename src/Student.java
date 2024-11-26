package src;

import java.time.LocalDate;

public class Student extends Person {
    private String studentId;
    private String standard;

    public Student(String name, LocalDate dob, String contact, String studentId, String standard) {
        super(name, dob, contact);
        this.studentId = studentId;
        this.standard = standard;
    }

    @Override
    public void role() {
        System.out.println("I am a student with ID: " + studentId);
    }

    @Override
    public String getID() {
        return studentId; // Return the student's ID
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", Standard: " + standard;
    }
}

package src;

import java.time.LocalDate;

public class Student extends Person {
    public Student(String name, LocalDate dob, String contact, String studentId, String standard) {
        super(name, dob, contact);
        getProperties().put("studentId", studentId);
        getProperties().put("standard", standard);
    }

    @Override
    public void role() {
        System.out.println("I am a student with ID: " + getID());
    }

    @Override
    public String getID() {
        return (String) getProperties().get("studentId"); // Retrieve the student's ID from the map
    }

    public String getStandard() {
        return (String) getProperties().get("standard"); // Retrieve the standard from the map
    }

    public void setStandard(String standard) {
        getProperties().put("standard", standard); // Update the standard in the map
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + getID() + ", Standard: " + getStandard();
    }
}

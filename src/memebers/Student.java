package src.memebers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    public Student(String name, LocalDate dob, String contact, String studentId, String standard) {
        super(name, dob, contact);
        getProperties().put("studentId", studentId);
        getProperties().put("standard", standard);
    }

    public Student(Map<String, Object> map) {
        super(map);
    }

    @Override
    public void role() {
        System.out.println("I am a student with ID: " + getID());
    }

    @Override
    public String getID() {
        return (String) getProperties().getOrDefault("studentId", null); // Retrieve the student's ID from the map
    }

    public String getStandard() {
        return (String) getProperties().getOrDefault("standard", null); // Retrieve the standard from the map
    }

    public void setStandard(String standard) {
        getProperties().put("standard", standard); // Update the standard in the map
    }

}

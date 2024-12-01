package src;

import java.time.LocalDate;
import java.util.Map;

public class Teacher extends Person {
    public Teacher(String name, LocalDate dob, String contact, String employeeId, String subject) {
        super(name, dob, contact);
        getProperties().put("employeeId", employeeId);
        getProperties().put("subject", subject);
    }

    public Teacher(Map<String, Object> map) {
        super(map);
    }

    @Override
    public void role() {
        System.out.println("I am a teacher with Employee ID: " + getID() + " teaching: " + getSubject());
    }

    // Getter and Setter for Employee ID
    @Override
    public String getID() {
        return (String) getProperties().getOrDefault("employeeId", null);
    }

    public void setID(String employeeId) {
        getProperties().put("employeeId", employeeId);
    }

    // Getter and Setter for Subject
    public String getSubject() {
        return (String) getProperties().getOrDefault("subject", null);
    }

    public void setSubject(String subject) {
        getProperties().put("subject", subject);
    }

}

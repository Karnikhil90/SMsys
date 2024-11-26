package src;

import java.time.LocalDate;

public class Teacher extends Person {
    public Teacher(String name, LocalDate dob, String contact, String employeeId, String subject) {
        super(name, dob, contact);
        getProperties().put("employeeId", employeeId);
        getProperties().put("subject", subject);
    }

    @Override
    public void role() {
        System.out.println("I am a teacher with Employee ID: " + getID() + " teaching: " + getSubject());
    }

    // Getter and Setter for Employee ID
    @Override
    public String getID() {
        return (String) getProperties().get("employeeId");
    }

    public void setID(String employeeId) {
        getProperties().put("employeeId", employeeId);
    }

    // Getter and Setter for Subject
    public String getSubject() {
        return (String) getProperties().get("subject");
    }

    public void setSubject(String subject) {
        getProperties().put("subject", subject);
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + getID() + ", Subject: " + getSubject();
    }

}

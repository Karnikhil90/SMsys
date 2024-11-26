package src;

import java.time.LocalDate;

public class Teacher extends Person {
    private String subject;
    private String employeeId;

    Teacher(String name, LocalDate dob, String contact, String employeeId, String subject) {
        super(name, dob, contact);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    @Override
    public void role() {
        System.out.println("I am a teacher with Employee ID: " + employeeId + " teaching: " + subject);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId + ", Subject: " + subject;
    }
}

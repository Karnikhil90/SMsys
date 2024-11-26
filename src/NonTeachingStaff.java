package src;

import java.time.LocalDate;

public class NonTeachingStaff extends Person {
    public NonTeachingStaff(String name, LocalDate dob, String contact, String staffId, String department) {
        super(name, dob, contact);
        getProperties().put("staffId", staffId);
        getProperties().put("department", department);
    }

    @Override
    public void role() {
        System.out.println("I am a non-teaching staff member with Staff ID: " + getID() + " working in the "
                + getDepartment() + " department.");
    }

    // Getter and Setter for Staff ID
    public String getID() {
        return (String) getProperties().get("staffId");
    }

    public void setID(String staffId) {
        getProperties().put("staffId", staffId);
    }

    // Getter and Setter for Department
    public String getDepartment() {
        return (String) getProperties().get("department");
    }

    public void setDepartment(String department) {
        getProperties().put("department", department);
    }

    @Override
    public String toString() {
        return super.toString() + ", Staff ID: " + getID() + ", Department: " + getDepartment();
    }
}

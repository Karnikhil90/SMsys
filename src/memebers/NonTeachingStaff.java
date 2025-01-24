package src.memebers;

import java.time.LocalDate;
import java.util.Map;

public class NonTeachingStaff extends Person {
    public NonTeachingStaff(String name, LocalDate dob, String contact, String staffId, String department) {
        super(name, dob, contact);
        getProperties().put("staffId", staffId);
        getProperties().put("department", department);
    }

    public NonTeachingStaff(Map<String, Object> map) {
        super(map);
    }

    @Override
    public void role() {
        System.out.println("I am a non-teaching staff member with Staff ID: " + getID() + " working in the "
                + getDepartment() + " department.");
    }

    // Getter and Setter for Staff ID
    public String getID() {
        return (String) getProperties().getOrDefault("staffId", null);
    }

    public void setID(String staffId) {
        getProperties().put("staffId", staffId);
    }

    // Getter and Setter for Department
    public String getDepartment() {
        return (String) getProperties().getOrDefault("department", null);
    }

    public void setDepartment(String department) {
        getProperties().put("department", department);
    }

}

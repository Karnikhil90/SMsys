package src;

import java.time.LocalDate;

public class NonTeachingStaff extends Person {
    private String department;
    private String staffId;

    NonTeachingStaff(String name, LocalDate dob, String contact, String staffId, String department) {
        super(name, dob, contact);
        this.staffId = staffId;
        this.department = department;
    }

    @Override
    public void role() {
        System.out.println("I am a non-teaching staff member with Staff ID: " + staffId + " working in the "
                + department + " department.");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Staff ID: " + staffId + ", Department: " + department;
    }
}

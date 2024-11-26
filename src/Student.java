package src;

import java.time.LocalDate;
// import java.time.Period;

public class Student extends Person {
    private String Student_Id;
    private String Standard;

    Student(String name, LocalDate dob, String contact, String Student_Id, String Standard) {
        super(name, dob, contact);
        this.Standard = Standard;
        this.Student_Id = Student_Id;
    }

    @Override
    public void role() {
        System.out.println("I am a student with ID: " + Student_Id);
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String STD) {
        Standard = STD;
    }

    public String getStudentID() {
        return Student_Id;
    }

    public void setStudentID(String ID) {
        Student_Id = ID;
    }

}

package src;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private String name;
    private LocalDate dob;
    private String contact;

    public Person(String name, LocalDate dob, String contact) {
        this.name = name;
        this.dob = dob;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", DOB: " + dob + ", Contact: " + (contact != null ? contact : "N/A");
    }

    public abstract void role(); // Force subclasses to define their role
}

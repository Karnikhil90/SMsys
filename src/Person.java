package src;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public abstract class Person {
    private Map<String, Object> properties = new HashMap<>();

    public Person(String name, LocalDate dob, String contact) {
        properties.put("name", name);
        properties.put("dob", dob);
        properties.put("contact", contact);
    }

    public Person(Map<String, Object> map) {
        properties = new HashMap<>(map);
    }

    public String getName() {
        return (String) properties.getOrDefault("name", null);
    }

    public void setName(String name) {
        properties.put("name", name);
    }

    public LocalDate getDob() {
        return (LocalDate) properties.getOrDefault("dob", null);
    }

    public void setDob(LocalDate dob) {
        properties.put("dob", dob);
    }

    public String getContact() {
        return (String) properties.getOrDefault("contact", null);
    }

    public void setContact(String contact) {
        properties.put("contact", contact);
    }

    public int getAge() {
        try {
            return Period.between(getDob(), LocalDate.now()).getYears();
        } catch (Exception e) {
            return -1;
        }
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public String toString() {
        return properties.toString();
    }

    public abstract void role(); // Force subclasses to define their role

    public abstract String getID();
}

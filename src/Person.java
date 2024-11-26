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

    public String getName() {
        return (String) properties.get("name");
    }

    public LocalDate getDob() {
        return (LocalDate) properties.get("dob");
    }

    public String getContact() {
        return (String) properties.get("contact");
    }

    public void setContact(String contact) {
        properties.put("contact", contact);
    }

    public int getAge() {
        return Period.between(getDob(), LocalDate.now()).getYears();
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public abstract void role(); // Force subclasses to define their role

    public abstract String getID();
}

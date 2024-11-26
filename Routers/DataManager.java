package Routers;

import src.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The DataManager class serves as a central repository for managing all types
 * of Person objects. It provides methods to add, remove, update, and retrieve
 * Person entities like Student, Teacher, and NonTeachingStaff. This ensures
 * scalability and simplifies CRUD(Create, Read, Update, Delete.) operations,
 * supporting easy extension for future Person types.
 */

public class DataManager {
    private List<Person> people;

    public DataManager() {
        this.people = new ArrayList<>();
    }

    // Add a Person
    public void add(Person person) {
        people.add(person);
        System.out.println("Person added: " + person);
    }

    // Remove a Person by name
    public boolean remove(String name) {
        return people.removeIf(person -> person.getName().equalsIgnoreCase(name));
    }

    // Find a Person by name
    public Person find(String name) {
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    // List all People
    public void list() {
        if (people.isEmpty()) {
            System.out.println("No people found.");
        } else {
            System.out.println("People in the system:");
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    // Update a Person's contact info by name
    public boolean updateContact(String name, String newContact) {
        Person person = find(name);
        if (person != null) {
            person.setContact(newContact);
            System.out.println("Updated contact for: " + name);
            return true;
        }
        return false;
    }

    // load() : to get all the data from a saved from file.
    public void load(List<Person> lst_Persons) {
        for (Person people : lst_Persons) {
            try {
                add(people);
            } catch (Exception e) {
                System.err.println("Error : While loading people...");
            }

        }
    }
}

package Routers;

import src.NonTeachingStaff;
import src.Person;
import src.Student;
import src.Teacher;

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
    public final String NAME = "name", CONTACT = "contact", DOB = "dob";
    public final String STANDARD = "standard", SUBJECT = "subject", DEPARTMENT = "department";
    public final String STUDENT = "Student", TEACHER = "Teacher", NTS = "NonTeachingStaff";
    private List<Person> people;

    public DataManager() {
        this.people = new ArrayList<>();
    }

    public void add(Person person) {
        people.add(person);
        System.out.println("Person added: " + person);
    }

    public boolean remove(String name) {
        return people.removeIf(person -> person.getName().equalsIgnoreCase(name));
    }

    public Person find(String name) {
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public Person findByID(String ID) {
        for (Person person : people) {
            if (person.getID().equals(ID)) {
                return person; // Found the person
            }
        }
        return null; // Return null if no person with the given ID is found
    }

    public List<Person> list() {
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return new ArrayList<>(); // Return an empty list if no people are found
        } else {
            System.out.println("People in the system:");
            // Create and return a new ArrayList as a copy of the existing list
            return new ArrayList<>(people);
        }
    }

    public void printList() {
        if (people.isEmpty()) {
            System.out.println("No people found.");
        } else {
            System.out.println("People in the system:");
            for (Person person : people) {
                System.out.println(person);
            }
        }
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

    /*
     * The `update` function allows updating specific fields of a `Person` (like
     * contact, DOB, standard, subject, or department) using their unique ID. You
     * can pass the field name (e.g., "contact") and the new value to modify a
     * person's details. It supports both full and abbreviated field names (e.g.,
     * "ct" for contact).
     */

    public boolean update(String ID, String field, String updateTo) {
        Person person = findByID(ID);
        if (person == null) {
            System.out.println("Person not found.");
            return false;
        }

        switch (field.toLowerCase()) {
            case "contact":
            case "ct":
                person.setContact(updateTo);
                System.out.println("Updated contact for: " + person.getName());
                return true;

            case "name":
                System.out.println("Cannot update name, it's immutable.");
                return false;

            case "dob":
                try {
                    LocalDate newDob = LocalDate.parse(updateTo);
                    person.setDob(newDob);
                    System.out.println("Updated DOB for: " + person.getName());
                    return true;
                } catch (Exception e) {
                    System.out.println("Invalid date format, update failed.");
                    return false;
                }

            case "standard":
            case "std":
                if (person instanceof Student) {
                    ((Student) person).setStandard(updateTo);
                    System.out.println("Updated standard for: " + person.getName());
                    return true;
                } else {
                    System.out.println("Standard is only available for students.");
                    return false;
                }

            case "subject":
            case "sub":
                if (person instanceof Teacher) {
                    ((Teacher) person).setSubject(updateTo);
                    System.out.println("Updated subject for: " + person.getName());
                    return true;
                } else {
                    System.out.println("Subject is only available for teachers.");
                    return false;
                }

            case "department":
            case "dept":
                if (person instanceof NonTeachingStaff) {
                    ((NonTeachingStaff) person).setDepartment(updateTo);
                    System.out.println("Updated department for: " + person.getName());
                    return true;
                } else {
                    System.out.println("Department is only available for non-teaching staff.");
                    return false;
                }

            default:
                System.out.println("Invalid field specified.");
                return false;
        }
    }

    /**
     * Generates a new unique ID for the specified `Person_type` (e.g., "Student").
     * Iterates through the list of `Person` objects, finds the highest numeric ID
     * for the given type, and returns the next sequential ID as a string.
     * Assumes IDs are numeric and sequential.
     *
     * @param Person_type The type of `Person`.
     * 
     * @return A new unique ID as a `String`.
     */

    public String getNewID(String Person_type) {
        int maxId = 0;

        for (Person person : people) {
            if (Person_type.equalsIgnoreCase(STUDENT) && person instanceof Student) {
                String id = person.getID();
                try {
                    maxId = Math.max(maxId, Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid ID format for student: " + id);
                }
            } else if (Person_type.equalsIgnoreCase(TEACHER) && person instanceof Teacher) {
                String id = person.getID();
                try {
                    maxId = Math.max(maxId, Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid ID format for teacher: " + id);
                }
            } else if (Person_type.equalsIgnoreCase(NTS) && person instanceof NonTeachingStaff) {
                String id = person.getID();
                try {
                    maxId = Math.max(maxId, Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid ID format for non-teaching staff: " + id);
                }
            }
        }

        // Increment maxId by 1
        return String.valueOf(maxId + 1);
    }

}
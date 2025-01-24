package src.examples;

import src.Routers.DataManager;
import src.memebers.NonTeachingStaff;
import src.memebers.Person;
import src.memebers.Student;
import src.memebers.Teacher;

import java.time.LocalDate;
import java.util.Map;

/**
 * 
 * This is For DeBugs only
 */

public class Main {
    public static void main(String[] args) {
        Teacher t = new Teacher("Alice", LocalDate.of(2006, 3, 10), "alice@example.com", "T001", "Mathematics");
        Student s = new Student("Charlie", LocalDate.of(2005, 9, 20), "charlie@example.com", "ST123", "10th Grade");
        NonTeachingStaff nts = new NonTeachingStaff("Bob", LocalDate.of(1978, 7, 5), "bob@example.com", "S001",
                "Administration");

        // Create DataManager instance
        DataManager dataManager = new DataManager();
        String str = new String();

        // Add some people
        dataManager.add(t);
        dataManager.add(s);
        dataManager.add(nts);

        // List all people
        dataManager.printList();

        // Find a person by name
        Person found = dataManager.find("Alice");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Person not found.");
        }

        // Update (id, field , updateTO)

        // field NAME, CONTACT,DOB,STANDARD,SUBJECT,DEPARTMENT

        dataManager.update("S001", dataManager.CONTACT, "alice.new@example.com");

        // Remove a person by name
        boolean removed = dataManager.remove("Charlie");
        if (removed) {
            System.out.println("Person removed successfully.");
        } else {
            System.out.println("Person not found.");
        }

        // List all people after updates
        dataManager.printList();
        Map<String, Object> student1Props = Map.of(
                "name", "Alice",
                "dob", "2000-01-15",
                "contact", "1234567890");
        Student stu = new Student(student1Props);

        System.out.println(stu);

    }
}

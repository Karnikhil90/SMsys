import Routers.DataManager;
import src.Teacher;
import src.Student;
import src.NonTeachingStaff;
import src.Person;
import java.time.LocalDate;

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

        // Add some people
        dataManager.add(t);
        dataManager.add(s);
        dataManager.add(nts);

        // List all people
        dataManager.list();

        // Find a person by name
        Person found = dataManager.find("Alice");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Person not found.");
        }

        // Update a person's contact
        dataManager.updateContact("Alice", "alice.new@example.com");

        // Remove a person by name
        boolean removed = dataManager.remove("Charlie");
        if (removed) {
            System.out.println("Person removed successfully.");
        } else {
            System.out.println("Person not found.");
        }

        // List all people after updates
        dataManager.list();
    }
}

/*
 * This admin class will add , remove , update of Persons Objects.
 * Like Simply when u take an admition into a school as Student or Need a job.
 * 
 * 
 * 
 */

import Routers.DataManager;
import src.Teacher;
import src.Student;
import src.NonTeachingStaff;
import src.Person;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.IOException;

public class Admin {
    DataManager dataManager;
    Scanner scanner;

    public Admin() {
        dataManager = new DataManager();
        scanner = new Scanner(System.in);
    }

    public void clear() {
        try {
            // Detect the operating system
            String os = System.getProperty("os.name").toLowerCase();

            // Execute the appropriate command
            if (os.contains("win")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Failed to clear the terminal: " + ex.getMessage());
        }
    }

    public LocalDate dob_input() {
        while (true) {
            try {
                System.out.println("Enter your date of birth (format: yyyy-MM-dd): ");
                String dateOfBirth = scanner.nextLine().trim();

                // Split the input into year, month, and day
                String[] dob = dateOfBirth.split("-");

                // Check if the input has the correct format (yyyy-MM-dd)
                if (dob.length != 3) {
                    System.out.println("Invalid format. Please ensure it's in yyyy-MM-dd format.");
                    continue;
                }

                // Format the month and day to be two digits
                String year = dob[0];
                String month = String.format("%02d", Integer.parseInt(dob[1])); // Ensure two-digit month
                String day = String.format("%02d", Integer.parseInt(dob[2])); // Ensure two-digit day

                String formattedDate = year + "-" + month + "-" + day;

                System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);
                System.out.print("Is this correct? (yes/no): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();

                if (confirmation.equals("yes")) {
                    // Parse the formatted string into a LocalDate object
                    LocalDate parsedDate = LocalDate.parse(formattedDate);
                    System.out.println("Date of Birth confirmed as: " + parsedDate);
                    return parsedDate;
                } else {
                    System.out.println("Let's try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date in yyyy-MM-dd format.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please ensure the month and day are valid.");
            }
        }
    }

    private void choice(int option1, String option2) {
        if (option1 == 1) { // Add
            if (option2.equalsIgnoreCase(dataManager.STUDENT)) { // Add Student
                System.out.println("Adding new student...");
                System.out.print("Enter student name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Enter student contact: ");
                String contact = scanner.nextLine().trim();
                System.out.print("Enter student standard/class: ");
                String standard = scanner.nextLine().trim();
                LocalDate dob = dob_input();

                Student student = new Student(name, dob, contact, dataManager.getNewID(dataManager.STUDENT), standard);
                dataManager.add(student);
                System.out.println("Student added successfully!");

            } else if (option2.equalsIgnoreCase(dataManager.TEACHER)) { // Add Teacher
                System.out.println("Adding new teacher...");
                System.out.print("Enter teacher name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Enter teacher contact: ");
                String contact = scanner.nextLine().trim();
                System.out.print("Enter teacher subject: ");
                String subject = scanner.nextLine().trim();
                LocalDate dob = dob_input();

                Teacher teacher = new Teacher(name, dob, contact, dataManager.getNewID(dataManager.TEACHER), subject);
                dataManager.add(teacher);
                System.out.println("Teacher added successfully!");

            } else if (option2.equalsIgnoreCase(dataManager.NTS)) { // Add NonTeachingStaff
                System.out.println("Adding new non-teaching staff...");
                System.out.print("Enter staff name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Enter staff contact: ");
                String contact = scanner.nextLine().trim();
                System.out.print("Enter staff designation: ");
                String designation = scanner.nextLine().trim();
                LocalDate dob = dob_input();

                NonTeachingStaff staff = new NonTeachingStaff(name, dob, contact, dataManager.getNewID(dataManager.NTS),
                        designation);
                dataManager.add(staff);
                System.out.println("Non-teaching staff added successfully!");
            } else {
                System.out.println("Invalid choice for Add operation.");
            }
        } else if (option1 == 2) { // Update
            System.out.println("Updating person...");
            System.out.print("Enter person ID to update: ");
            String personId = scanner.nextLine().trim();
            Person person = dataManager.findByID(personId);

            if (person != null) {
                System.out.println("Found: " + person);
                System.out.print("Enter new name (leave blank to keep unchanged): ");
                String newName = scanner.nextLine().trim();
                System.out.print("Enter new contact (leave blank to keep unchanged): ");
                String newContact = scanner.nextLine().trim();

                if (!newName.isEmpty())
                    person.setName(newName);
                if (!newContact.isEmpty())
                    person.setContact(newContact);

                System.out.println("Details updated successfully!");
            } else {
                System.out.println("Person not found.");
            }

        } else if (option1 == 3) { // Remove
            System.out.println("Removing person...");
            System.out.print("Enter person ID to remove: ");
            String personId = scanner.nextLine().trim();
            boolean removed = dataManager.remove(personId);

            if (removed) {
                System.out.println("Person removed successfully!");
            } else {
                System.out.println("Person not found.");
            }

        } else if (option1 == 4) { // Search
            System.out.println("Searching person...");
            System.out.print("Enter person name or ID to search: ");
            String query = scanner.nextLine().trim();
            Person person = dataManager.find(query);

            if (person != null) {
                System.out.println("Found: " + person);
            } else {
                System.out.println("No matching person found.");
            }

        } else {
            System.out.println("Invalid operation. Please choose a valid option.");
        }
    }

    private void askForChoice() {
        while (true) {

            System.out.println("\nChoose an option:");
            System.out.println("0. Exit");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Remove");
            System.out.println("4. Search");
            System.out.print("Enter your choice: ");

            String firstChoice = scanner.nextLine().trim();

            // Handle exit case
            if (firstChoice.equals("0")) {
                System.out.println("Exiting...");
                break;
            }
            if (firstChoice.equals("clear")) {
                clear();
                continue;
            }

            switch (firstChoice) {
                case "1": // Add
                    System.out.println("\nChoose type to add:");
                    System.out.println("1. Student");
                    System.out.println("2. Teacher");
                    System.out.println("3. Non-Teaching Staff");
                    System.out.print("Enter your choice: ");
                    String addChoice = scanner.nextLine().trim();
                    choice(1, switch (addChoice) {
                        case "1" -> dataManager.STUDENT;
                        case "2" -> dataManager.TEACHER;
                        case "3" -> dataManager.NTS;
                        default -> {
                            System.out.println("Invalid choice.");
                            yield ""; // Returning an empty string if invalid choice
                        }
                    });
                    break;
                case "2": // update
                case "3": // Remove
                case "4": // Search
                    choice(Integer.valueOf(firstChoice), null);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Admin myobj = new Admin();
        try {
            myobj.askForChoice();
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }

}
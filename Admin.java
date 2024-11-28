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

public class Admin {
    DataManager dataManager;
    Scanner scanner;

    public Admin() {
        dataManager = new DataManager();
        scanner = new Scanner(System.in);
    }

    public LocalDate dob_input() {
        while (true) {
            try {
                System.out.println("Enter your date of birth (format: yyyy-MM-dd): ");
                String dateOfBirth = scanner.nextLine().trim();
                String[] dob = dateOfBirth.split("-");

                if (dob.length != 3) {
                    System.out.println("Invalid format. Please ensure it's in yyyy-MM-dd format.");
                    continue;
                }

                System.out.println("Year: " + dob[0] + ", Month: " + dob[1] + ", Day: " + dob[2]);
                System.out.print("Is this correct? (yes/no): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();

                if (confirmation.equals("yes")) {
                    // Parse the input into a LocalDate object
                    LocalDate parsedDate = LocalDate.parse(dateOfBirth);
                    System.out.println("Date of Birth confirmed as: " + parsedDate);
                    return parsedDate;
                } else {
                    System.out.println("Let's try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date in yyyy-MM-dd format.");
            }
        }
    }

    private void choice(int option1, String option2) {
        // add
        if (option1 == 1) { // student
            System.out.println("Adding new student...");
            System.out.print("Enter student name : ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter student contact : ");
            String contact = scanner.nextLine().trim();
            System.out.print("Enter student standard/class : ");
            String standard = scanner.nextLine().trim();
            // System.out.print("Enter student date Of Birth [YYYY-MM-DD]: ");
            LocalDate dob = dob_input();

        } else if (option1 == 2) { // techer

        } else if (option1 == 3) { // NonTeachingStaff

        } else if (option1 == 4) {
        } else if (option1 == 5) {
        } else if (option1 == 6) {
        } else if (option1 == 7) {
        } else if (option1 == 8) {
        } else if (option1 == 9) {
        }
    }

    private void askForChoice() {
        System.out.println("0.Exit 1.Add \n2. Update \n3. Remove\n 4. Search");
        System.out.print("Enter your choice : ");
        String first_choice = scanner.nextLine().trim();
        if (first_choice != "0" && first_choice != "4") {
            System.out.println("1.Student \n2.Teacher \n3. NonTeachingStaff");
            System.out.print("Enter your choice : ");
            String second_choice = scanner.nextLine().trim();

        }
        if (first_choice == "4") {
            choice(Integer.valueOf(first_choice));
        }
        System.out.println("Exit....");
    }

    public static void main(String[] args) {

    }

}
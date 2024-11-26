import java.time.LocalDate;
import src.*;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice", LocalDate.of(1985, 3, 10), "alice@example.com", "T001", "Mathematics");
        NonTeachingStaff staff = new NonTeachingStaff("Bob", LocalDate.of(1978, 7, 5), "bob@example.com", "S001",
                "Administration");
        Student student = new Student("Charlie", LocalDate.of(2005, 9, 20), "charlie@example.com", "ST123",
                "10th Grade");

        // Display roles
        teacher.role();
        staff.role();
        student.role();

        // Print details
        System.out.println(teacher);
        System.out.println(staff);
        System.out.println(student);
    }
}

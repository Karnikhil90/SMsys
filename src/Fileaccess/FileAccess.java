package src.Fileaccess;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import src.memebers.Person;

public class FileAccess {
    /**
     * FileAccess Class
     * 
     * This class provides methods to read and write data to files in a directory.
     * It ensures the existence of the directory before performing operations and
     * handles exceptions to prevent application stoppage.
     * 
     * Features:
     * 1. Default file path: `./database/`
     * 2. File naming convention: `{Object class name}.txt`
     * Example: `Student.txt`, `Teacher.txt`
     * 3. Ensures directory existence on initialization.
     * 4. Methods to read and write data:
     * - Write individual strings or objects (append or overwrite).
     * - Read data as raw string, list of maps, or structured data for class
     * mapping.
     */

    private String filepath;

    // Constructor with default filepath
    public FileAccess() {
        this("./database");
    }

    // Constructor with specific filepath
    public FileAccess(String filepath) {
        this.filepath = filepath;
        ensureDirectoryExists();
    }

    // Ensures the directory exists
    private void ensureDirectoryExists() {
        try {
            Files.createDirectories(Paths.get(filepath));
        } catch (IOException e) {
            System.err.println("Error ensuring directory exists: " + e.getMessage());
        }
    }

    // Write object to file (overwrite)
    public void write(String fileName, Object obj) {
        try (FileWriter writer = new FileWriter(getFilePath(fileName))) {
            writer.write(obj.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Append object to file
    public void append(String fileName, Object obj) {
        try (FileWriter writer = new FileWriter(getFilePath(fileName), true)) {
            writer.write(obj.toString() + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    // Write Person object to a file (name based on class name)
    public void write(Person person) {
        String className = person.getClass().getSimpleName(); // Get the class name
        write(className + ".txt", person.toString());
    }

    // Read file content as a raw string
    public String read(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(getFilePath(fileName))));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    // Read file content as a list of maps (assumes data is formatted appropriately)
    public List<Map<String, String>> readAsListOfMaps(String fileName) {
        List<Map<String, String>> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Map<String, String> record = new HashMap<>();
                String[] keyValuePairs = line.split(",");
                for (String pair : keyValuePairs) {
                    String[] entry = pair.split("=");
                    record.put(entry[0].trim(), entry[1].trim());
                }
                records.add(record);
            }
        } catch (IOException e) {
            System.err.println("Error reading file as list of maps: " + e.getMessage());
        }
        return records;
    }

    // Read file content as a map of classType to list of maps
    public Map<String, List<Map<String, String>>> readAsStructuredData(String fileName) {
        Map<String, List<Map<String, String>>> structuredData = new HashMap<>();
        try {
            List<Map<String, String>> records = readAsListOfMaps(fileName);
            structuredData.put(getClassName(fileName), records);
        } catch (Exception e) {
            System.err.println("Error reading file as structured data: " + e.getMessage());
        }
        return structuredData;
    }

    // Utility method to get the full file path
    private String getFilePath(String fileName) {
        return filepath + File.separator + fileName;
    }

    // Utility method to extract class name from file name
    private String getClassName(String fileName) {
        return fileName.replace(".txt", "");
    }

    public static void main(String[] args) {
        Map<String, Object> student1Props = Map.of(
                "name", "Alice",
                "dob", "2000-01-15",
                "contact", "1234567890");
        FileAccess fileAccess = new FileAccess();

        // Example Usage with a Person object
        Person student = new Person(student1Props);
        fileAccess.write(student);

        String content = fileAccess.read("Person.txt");
        System.out.println("Raw Content from Person.txt:\n" + content);
    }
}

import java.util.*;
public class UniversityEnrollmentSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Map<String, Course> courses = new HashMap<>();
        Map<String, Set<String>> studentRecords = new HashMap<>();
        courses.put("Core Java", new Course("Core Java", "", 3));
        courses.put("Advanced Java", new Course("Advanced Java", "Core Java", 2));
        while (true) 
        {
            System.out.println("\nUniversity Enrollment System");
            System.out.println("1. Enroll in a Course");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 2) 
            {
                System.out.println("Exiting...");
                break;
            }
            System.out.print("Enter Student Name: ");
            String studentName = sc.nextLine();
            System.out.print("Enter Course Name: ");
            String courseName = sc.nextLine();
            if (!courses.containsKey(courseName)) 
            {
                System.out.println("Error: Course not found.");
                continue;
            }
            studentRecords.putIfAbsent(studentName, new HashSet<>());
            try 
            {
                courses.get(courseName).enrollStudent(studentName, studentRecords.get(studentName));
                studentRecords.get(studentName).add(courseName);
            } 
            catch (CourseFullException | PrerequisiteNotMetException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}

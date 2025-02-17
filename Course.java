import java.util.*;
class Course 
{
    private String name;
    private String prerequisite;
    private int maxEnrollment;
    private Set<String> enrolledStudents;
    public Course(String name, String prerequisite, int maxEnrollment) 
    {
        this.name = name;
        this.prerequisite = prerequisite;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = new HashSet<>();
    }
    public String getName() 
    {
        return name;
    }
    public String getPrerequisite() 
    {
        return prerequisite;
    }
    public void enrollStudent(String student, Set<String> completedCourses) throws CourseFullException, PrerequisiteNotMetException 
    {
        if (enrolledStudents.size() >= maxEnrollment) 
        {
            throw new CourseFullException("Course is full: " + name);
        }
        if (!prerequisite.isEmpty() && !completedCourses.contains(prerequisite)) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + name);
        }
        enrolledStudents.add(student);
        System.out.println("Enrollment successful! " + student + " is now enrolled in " + name);
    }
}
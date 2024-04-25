import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String contactNumber;

	public Student(int id, String firstName, String lastName, String contactNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
	}

	// Getter methods
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	// Setter methods
	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}

class Subject {
	private String name;
	private int marks;
	private double fees;

	// Constructor
	public Subject(String name, int marks, double fees) {
		this.name = name;
		this.marks = marks;
		this.fees = fees;
	}

	// Getter methods
	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}

	public double getFees() {
		return fees;
	}

	// Setter methods
	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
}

public class StudentManagementSystem {
	private List<Student> students;
	private List<Subject> subjects;
	private Scanner scanner;

	public StudentManagementSystem() {
		students = new ArrayList<>();
		subjects = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void addStudentMarks() {
		System.out.println("ADD student Marks:");
		try {

			System.out.print("Enter Subject name: ");
			String name = scanner.nextLine();
			scanner.nextLine(); // Clear newline character

			System.out.print("Enter Marks: ");
			int marks = scanner.nextInt();

			System.out.print("Enter Fees: ");
			double fees = scanner.nextDouble();

			subjects.add(new Subject(name, marks, fees));

//            students.add(new Student( firstName, lastName, contactNumber));
			System.out.println("----------Student Marks added successfully!---------------");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter numeric ID.");
		}
	}

	public void addStudent() {
		System.out.println("Enter student details:");
		try {
			System.out.print("ID: ");
			int id = scanner.nextInt();
			scanner.nextLine(); // Clear newline character

			System.out.print("First Name: ");
			String firstName = scanner.nextLine();

			System.out.print("Last Name: ");
			String lastName = scanner.nextLine();

			System.out.print("Contact Number: ");
			String contactNumber = scanner.nextLine();

			students.add(new Student(id, firstName, lastName, contactNumber));
			System.out.println("----------Student added successfully!---------------");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter numeric ID.");
		}
	}

	public void viewAllStudents() {
		System.out.println("All Students:");
		for (Student student : students) {
			System.out.println("Student ID: " + student.getId());
			System.out.println("Student Name:" + student.getFirstName() + " " + student.getLastName());
			System.out.println("Contact Numbetr: " + student.getContactNumber());
		}
	}

	public void viewsubjectmarks() {
		System.out.println("All Students:");
		for (Subject subject : subjects) {
			System.out.println("Subject Name: " + subject.getName());
			System.out.println("Subject marks:" + subject.getMarks());
			System.out.println("Subject Fees: " + subject.getFees());
		}
	}

	public void viewSpecificStudent() {
		System.out.print("Enter student ID to view: ");
		int idToSearch = scanner.nextInt();
		scanner.nextLine(); // Clear newline character

		for (Student student : students) {
			if (student.getId() == idToSearch) {
				System.out.println("Student Details:");
				System.out.println("ID: " + student.getId());
				System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
				System.out.println("Contact Number: " + student.getContactNumber());
				return;
			}
		}
		System.out.println("Student with ID " + idToSearch + " not found.");
	}

	public void removeStudent() {
		System.out.print("Enter student ID to remove: ");
		int idToRemove = scanner.nextInt();
		scanner.nextLine(); // Clear newline character

		for (Student student : students) {
			if (student.getId() == idToRemove) {
				students.remove(student);
				System.out.println("Student removed successfully!");
				return;
			}
		}
		System.out.println("Student with ID " + idToRemove + " not found.");
	}

	public static void CounsellorMenu() {
		StudentManagementSystem system = new StudentManagementSystem();
		boolean exit = false;

		while (!exit) {
			System.out.println("\nStudent Management System Menu:");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. View Specific Student");
			System.out.println("4. Remove Student");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = system.scanner.nextInt();
			system.scanner.nextLine(); // Clear newline character

			switch (choice) {
			case 1:
				system.addStudent();
				break;
			case 2:
				system.viewAllStudents();
				break;
			case 3:
				system.viewSpecificStudent();
				break;
			case 4:
				system.removeStudent();
				break;
			case 5:
				exit = true;
				System.out.println("Exiting Student Management System. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}
	}

	public static void FacultyMenu() {
		System.out.println();
		StudentManagementSystem system = new StudentManagementSystem();
		boolean exit = false;

		while (!exit) {
			System.out.println("\nStudent Management System faculty Menu:");
			System.out.println("1. Add Marks to Student");
			System.out.println("2. View All Students");
			System.out.println("3. Exit");

			System.out.print("Enter your choice: ");
			int choice = system.scanner.nextInt();
			switch (choice) {
			case 1:
				system.addStudentMarks();
				break;
			case 2:
				system.viewsubjectmarks();
				break;
			case 3:
				exit = true;
				System.out.println("Exiting Student Management System. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}
	}

	public static void StudentMenu() {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Counsellor");
		System.out.println("2. faculty");
		System.out.println("3. student");
		System.out.println("Enter choice");
		int choice1 = sc.nextInt();
		if (choice1 >= 1 && choice1 <= 3) {
			if (choice1 == 1) {
				StudentManagementSystem.CounsellorMenu();
			} else if (choice1 == 2) {
				StudentManagementSystem.FacultyMenu();
			} else if (choice1 == 3) {
				StudentManagementSystem.StudentMenu();
			}
		} else {
			System.out.println("Enter a valid choice 1 to 3");
		}

	}
}

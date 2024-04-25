
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
	private ArrayList<Student> students;
	private Scanner scanner;

	public StudentManagementSystem() {
		this.students = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}

	public void addStudent(int select) {
		
		 System.out.println("Adding a new student:");
		    System.out.print("Enter serial number: ");
		    int serialNumber = scanner.nextInt();
		    scanner.nextLine(); // Clear input buffer

		    System.out.print("Enter first name: ");
		    String firstName = scanner.nextLine();

		    System.out.print("Enter last name: ");
		    String lastName = scanner.nextLine();

		    System.out.print("Enter contact number: ");
		    String contactNumber = scanner.nextLine();

		    // Create a new Student object
		    Student newStudent = new Student(serialNumber, firstName, lastName, contactNumber);
		    students.add(newStudent);

		    System.out.println("Student added successfully!");
		    run();
		// Implementation for adding a student
	}

	public void removeStudent(int select) {
		
	}

	public void viewAllStudents(int select) {
		
	}

	public void viewSpecificStudent(int select) {
		
		// Implementation for viewing a specific student
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 for Counsellor");
		System.out.println("press 2 for Faculty");
		System.out.println("press 3 for Student");

		System.out.print("Enter A Role ID : ");
		int choice = sc.nextInt();

		if (choice >= 1 && choice <= 3) {
			if (choice == 1) {
				System.out.println("1. Add Student");
				System.out.println("2. Remove Student");
				System.out.println("3. View All Student");
				System.out.println("4. View Specific Student");
				System.out.print("Enter Choice for Counsellor");
				int select = sc.nextInt();
				if (select == 1) {
					StudentManagementSystem sms = new StudentManagementSystem();
					sms.addStudent(select);
				}
				else if(select == 2) {
					StudentManagementSystem sms = new StudentManagementSystem();
					sms.removeStudent(select);
				}
				else if(select == 3) {
					StudentManagementSystem sms = new StudentManagementSystem();
					sms.viewAllStudents(select);
				}
				else if(select == 4) {
					StudentManagementSystem sms = new StudentManagementSystem();
					sms.viewSpecificStudent(select);
				}

			} else if (choice == 2) {
				

			} else if (choice == 3) {
				
			}

		} else {
			System.out.println("Enter a valid choice 1 To 3");
			run();
		}

	}

	public static void main(String[] args) {
		StudentManagementSystem sms = new StudentManagementSystem();
		sms.run();
	}
}
//, getters, setters, and other methods for Student
class Student {
	private int serialNumber;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private ArrayList<Subject> subjects;
	public Student(int serialNumber2, String firstName2, String lastName2, String contactNumber2) {
		// TODO Auto-generated constructor stub
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Student [serialNumber=" + serialNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", subjects=" + subjects + "]";
	}
}
//, getters, setters, and other methods for Subject
class Subject {
	private String name;
	private int marks;
	private double fees;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + ", marks=" + marks + ", fees=" + fees + "]";
	}

	
}

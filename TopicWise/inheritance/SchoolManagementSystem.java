// Top-level class: Organisation (Base Class)
class Organisation {
    private String orgName;

    // Constructor
    public Organisation(String orgName) {
        this.orgName = orgName;
    }

    // Getter
    public String getOrgName() {
        return orgName;
    }

    // Display Organisation details
    void showOrganisationDetails() {
        System.out.println("Organisation: " + orgName);
    }

    // Method to print inheritance flow
    void printInheritanceFlow() {
        System.out.println("Organisation");
    }
}

// School class extends Organisation (Single Inheritance)
class School extends Organisation {
    private String schoolName;

    // Constructor
    public School(String orgName, String schoolName) {
        super(orgName);
        this.schoolName = schoolName;
    }

    // Display School details
    void showSchoolDetails() {
        super.showOrganisationDetails();
        System.out.println("School: " + schoolName);
    }

    // Override to show inheritance flow
    @Override
    void printInheritanceFlow() {
        super.printInheritanceFlow();
        System.out.println("  ├── School");
    }
}

// Employee class extends School (Single Inheritance)
class Employee extends School {
    private String empName;
    private int empId;
    private double salary;

    // Constructor
    public Employee(String orgName, String schoolName, String empName, int empId, double salary) {
        super(orgName, schoolName);
        this.empName = empName;
        this.empId = empId;
        this.salary = salary;
    }

    // Display Employee details
    void showEmployeeDetails() {
        super.showSchoolDetails();
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Salary: $" + salary);
    }

    // Override to show inheritance flow
    @Override
    void printInheritanceFlow() {
        super.printInheritanceFlow();
        System.out.println("  │   ├── Employee");
    }
}

// Teacher class extends Employee (Multi-Level Inheritance)
class Teacher extends Employee {
    private String subject;

    // Constructor
    public Teacher(String orgName, String schoolName, String empName, int empId, double salary, String subject) {
        super(orgName, schoolName, empName, empId, salary);
        this.subject = subject;
    }

    // Display Teacher details
    void showTeacherDetails() {
        super.showEmployeeDetails();
        System.out.println("Subject: " + subject);
    }

    // Override to show inheritance flow
    @Override
    void printInheritanceFlow() {
        super.printInheritanceFlow();
        System.out.println("  │   │   ├── Teacher");
    }
}

// Principal class extends Teacher (Multi-Level Inheritance)
class Principal extends Teacher {
    private int experience;

    // Constructor
    public Principal(String orgName, String schoolName, String empName, int empId, double salary, String subject, int experience) {
        super(orgName, schoolName, empName, empId, salary, subject);
        this.experience = experience;
    }

    // Display Principal details
    void showPrincipalDetails() {
        super.showTeacherDetails();
        System.out.println("Experience: " + experience + " years");
    }

    // Override to show inheritance flow
    @Override
    void printInheritanceFlow() {
        super.printInheritanceFlow();
        System.out.println("  │   │   │   ├── Principal");
    }
}

// Staff class extends Employee (Hierarchical Inheritance)
class Staff extends Employee {
    private String department;

    // Constructor
    public Staff(String orgName, String schoolName, String empName, int empId, double salary, String department) {
        super(orgName, schoolName, empName, empId, salary);
        this.department = department;
    }

    // Display Staff details
    void showStaffDetails() {
        super.showEmployeeDetails();
        System.out.println("Department: " + department);
    }

    // Override to show inheritance flow
    @Override
    void printInheritanceFlow() {
        super.printInheritanceFlow();
        System.out.println("  │   │   ├── Staff");
    }
}

// Accountant class extends Employee (Hierarchical Inheritance)
class Accountant extends Employee {
    private String specialization;

    // Constructor
    public Accountant(String orgName, String schoolName, String empName, int empId, double salary, String specialization) {
        super(orgName, schoolName, empName, empId, salary);
        this.specialization = specialization;
    }

    // Display Accountant details
    void showAccountantDetails() {
        super.showEmployeeDetails();
        System.out.println("Specialization: " + specialization);
    }

    // Override to show inheritance flow
    @Override
    void printInheritanceFlow() {
        super.printInheritanceFlow();
        System.out.println("  │   │   ├── Accountant");
    }
}

// Main class to execute the system
public class SchoolManagementSystem {
    public static void main(String[] args) {
        // Creating Principal object
        Principal principal = new Principal("CDAC Chennai", "Chennai", "Dr. kuhan", 1001, 120000, "Administration", 15);
        System.out.println("---- Principal Details ----");
        principal.showPrincipalDetails();
        System.out.println("\n========\nPrincipal Hierarchy:\n========\n");
        principal.printInheritanceFlow();

        // Creating Staff object
        Staff staff = new Staff("CDAC Chennai", "Chennai", "Mr. thayu", 2001, 50000, "Library");
        System.out.println("\n---- Staff Details ----");
        staff.showStaffDetails();
        System.out.println("\n========\nStaff Hierarchy:\n========\n");
        staff.printInheritanceFlow();

        // Creating Accountant object
        Accountant accountant = new Accountant("CDAC Chennai", "Chennai", "Ms. kailash", 3001, 60000, "Finance");
        System.out.println("\n---- Accountant Details ----");
        accountant.showAccountantDetails();
        System.out.println("\n========\nAccountant Hierarchy:\n========\n");
        accountant.printInheritanceFlow();

        // Print Inheritance Flowchart
        System.out.println("\n============\nEntire System Hierarchy:\n============\n");
        principal.printInheritanceFlow();
        staff.printInheritanceFlow();
        accountant.printInheritanceFlow();
    }
}

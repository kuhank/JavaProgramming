// Parent class: Employee
class Employee {

    //instance variable
    
    String name;
    int empId;
    double salary;

    // Constructor
    Employee(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
    void displayDetails(String customText, String Desgination) {
        System.out.println("\n========\n"+customText);
        System.out.println(Desgination + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }

}

// Child class: Manager (inherits from Employee)
class Manager extends Employee {
    String department;

    // Constructor
    Manager(String name, int empId, double salary, String department) {
        super(name, empId, salary); // Calling parent class constructor
        this.department = department;
    }

    // Overriding method to display manager details
    @Override
    void displayDetails() {
        super.displayDetails("Manager details and Department Details", "Manager head ID: "); // Calling parent method
        System.out.println("Department: " + department);
    }

    @Override
    void displayDetails(String customtext, String Desgination) {
        super.displayDetails(customtext, Desgination); // Calling parent method
        System.out.println("Department: " + department);
    }

}

// Subclass: DepartmentHead (inherits from Manager)
class DepartmentHead extends Manager {
    int teamSize;

    // Constructor
    DepartmentHead(String name, int empId, double salary, String department, int teamSize) {
        super(name, empId, salary, department); // Calling Manager constructor
        this.teamSize = teamSize;
    }

    // Overriding method to display department head details
    @Override
    void displayDetails() {
        super.displayDetails("Department Head Details", "Department Head ID: ");
        System.out.println("Team Size: " + teamSize);
    }
}

public class EmployeeManagerSystem {
    public static void main(String[] args) {
        // Creating an Employee object
        Employee emp1 = new Employee("kuhan", 101, 50000);
        emp1.displayDetails();
        
        // System.out.println("-------------------");

        // Creating a Manager object
        Manager mgr1 = new Manager("thayu", 201, 80000, "IT");
        mgr1.displayDetails();

        DepartmentHead deptHead1 = new DepartmentHead("kailash", 301, 100000, "IT", 10);
        deptHead1.displayDetails();
    }
}

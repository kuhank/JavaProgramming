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
    void displayDetails(String customText) {
        System.out.println(customText);
        System.out.println("Manager ID: " + empId);
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
        super.displayDetails("Manager details and Department Details"); // Calling parent method
        System.out.println("Department: " + department);
    }
}

public class EmployeeManagerSystem {
    public static void main(String[] args) {
        // Creating an Employee object
        Employee emp1 = new Employee("kuhan", 101, 50000);
        emp1.displayDetails();
        
        System.out.println("-------------------");

        // Creating a Manager object
        Manager mgr1 = new Manager("thayu", 201, 80000, "IT");
        mgr1.displayDetails();
    }
}

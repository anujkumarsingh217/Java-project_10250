//Anuj kumar singh
//erp-10250

// ============================================================
//  Employee Payroll System - Single File Version
// ============================================================

abstract class Employee {

    protected String name;
    protected int id;
    protected double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("------------------------------------------");
        System.out.println("Employee Name    : " + name);
        System.out.println("Employee ID      : " + id);
        System.out.printf("Calculated Salary: Rs. %.2f%n", calculateSalary());
        System.out.println("------------------------------------------");
    }

    public String getName() {
        return name;
    }
}

// ============================================================
// Full-Time Employee Class
// ============================================================

class FullTimeEmployee extends Employee {

    private final double bonus;
    private double allowances;

    public FullTimeEmployee(String name, int id,
                            double baseSalary,
                            double bonus, double allowances) {
        super(name, id, baseSalary);
        this.bonus = bonus;
        this.allowances = allowances;
    }

    public FullTimeEmployee(double bonus, String name, int id, double baseSalary) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus + allowances;
    }

    @Override
    public void displayDetails() {
        System.out.println("------------------------------------------");
        System.out.println("Employee Type    : Full-Time Employee");
        System.out.println("Employee Name    : " + name);
        System.out.println("Employee ID      : " + id);
        System.out.printf("Base Salary      : Rs. %.2f%n", baseSalary);
        System.out.printf("Bonus            : Rs. %.2f%n", bonus);
        System.out.printf("Allowances       : Rs. %.2f%n", allowances);
        System.out.printf("Total Salary     : Rs. %.2f%n", calculateSalary());
        System.out.println("------------------------------------------");
    }
}

// ============================================================
// Part-Time Employee Class
// ============================================================

class PartTimeEmployee extends Employee {

    private final int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id,
                            double baseSalary,
                            int hoursWorked, double hourlyRate) {
        super(name, id, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayDetails() {
        System.out.println("------------------------------------------");
        System.out.println("Employee Type    : Part-Time Employee");
        System.out.println("Employee Name    : " + name);
        System.out.println("Employee ID      : " + id);
        System.out.printf("Hours Worked     : %d hrs%n", hoursWorked);
        System.out.printf("Hourly Rate      : Rs. %.2f%n", hourlyRate);
        System.out.printf("Total Salary     : Rs. %.2f%n", calculateSalary());
        System.out.println("------------------------------------------");
    }
}

// ============================================================
// Main Class (Only public class allowed in one file)
// ============================================================

public class PayRollSystem {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   EMPLOYEE PAYROLL MANAGEMENT SYSTEM    ");
        System.out.println("==========================================");

        Employee e1 = new FullTimeEmployee("Rahul Sharma", 101, 40000, 8000, 5000);
        Employee e2 = new FullTimeEmployee("Priya Singh", 102, 35000, 6000, 4500);
        Employee e3 = new PartTimeEmployee("Amit Verma", 103, 0, 120, 150);
        Employee e4 = new PartTimeEmployee("Neha Gupta", 104, 0, 80, 200);

        Employee[] employees = {e1, e2, e3, e4};

        System.out.println("\n========== PAYROLL DETAILS ===============");

        for (Employee emp : employees) {
            emp.displayDetails();
        }

        System.out.println("\n========== SALARY SUMMARY ===============");

        double totalPayroll = 0;

        for (Employee emp : employees) {
            System.out.printf("%-20s -> Rs. %.2f%n",
                    emp.getName(), emp.calculateSalary());
            totalPayroll += emp.calculateSalary();
        }

        System.out.println("------------------------------------------");
        System.out.printf("Total Payroll Expense : Rs. %.2f%n", totalPayroll);
        System.out.println("==========================================");
    }
}

// ==========================================
//    EMPLOYEE PAYROLL MANAGEMENT SYSTEM    
// ==========================================

// ========== PAYROLL DETAILS ===============
// ------------------------------------------
// Employee Type    : Full-Time Employee
// Employee Name    : Rahul Sharma
// Employee ID      : 101
// Base Salary      : Rs. 40000.00
// Bonus            : Rs. 8000.00
// Allowances       : Rs. 5000.00
// Total Salary     : Rs. 53000.00
// ------------------------------------------
// ------------------------------------------
// Employee Type    : Full-Time Employee
// Employee Name    : Priya Singh
// Employee ID      : 102
// Base Salary      : Rs. 35000.00
// Bonus            : Rs. 6000.00
// Allowances       : Rs. 4500.00
// Total Salary     : Rs. 45500.00
// ------------------------------------------
// ------------------------------------------
// Employee Type    : Part-Time Employee
// Employee Name    : Amit Verma
// Employee ID      : 103
// Hours Worked     : 120 hrs
// Hourly Rate      : Rs. 150.00
// Total Salary     : Rs. 18000.00
// ------------------------------------------
// ------------------------------------------
// Employee Type    : Part-Time Employee
// Employee Name    : Neha Gupta
// Employee ID      : 104
// Hours Worked     : 80 hrs
// Hourly Rate      : Rs. 200.00
// Total Salary     : Rs. 16000.00
// ------------------------------------------

// ========== SALARY SUMMARY ===============
// Rahul Sharma         -> Rs. 53000.00
// Priya Singh          -> Rs. 45500.00
// Amit Verma           -> Rs. 18000.00
// Neha Gupta           -> Rs. 16000.00
// ------------------------------------------
// Total Payroll Expense : Rs. 132500.00
// ==========================================
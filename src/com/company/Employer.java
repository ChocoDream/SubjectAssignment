package com.company;
import com.company.utilities.Utility;

public class Employer extends Staff{

    public Employer(String name){
        super(name);
    }

    public Employee hireEmployee(){
        String name;
        System.out.println("Name of Person?");
        name = Utility.scanner.nextLine();
        return new Employee(name);
    }
    @Override
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }
}

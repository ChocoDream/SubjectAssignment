package com.company;

public class Employee extends Staff{

    Employee(String name){
        super( name);
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

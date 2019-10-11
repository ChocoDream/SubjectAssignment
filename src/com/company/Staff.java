package com.company;

public abstract class Staff extends Account {
    private int salary;
    private String name;

    Staff(String name){
        this.name = name;
        salary = -1;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return ("\tName: " + name);
    }
}

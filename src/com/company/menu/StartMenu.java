package com.company.menu;

import com.company.Customer;
import com.company.Employee;
import com.company.Employer;
import com.company.utilities.Utility;
import com.company.utilities.dataUtil;
import com.company.MenuState;

import java.util.ArrayList;

public class StartMenu{
    private Employer employer;
    private Customer customer;

    public StartMenu(ArrayList<Employer> employers){
        if (employers.isEmpty()) { //When there is no owner, this run
            String name; //Declaring name
            System.out.println("New owner of a new blacksmith found!");
            System.out.println("What's your name?");
            name = Utility.scanner.nextLine();

            System.out.println("What's the name of the blacksmith?");
            dataUtil.companyName = Utility.scanner.nextLine();
            employer = new Employer(name);

            System.out.printf("Wishes you best of luck with '%1$s', %2$s!\n", dataUtil.companyName, name);
        }
        System.out.println("Customer or Staff?");
        while (true){
            dataUtil.userInput = Utility.scanner.nextLine();
            if (dataUtil.userInput.toLowerCase().equals("customer")){
                customer = new Customer(Utility.generateRandomID(6));
                dataUtil.menuState = MenuState.CUSTOMERMENU;
                break;
            }
            else if (dataUtil.userInput.toLowerCase().equals("staff")){
                dataUtil.menuState = MenuState.STAFFMENU;
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }

    public Employer getEmployer(){
        return employer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
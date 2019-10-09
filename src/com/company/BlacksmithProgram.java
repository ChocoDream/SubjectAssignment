package com.company;

import java.util.ArrayList;

import com.company.menu.ExitMenu;
import com.company.menu.StartMenu;
import com.company.utilities.Utility;
import com.company.utilities.dataUtil;

public class BlacksmithProgram {
    public static final int MAX_EMPLOYERS = 2;

    private Shop shop = new Shop();

    BlacksmithProgram(){
        //Load files here

        //Runs until boolean 'isRunning' is false
        while (dataUtil.isRunning){
            switch (dataUtil.menuState) {
                case STARTMENU:
                    new StartMenu(dataUtil.employers);
                break;
                case CUSTOMERMENU:
                    customerMenu();
                break;
                case STAFFMENU:
                    staffMenu();
                break;
                case EMPLOYERMENU:
                    employerMenu();
                    break;
                case EMPLOYEEMENU:
                    employeeMenu();
                    break;
                case HELPMENU:
                    helpMenu();
                break;
                case EXITMENU:
                    new ExitMenu();
                break;
                default:
                    System.out.println("This option does not exist");
            }
        }
    }

    private void customerMenu() {
        int customer_ID;
        System.out.printf("Welcome to %1$s!\n" +
                "What would you like to do?\n" +
                "\t1. Check wares available\n" +
                "\t2. Check shopping bag\n" +
                "\t3. Proceed to checkout\n" +
                "\t4. Help\n" +
                "\t5. Exit Program\n", dataUtil.companyName);
        dataUtil.userInput = Utility.scanner.nextLine();
        switch (dataUtil.userInput) {
            case "1": //Show all products in products arrayList in shop
                shop.showAllProducts();
                break;
            case "2": //Print customer's shoppingCart.
                dataUtil.customers.get(0).showShoppingCart();
                break;
            case "3": //Write to imaginary server if this proceed okay which in this case is customerData
                dataUtil.customers.get(0).showShoppingCart();
                System.out.println("You wishes to check out and pay? (yes/no)");
                dataUtil.userInput = Utility.scanner.nextLine();
                if (dataUtil.userInput.equalsIgnoreCase("yes") || dataUtil.userInput.equalsIgnoreCase("y")){
                    System.out.printf("Your order have been sent to the blacksmith, %d!\n" +
                            "Thank you for ordering our wares at %s!\n", 0, dataUtil.companyName);
                    //Code here to write the customer's order to customerData.
                }
                else if (dataUtil.userInput.equalsIgnoreCase("no") || dataUtil.userInput.equalsIgnoreCase("n")){
                    System.out.println("Order canceled. Heading back to menu");
                }
                break;
            case "4":
                keepCurrentStateOnMenuChange(MenuState.HELPMENU); //Going to help menu
                return;
            case "5":
                keepCurrentStateOnMenuChange(MenuState.EXITMENU); //Going to exit program menu
                return;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private void staffMenu() {
        System.out.println("Employer or employee?");
        dataUtil.userInput = Utility.scanner.nextLine();
        if (dataUtil.userInput.toLowerCase().equals("employer")) {
                /*do{
                    System.out.println("Choose from list");
                    for (Employer employer : employers){

                    }
                }while (true);*/
            dataUtil.menuState = MenuState.EMPLOYERMENU;
        }
        else if (dataUtil.userInput.toLowerCase().equals("employee")) {
            if(!(dataUtil.employees.isEmpty())) { //If there are employees
                dataUtil.menuState = MenuState.EMPLOYEEMENU;
            }
            else { //No employees found
                System.out.println("No employees found.");
            }
        }
    }

    private void employerMenu() {
        System.out.println("What would you like to do?\n" +
                "\t1. Add Product\n" +
                "\t2. Edit Product\n" +
                "\t3. Hire employee\n" +
                "\t4. Show employers\n" +
                "\t5. Show employees\n" +
                "\t6. Return to start menu\n" +
                "\t7. Exit Program\n");
        dataUtil.userInput = Utility.scanner.nextLine();
        switch (dataUtil.userInput) {
            case "1": //Add product
                shop.addProduct();
                break;
            case "2": //Show all products to later modify
                shop.showAllProducts();

                break;
            case "3":
                dataUtil.employees.add(dataUtil.employers.get(0).hireEmployee());
                break;
            case "4":
                System.out.println("Printing employers for " + dataUtil.companyName);
                for (Employer employer : dataUtil.employers) {
                    System.out.println(employer + "\tSalary: " + employer.getSalary());
                    System.out.println("-------------------");
                }
                break;
            case "5":
                if (dataUtil.employees.isEmpty()) {
                    System.out.println("No employees found. Maybe hire a few employees?");
                } else {
                    System.out.println("Printing employees for " + dataUtil.companyName);
                    for (Employee employee : dataUtil.employees) {
                        System.out.println(employee + "\tSalary: " + employee.getSalary());
                        System.out.println("-------------------");
                    }
                }
                break;
            case "6":
                dataUtil.menuState = MenuState.STARTMENU;
                return;
            case "7":
                keepCurrentStateOnMenuChange(MenuState.EXITMENU); //Heading to Exit Menu
                return;
            default:
                System.out.println("Invalid option");
        }
    }

    private void employeeMenu() {
        System.out.println("What would you like to do?\n" +
                "\t1. Add product\n" +
                "\t2. Show products\n" +
                "\t3. Show employees\n" +
                "\t4. Check salary\n" +
                "\t5. Return to start menu\n" +
                "\t6. Exit Program\n");
        dataUtil.userInput = Utility.scanner.nextLine();
        switch (dataUtil.userInput) {
            case "1":
                shop.addProduct();
                break;
            case "2":
                shop.showAllProducts();
                break;
            case "3":
                for (Employee employee : dataUtil.employees){
                    System.out.println(employee);
                    System.out.println("-------------------");
                }
                break;
            case "4":

                break;
            case "5":
                dataUtil.menuState = MenuState.STARTMENU;
                break;
            case "6":
                keepCurrentStateOnMenuChange(MenuState.EXITMENU);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void startMenu(){
        if (dataUtil.employers.isEmpty()) { //When there is no owner, this run
            String name; //Declaring name
            System.out.println("New owner of a new blacksmith found!");
            System.out.println("What's your name?");
            name = Utility.scanner.nextLine();

            System.out.println("What's the name of the blacksmith?");
            dataUtil.companyName = Utility.scanner.nextLine();
            dataUtil.employers.add(new Employer(name));

            System.out.printf("Wishes you best of luck with '%1$s', %2$s!\n", dataUtil.companyName, name);
        }
        System.out.println("Customer or Staff?");
        while (true){
            dataUtil.userInput = Utility.scanner.nextLine();
            if (dataUtil.userInput.toLowerCase().equals("customer")){
                dataUtil.customers.add(new Customer(Utility.generateRandomID(6)));
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

    private void keepCurrentStateOnMenuChange(MenuState state) {
        dataUtil.previousMenuState = dataUtil.menuState;
        dataUtil.menuState = state;
    }

    private void helpMenu() {
        while (!(dataUtil.userInput.toLowerCase().startsWith("return"))){
            System.out.println("What can I help you with?\n" +
                    "\t1. The Program doesn't work!\n" +
                    "\t2. \n" +
                    "\t\n" +
                    "write 'return' to return to go back to previous menu");
            dataUtil.userInput = Utility.scanner.nextLine();
            switch (dataUtil.userInput){
                case "1":
                    System.out.println("BLABLABLA");
                    break;
                case "2":
                    System.out.println("BLEBLEBLA");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        dataUtil.menuState = dataUtil.previousMenuState;
    }
}

package com.company.utilities;

import com.company.Customer;
import com.company.Employee;
import com.company.Employer;
import com.company.MenuState;

import java.util.ArrayList;

public class dataUtil {
    public static String userInput;
    public static boolean isRunning = true;
    public static String companyName = "Hammy Smithy-CO";

    public static MenuState menuState = MenuState.STARTMENU;
    public static MenuState previousMenuState = menuState; //Used in conjunction with exit program and help menu.

    public static ArrayList<Employer> employers = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
}

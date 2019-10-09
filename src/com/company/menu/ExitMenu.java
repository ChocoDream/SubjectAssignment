package com.company.menu;

import com.company.utilities.dataUtil;
import com.company.utilities.Utility;
public class ExitMenu {
    public ExitMenu(){
        endProgramMenu();
    }

    private void endProgramMenu() {
        System.out.println("Want to end program? (y/n)");
        dataUtil.userInput = Utility.scanner.nextLine();
        if (dataUtil.userInput.toLowerCase().startsWith("y") || dataUtil.userInput.toLowerCase().startsWith("yes")) {
            dataUtil.isRunning = false;
        } else if (dataUtil.userInput.toLowerCase().startsWith("n") || dataUtil.userInput.toLowerCase().startsWith("no")) {
            dataUtil.menuState = dataUtil.previousMenuState; //Goes back to the menu the user was at
        } else {
            System.out.println("invalid choice");
        }
    }
}

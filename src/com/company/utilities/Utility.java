package com.company.utilities;

import java.util.Random;
import java.util.Scanner;

public class Utility {
    public static Random rnd = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static int generateRandomID(int length){
        String str = "";
        for (int i = 0; i < length; i++){
            str += rnd.nextInt(10);
        }
        return Integer.parseInt(str);
    }
}

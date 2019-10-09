package com.company;

import com.company.utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();
    Shop(){
        products.add(new Product("Hodor", 50, Type.Armor));
        products.add(new Product("hello", 30, Type.Axes));
        products.add(new Product("Mejow", 80, Type.Axes));
        products.add(new Product("klank klank", 50, Type.Blades));
        products.add(new Product("Alla snubbar", 30, Type.Armor));
        products.add(new Product("Den fruktade döden", 80, Type.Axes));
    }

    public void addProduct(){
        String name = "";
        int price = -1;
        Type type = null; //Makes a null, empty case of variables to later declare in a do while loop.

        do {
            System.out.println("Product name:");
            String input = Utility.scanner.nextLine();
            name = input;

            System.out.printf("Price on %s:\n", name);
            input = Utility.scanner.nextLine();
            try{
                price = Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Invalid price");
                continue;
            }

            System.out.print("Types of Products:"); //List all types
            for (Type type1 : Type.values()){
                System.out.print(" " + type1);
            }
            System.out.println();

            System.out.println("Type of product:");
            input = Utility.scanner.nextLine();
            try{
                type = Type.valueOf(input);
                break;
            }
            catch (Exception e){
                System.out.printf("Invalid type: %s does not exist!\n", input);
            }
        }while (true);
        products.add(new Product(name, price, type));
    }

    public void removeProduct(){

    }

    public void showAllProducts(){
        Collections.sort(products);
        for (int i = 0; i < products.size(); i++){
            System.out.printf("%d.\t%s\n", (i + 1),  products.get(i));
            System.out.println("--------------------");
        }
    }
}

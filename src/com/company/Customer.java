package com.company;
import java.util.ArrayList;

public class Customer extends Account {
    private int customer_ID;
    private ArrayList<Product> shoppingCart = new ArrayList<>();

    public Customer(int customer_ID){
        this.customer_ID = customer_ID;
        shoppingCart.add(new Product("SPECIAL GOODS", 50, Type.Blades));
        shoppingCart.add(new Product("Hidden stash", 44, Type.Armor));
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void giveProduct(Product product){
        shoppingCart.add(product);
    }
    public void removeProduct(){

    }

    void showShoppingCart(){
        System.out.println("Shopping Cart for customer " + customer_ID);
        for (int i = 0; i < shoppingCart.size(); i++){
            System.out.printf("%d.\t%s\n", (i + 1),  shoppingCart.get(i));
            System.out.println("--------------------");
        }
    }
}

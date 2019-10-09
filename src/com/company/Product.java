package com.company;

public class Product implements Comparable<Product> {
    enum SortBy{
        HIGHESTPRICE,
        LOWESTPRICE,
        NAMEATOZ,
    }

    private int price;
    private int size;

    private String productName;
    private Type type;

    private static SortBy sortBy = SortBy.HIGHESTPRICE;

    public Product(String productName, int price, Type type){
        this.productName = productName;
        this.price = price;
        this.type = type;
        //this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String toString(){
        return  productName + " " + price + " KR" +
                "\nType: " + type;
    }

    public int compareTo(Product product){
        switch (sortBy){
            case HIGHESTPRICE:
                return -(getPrice() - product.getPrice());
            case LOWESTPRICE:
                return (getPrice() - product.getPrice());
            default:
                System.out.println("This shouldnt print, if it does: Contact IT");
                return 0;
        }
    }
}

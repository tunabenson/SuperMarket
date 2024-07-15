package Products;

import Products.Product;

import java.util.ArrayList;

public class Shopper {
    private int amountOfMoney;
    private String name;
    private ArrayList<Product> inventory;

    public Shopper(String name, int amountOfMoney){
        this.amountOfMoney=amountOfMoney;
        this.name=name;
        this.inventory= new ArrayList<>();
    }


    public int getMoney(){
        return this.amountOfMoney;
    }


    public boolean buyProduct(Product p, int quantity){
        int price= p.getPrice()*quantity;
        if(p.isInStock(quantity) && price<=amountOfMoney){
            amountOfMoney-=price;
            p.buyProduct(this,quantity);
            System.out.println("Shopper "+name+" bought product");
            return true;
        }
        else{
            return false;
        }
    }


    public void addToInventory(Product p){
        inventory.add(p);
    }


    public void printInventory(){
        System.out.println("Shopper "+ name+ " owns: ");
        for (Product p: inventory) {
            System.out.println(p +" \n");
        }
    }
}

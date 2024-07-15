package Products;

public class Product {
    private String name;
    private int amountInStock;
    private int price;

    public Product(String name, int amount, int price){
        this.name=name;
        this.amountInStock=amount;
        this.price=price;
    }

    @Override
    public String toString() {
        return "{name: "+name+" \n for: "+this.price+"$}";
    }


    public int getPrice() {
        return price;
    }


    public boolean isInStock(int quantity) {
        return amountInStock-quantity>=0;
    }

    public void buyProduct(Shopper s ,int quantity){
        if(isInStock(quantity)) {
            amountInStock -= quantity;
            s.addToInventory(this);
        }
    }
}


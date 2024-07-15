import java.util.ArrayList;

import Products.Product;
import Products.Shopper;
public class Simulator {
    public static ArrayList<Shopper> shopperList;
    public static ArrayList<Product> productList;
    public static void init() {
        shopperList = new ArrayList<>();
        productList = new ArrayList<>();

        String[] shopperNames = {
                "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah", "Ivy", "Jack",
                "Karen", "Leo", "Mona", "Nina", "Oscar", "Paul", "Quincy", "Rachel", "Steve", "Tracy"
        };

        String[] productNames = {
                "Milk", "Bread", "Butter", "Cheese", "Eggs", "Apples", "Bananas", "Chicken", "Doughnuts", "Eggplants",
                "Fish", "Grapes", "Honey", "Ice Cream", "Jam", "Kale", "Lettuce", "Mangoes", "Nuts", "Oranges"
        };


        for (int i=0; i<50; i++) {
            int amountOfMoney = (int) (Math.random() * 1000) + 1;
            Shopper shopper = new Shopper(shopperNames[(int)(Math.random()*shopperNames.length)], amountOfMoney);
            shopperList.add(shopper);
        }

        for (int i=0; i<20; i++) {
            int amount = (int) (Math.random() * 100) + 1;
            int price = (int) (Math.random() * 500) + 1;
            Product product = new Product(productNames[(int)(Math.random()*productNames.length)], amount, price);
            productList.add(product);
        }
    }
    public static void run(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < shopperList.size(); j++) {
                Product p= productList.get((int)(Math.random()*productList.size()));
                int quantityToBuy=(int)(Math.random()*20)+1;
                shopperList.get(j).buyProduct(p, quantityToBuy);

                shopperList.get(j).printInventory();
            }
        }
    }
}

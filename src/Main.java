import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws StockLimitReachedException, IOException {
        System.out.println("______________________________________________");
        System.out.println("We create a shop.");
        Shop shop = new Shop("Bershka", "Tururustrasse 12");
        System.out.println("We can access the name and address of the shop: ");
        System.out.println("   Shop name: " + shop.getName());
        System.out.println("   Shop address: " + shop.getAddress() + "\n");
        System.out.println("______________________________________________");
        System.out.println("Now we create a few products");

        Product product0 = new Product("Bandana", "Red bandana, very cute.", 9.99, "Accessories");
        Product product1 = new Product("Hawaiian T-Shirt", "A very flowery T-shirt for your holidays.", 19.99, "T-shirts");
        Product product2 = new Product("Jeans", "Very tight and sexy.", 39.99, "Trousers");
        Product product3 = new Product("White shirt", "Perfect for any business occasion.", 69.99, "Shirts");
        Product product4 = new Product("Raincoat", "You got yourself covered when it rains.", 39.99, "Jackets");
        Product product5 = new Product("Black shirt", "Perfect for funerals! :)", 34.99, "Shirts");
        Product product6 = new Product("Purse", "Very colorful purse for an everyday use.", 14.99, "Accessories");
        Product product7 = new Product("Shorts", "Enjoy your summer with these fresh shorts, made with a very thin fabric.", 34.99, "Trousers");
        Product product8 = new Product("Knee-length trousers", "You can use these trousers when you're not sure what the weather is going to be like", 23.99, "Trousers");
        Product product9 = new Product("Winter Coat", "Perfect for a cold winter", 79.99, "Jackets");

        System.out.println("Here we have all products:\n   " + product0 + "\n   " + product1 + "\n   " + product2 + "\n   " + product3 + "\n   " + product4 + "\n   " + product5 + "\n   " + product6 + "\n   " + product7 + "\n   " + product8 + "\n   " + product9 + "\n");

        System.out.println("We add all created products to a dummy hashmap: ");
        HashMap <Integer, Product> dummyHash = new HashMap<>();
        dummyHash.put(product0.getProductId(), product0);
        dummyHash.put(product1.getProductId(), product1);
        dummyHash.put(product2.getProductId(), product2);
        dummyHash.put(product3.getProductId(), product3);
        dummyHash.put(product4.getProductId(), product4);
        dummyHash.put(product5.getProductId(), product5);
        dummyHash.put(product6.getProductId(), product6);
        dummyHash.put(product7.getProductId(), product7);
        dummyHash.put(product8.getProductId(), product8);
        dummyHash.put(product9.getProductId(), product9);
        System.out.println(dummyHash);

        System.out.println("______________________________________________");
        System.out.println("\nNow instead of adding the products to the dummy hashmap we add them to the shop using the ProductAmount class to indicate the amount of items per product that we want to introduce.");

        System.out.println("First we create instances of ProductAmount (This class indicates the Product and the amount of items of this Product) and add them to the shop:");

        ProductAmount productAmount0 = new ProductAmount(product0, 15);
        ProductAmount productAmount1 = new ProductAmount(product1, 14);
        ProductAmount productAmount2 = new ProductAmount(product2, 13);
        ProductAmount productAmount3 = new ProductAmount(product3, 12);
        ProductAmount productAmount4 = new ProductAmount(product4, 11);
        ProductAmount productAmount5 = new ProductAmount(product5, 10);
        ProductAmount productAmount6 = new ProductAmount(product6, 9);
        ProductAmount productAmount7 = new ProductAmount(product7, 8);
        ProductAmount productAmount8 = new ProductAmount(product8, 7);
        ProductAmount productAmount9 = new ProductAmount(product9, 6);

        shop.addProducts(productAmount0);
        shop.addProducts(productAmount1);
        shop.addProducts(productAmount2);
        shop.addProducts(productAmount3);
        shop.addProducts(productAmount4);
        shop.addProducts(productAmount5);
        shop.addProducts(productAmount6);
        shop.addProducts(productAmount7);
        shop.addProducts(productAmount8);
        shop.addProducts(productAmount9);

        System.out.println(shop.getProducts());
        System.out.println("\nWe made a display function to show the details of each product in the shop: ");
        shop.displayProducts();

        System.out.println("\nWe can also display a single product selecting the Product...");
        shop.displayProduct(product0);

        System.out.println("\n ...or just the amount of the selected product.");
        shop.displayProductAmount(product0);

        System.out.println("______________________________________________");

        System.out.println("\n\nNow we create a few users and add them to a Hashmap:");
        User user1 = new User("Irati", "Larreina", "ilarreina@gmail.com", "Elterleinplatz 1", 1170, 645009127);
        User user2 = new User("Max", "Power", "mpower@gmail.com", "Thomas-Morus-Gasse 16", 1130, 683748535);
        User user3 = new User("John", "Doe", "jdoe@gmail.com", "Candiland 5", 1010, 682419534);

        HashMap<Integer, User> users = new HashMap<>();
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);

        System.out.println(users);
        System.out.println("\nWe can also display the information of the users:");

        users.forEach((key, value) -> value.displayInfo());
        System.out.println("Let's add some product purchases to the first user and print the purchase history... ");
        user1.makePurchase(product0, 5, shop);
        user1.makePurchase(product1, 4, shop);
        user1.makePurchase(product2, 3, shop);
        System.out.println(user1.getPurchaseHistory());

        System.out.println("\n... in a more readable way and printing the total price: ");
        user1.displayPurchaseHistory();

        System.out.println("\n______________________________________________");
        System.out.println("We can check that when we buy items from the shop, their amount decreases accordingly:");
        System.out.println("   Initial amount of first and last product:");
        shop.displayProductAmount(product0);
        shop.displayProductAmount(product9);
        user1.makePurchase(product0, 5, shop);
        user2.makePurchase(product9, 1, shop);
        System.out.println("   User1 and User2 buy some of the products and then we end up with:");
        shop.displayProductAmount(product0);
        shop.displayProductAmount(product9);
        System.out.println("\nIf we try to buy it again, we go below 5 and it throws a message:");
        user1.makePurchase(product0, 1, shop);
        user2.makePurchase(product9, 5, shop);
        shop.displayProductAmount(product0);
        shop.displayProductAmount(product9);

        System.out.println("\nAnd if we try to buy more products than available: ");
        user1.makePurchase(product0, 5, shop);
        user2.makePurchase(product9, 5, shop);
        shop.displayProductAmount(product0);
        shop.displayProductAmount(product9);

        System.out.println("\n______________________________________________");
        System.out.println("We can add as many products as we want...");
        shop.addProducts(new ProductAmount(product0, 1));
        shop.displayProductAmount(product0);
        shop.addProducts(new ProductAmount(product0, 7));
        shop.displayProductAmount(product0);
        System.out.println("...until we reach the limit.");
        shop.addProducts(new ProductAmount(product0, 4));

        System.out.println("\nWe can also try to add more than 15 of a new product and will end up with the same error:");
        shop.addProducts(new ProductAmount(new Product("Cap", "Perfect for sunny days", 5.99, "Accessories"), 16));

        System.out.println("\n______________________________________________");
        System.out.println("As soon as a user makes a purchase in the shop it becomes a customer of this shop, in this example only User1 and User2 are customers, so we can call the method to print the customers:");
        for (User customer : shop.getCustomers().values()) {
            System.out.println("   " + customer.getFirstName() + " " + customer.getLastName());
        }
        System.out.println("\n Don't forget to check out the created or overriten file (with User1-s Purchase History) after the process is finished :)");
        user1.printReport();

        System.out.println("\n______________________________________________");
        System.out.println("\nNow let's start the menu and play with it: ");

        Menu menu = new Menu();
        menu.display(shop);
    }
}
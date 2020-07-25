import java.util.*;

public class Menu {

    public void display(Shop shop) {
        int allProducts = 1;
        int productsCategory = 2;
        int productsStock5 = 3;
        int productsOutStock = 4;
        int exit = 0;

        System.out.println("+---------------------+");
        System.out.println("|        Welcome      |");
        System.out.println("|        to the       |");
        System.out.println("|        Shop         |");
        System.out.println("+---------------------+");

        String commands = "\nMake a selection:\n   1) Display all products. \n   2) Display all products of category x.\n   3) Display all products where stock < 5.\n   4) Display all products out of stock.\n   5) Display all customers.\n   0) Exit.\n";

        boolean stop = false;
        while (!stop) {
            System.out.println(commands);
            System.out.println("Enter your choice:");
            Scanner scan = new Scanner(System.in);
            int staffInput = scan.nextInt();
            switch (staffInput) {
                case 0:
                    System.out.println("Thanks for using the Menu, have a nice day!");
                    stop = true;
                    break;
                case 1:
                    System.out.println("All products:");
                    shop.getProducts().forEach((key, value) -> System.out.println("- " + value.getProduct().getProductName() + ". Amount: " + value.getAmount()));
                    break;
                case 2:
                    System.out.println("Display all products by a Category.\nPlease select a category:\n   1) T-shirts\n   2) Shirts\n   3) Jackets\n   4) Trousers\n   5) Accessories\n\nEnter your choice:");
                    Scanner scan2 = new Scanner(System.in);
                    int categoryInput = scan.nextInt();
                    switch (categoryInput) {
                        case 1:
                            System.out.println("All products in category T-shirts:");
                            for (ProductAmount productamount : shop.getProducts().values()) {
                                if (productamount.getProduct().getCategory().equals("T-shirts")) {
                                    System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                                }
                            }
                            break;
                        case 2:
                            System.out.println("All products in category Shirts:");
                            for (ProductAmount productamount : shop.getProducts().values()) {
                                if (productamount.getProduct().getCategory().equals("Shirts")) {
                                    System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                                }
                            }
                            break;

                        case 3:
                            System.out.println("All products in category Jackets:");
                            for (ProductAmount productamount : shop.getProducts().values()) {
                                if (productamount.getProduct().getCategory().equals("Jackets")) {
                                    System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                                }
                            }
                            break;

                        case 4:
                            System.out.println("All products in category Treousers:");
                            for (ProductAmount productamount : shop.getProducts().values()) {
                                if (productamount.getProduct().getCategory().equals("Trousers")) {
                                    System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                                }
                            }
                            break;

                        case 5:
                            System.out.println("All products in category Accessories:");
                            for (ProductAmount productamount : shop.getProducts().values()) {
                                if (productamount.getProduct().getCategory().equals("Accessories")) {
                                    System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                                }
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Products with stock less than 5 (but not out of stock):");
                    for (ProductAmount productamount : shop.getProducts().values()) {
                        if (productamount.getAmount()<5 && productamount.getAmount()>0){
                            System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Products out of stock:");
                    for (ProductAmount productamount : shop.getProducts().values()) {
                        if (productamount.getAmount()==0){
                            System.out.println("- " + productamount.getProduct().getProductName() + ". Amount: " + productamount.getAmount());
                        }
                    }
                    break;
                case 5:
                    System.out.println("All customers of the shop:");
                    for (User customer : shop.getCustomers().values()) {
                        System.out.println("- " + customer.getFirstName() + " " + customer.getLastName());
                    }
                    break;
            }
        }
    }
}
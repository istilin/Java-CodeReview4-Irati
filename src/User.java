import java.util.*;
import java.io.*;

public class User {
    private int Id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String address;
    private int zip;
    private int phone;
    private static int IdCounter = 2000;
    private HashMap<Integer, Purchase> purchaseHistory = new HashMap<>();

    public User(String firstName, String lastName, String eMail, String address, int zip, int phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
        Id = IdCounter;
        IdCounter++;
    }

    public int getId() {
        return Id;
    }

    public void displayInfo(){
        System.out.println(firstName + " " + lastName + "\n   e-mail address: " + eMail + "\n   Address: " + address + "\n   Zip code: " + zip + "\n   Phone number: " + phone + "\n");
    }

    public void makePurchase(Product product, int amount, Shop shop) {
        if ((shop.getProducts().get(product.getProductId()).getAmount()) - amount > 4) {
            Purchase purchase = new Purchase(product, amount);
            purchaseHistory.put(purchase.getPurchaseId(), purchase);
            shop.removeProducts(product, amount);
            shop.addCustomer(this);
        }
        else if ((shop.getProducts().get(product.getProductId()).getAmount()) - amount >= 0){
            System.out.println("Alarm! There are less than 5 items of the product!");
            Purchase purchase = new Purchase(product, amount);
            purchaseHistory.put(purchase.getPurchaseId(), purchase);
            shop.removeProducts(product, amount);
            shop.addCustomer(this);
        }
        else{
            System.out.println("There are not enough items of the selected product, please try another amount or another product!");
        }
    }

    public HashMap<Integer, Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void displayPurchaseHistory() {
        ArrayList<Integer> sorting = new ArrayList<>(purchaseHistory.keySet());
        Collections.sort(sorting);
        System.out.println("Purchase History from User with ID " + Id);
        double totalPrice = 0;
        for (int purchId : sorting) {
            System.out.println("Purchase ID " + purchId + "\n   Product name: " + purchaseHistory.get(purchId).getProduct().getProductName() + "\n   Date of Purchase: " + purchaseHistory.get(purchId).getPurchaseTime() + "\n   Amount: " + purchaseHistory.get(purchId).getAmount() + "\n   Price: " + purchaseHistory.get(purchId).getProduct().getProductPrice() * purchaseHistory.get(purchId).getAmount() + "\n----------------------");
            totalPrice += purchaseHistory.get(purchId).getProduct().getProductPrice() * purchaseHistory.get(purchId).getAmount();
        }
        System.out.println("Total price: " + totalPrice + "€");
    }

    public void printReport() throws IOException {

        FileWriter file = new FileWriter("src/User" + Id + "PurchaseHistory.txt");
        double totalPrice = 0;
        ArrayList<Integer> sorting = new ArrayList<>(purchaseHistory.keySet());
        Collections.sort(sorting);
        for (int purchId : sorting) {
            file.write("Purchase ID " + purchId + "\n   Product name: " + purchaseHistory.get(purchId).getProduct().getProductName() + "\n   Date of Purchase: " + purchaseHistory.get(purchId).getPurchaseTime() + "\n   Amount: " + purchaseHistory.get(purchId).getAmount() + "\n   Price: " + purchaseHistory.get(purchId).getProduct().getProductPrice() * purchaseHistory.get(purchId).getAmount() + "\n----------------------\n");
            totalPrice += purchaseHistory.get(purchId).getProduct().getProductPrice() * purchaseHistory.get(purchId).getAmount();
        }
        file.write("Total price: " + totalPrice + "€");
        file.close();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

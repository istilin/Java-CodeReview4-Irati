import java.util.HashMap;

public class Shop {
    private String name;
    private String address;
    private HashMap<Integer, ProductAmount> products = new HashMap<>();
    private HashMap<Integer, User> customers = new HashMap<>();
    private HashMap<Enum, Product[]> categories = new HashMap<>();

    public Shop(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addProducts(ProductAmount productAmount) throws StockLimitReachedException {
        if (products.containsKey(productAmount.getProductId())){
            if(products.get(productAmount.getProductId()).getAmount()+productAmount.getAmount() > 15) {
                try {
                    throw new StockLimitReachedException("You reached the maximum amount of items of this product, please try a different amount or add stock of another product.");
                } catch (StockLimitReachedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else {
                products.get(productAmount.getProductId()).setAmount(products.get(productAmount.getProductId()).getAmount() + productAmount.getAmount());
            }
        }
        else{
            if (productAmount.getAmount() > 15) {
                try {
                    throw new StockLimitReachedException("You reached the maximum amount of items of this product, please try a different amount or add stock to another product.");
                } catch (StockLimitReachedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                products.put(productAmount.getProductId(), productAmount);
            }
        }
    }

    public void removeProducts(Product product, int numProducts){

        products.get(product.getProductId()).setAmount(products.get(product.getProductId()).getAmount()-numProducts);
    }

    public HashMap<Integer, ProductAmount> getProducts() {
        return products;
    }

    public void displayProducts(){
        products.forEach((key, value) -> System.out.println(value.getProduct().getProductName() + ":\n   Product ID: " + key  + "\n   Price: " + value.getProduct().getProductPrice() + "\n   Category: " + value.getProduct().getCategory()  + "\n   Description: " + value.getProduct().getProductDescription()+ "\n   Number of items available: " + value.getAmount()  + "\n"));

    }
    public void displayProductAmount(Product product){
        System.out.println("Product (" + product.getProductName() + ") amount: " +products.get(product.getProductId()).getAmount());
    }

    public void displayProduct(Product product) {
        System.out.println(product.getProductName() + ":\n   Product ID: " + product.getProductId() + "\n   Price: " + product.getProductPrice() + "\n   Category: " +  product.getCategory() + "\n   Number of items available: " + products.get(product.getProductId()).getAmount());
    }

    public void addCustomer(User user){
        customers.put(user.getId(), user);
    }

    public HashMap<Integer, User> getCustomers() {
        return customers;
    }
}


public class Product {
    private int productId;
    private static int productIdIncrement = 100000000;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String category;

    public Product(String productName, String productDescription, double productPrice, String category){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        productId = productIdIncrement;
        productIdIncrement++;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getCategory() {
        return category;
    }
}

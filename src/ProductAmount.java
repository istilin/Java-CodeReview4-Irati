public class ProductAmount {

    private int productId;
    private Product product;
    private int amount;
    public ProductAmount(Product product, int amount){
        this.product = product;
        this.productId = product.getProductId();
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getProductId() {
        return productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

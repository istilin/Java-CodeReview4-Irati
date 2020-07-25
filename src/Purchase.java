import java.time.LocalDateTime;
import java.util.HashMap;

public class Purchase {
    private LocalDateTime purchaseTime = LocalDateTime.now();
    private int purchaseId;
    private Product product;
    private int amount;
    private static int count = 500000;

    public Purchase(Product product, int amount){
        this.product = product;
        this.amount = amount;
        purchaseId = count;
        count++;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}

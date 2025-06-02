import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private double total;
    private int bouquetCount;
    private final double bouquetPrice = 50.00;
    private List<Flower> shoppingCart;
    private boolean userWantsFlowerBouquet;

    public CartManager(){
        this.total = 0;
        this.bouquetCount = 0;
        this.shoppingCart = new ArrayList<>();
        this.userWantsFlowerBouquet = false;
    }

    public double getBouquetPrice(){
        return this.bouquetPrice;
    }

    public int getBouquetCount() {
        return bouquetCount;
    }

    public boolean getUserWantsFlowerBouquet(){
        return this.userWantsFlowerBouquet;
    }

    public void addToTotal(double amount){
        this.total += amount;
    }

    public double getTotal(){
        return this.total;
    }

    public void addBouquet(){
        this.userWantsFlowerBouquet = true;
        this.bouquetCount++;
        addToTotal(bouquetPrice);
    }

    public void addToShoppingCart(Flower flower){
        this.shoppingCart.add(flower);
        addToTotal(flower.getPrice());
    }

    public List<Flower> getShoppingCart(){
        return this.shoppingCart;
    }

    public void clearCart() {
        this.shoppingCart.clear();
        this.total = 0;
        this.userWantsFlowerBouquet = false;
    }
}

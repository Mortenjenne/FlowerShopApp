import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private double total;
    private final double bouquetPrice = 50.00;
    private List<Flower> flowers;
    private List<Flower> shoppingCart;
    private boolean userWantsFlowerBouquet;

    public CartManager(){
        this.total = 0;
        this.flowers = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
        this.userWantsFlowerBouquet = false;
        addFlowersToShop();
    }

    public double getBouquetPrice(){
        return this.bouquetPrice;
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
        shoppingCart.clear();
        total = 0;
        userWantsFlowerBouquet = false;
    }

    public List<Flower> getFlowers(){
        return this.flowers;
    }

    public Flower getFlowerByIndex(int index){
        if(index >= 0 && index < flowers.size()) {
            return flowers.get(index);
        } else {
            return null;
        }
    }

    private void addFlowersToShop() {
        flowers.add(new Flower("Rose", 45.00));
        flowers.add(new Flower("Tulipan", 35.95));
        flowers.add(new Flower("Lilje", 40.00));
        flowers.add(new Flower("Orkide", 55.50));
        flowers.add(new Flower("Magnolia", 75.50));
        flowers.add(new Flower("Lavendel", 80.00));
        flowers.add(new Flower("Raunkle", 58.50));
        flowers.add(new Flower("Nellike", 48.75));
        flowers.add(new Flower("Pæon", 75.50));
        flowers.add(new Flower("Anemone", 63.95));
    }


}

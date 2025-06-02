import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Flower> flowers;

    public Inventory(){
        this.flowers = new ArrayList<>();
        addFlowersToShop();
    }

    public List<Flower> getFlowers(){
        return this.flowers;
    }

    public void addFlowerToInventory(String name, double price){
        flowers.add(new Flower(name,price));
    }

    public void removeFlowerFromInventory(Flower flower){
        if(flower != null) {
            flowers.remove(flower);
        }
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

public class Flower {
    private String name;
    private double price;

    public Flower(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return String.format("%s pris: %.2f kr.",this.name, this.price);
    }
}

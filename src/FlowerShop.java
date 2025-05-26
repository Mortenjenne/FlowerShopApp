import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

    private double total;
    private String name;
    private List<Flower> flowers;
    private List<Flower> shoppingCart;
    private UserInterface ui;
    private boolean appRunning;

    public FlowerShop(String name){
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.flowers = new ArrayList<>();
        this.total = 0;
        this.appRunning = true;
        this.ui = new UserInterface();
        addFlowersToShop();

    }

    public void runDialog(){
        while (appRunning){
            ui.showMenu(this.name);
            String userInput = ui.readInput("Indtast dit valg");

            switch (userInput){
                case "1":
                    showFlowersForSale();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "x":
                    break;
                default:
                    ui.printMessage("Ikke en valid handling prøv igen");

            }
        }
    }

    private void showFlowersForSale(){
        ui.printMessage("Prisliste:");

       for(int i = 0; i < flowers.size(); i++){
           ui.printMessage(i+1 + ". " + flowers.get(i));
       }
       ui.promptNumeric("Buket pris: 50.00 Kr.");
    }

    private void addFlowersToShoppingBasket(){
        boolean userHasChosenThreeFlowers = false;
        while (!userHasChosenThreeFlowers) {
            int choice = ui.promptNumeric("Vælg 3 blomster fra listen udfra numret");
            Flower chosenFlower = flowers.get(choice-1);
            shoppingCart.add(chosenFlower);

            if(shoppingCart.size() == 3){
                userHasChosenThreeFlowers = true;
                boolean userWantsFlowerBouquet = ui.promptBinary("Vil du have bundet blomsterne i en buket? +50 Kr.");

                if(userWantsFlowerBouquet){
                    ui.promptBinary("Dine blomster bliver bundet til flot buket");
                    addToTotal(50.0);
                }
            }
        }

    }

    private void addToTotal(double amount){
        this.total += amount;
    }

    private void addFlowersToShop(){
        flowers.add(new Flower("Rose",45.00));
        flowers.add(new Flower("Tulipan",35.95));
        flowers.add(new Flower("Lilje",40.00));
        flowers.add(new Flower("Orkide",55.50));
        flowers.add(new Flower("Magnolia",75.50));
        flowers.add(new Flower("Lavendel",80.00));
        flowers.add(new Flower("Raunkle", 58.50));
        flowers.add(new Flower("Nellike", 48.75));
        flowers.add(new Flower("Pæon",75.50));
        flowers.add(new Flower("Anemone",63.95));
    }
}

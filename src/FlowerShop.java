import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

    private double total;
    private String name;
    private final double bouquetPrice = 50.0;
    private List<Flower> flowers;
    private List<Flower> shoppingCart;
    private UserInterface ui;
    private boolean userWantsFlowerBouquet;
    private boolean appRunning;

    public FlowerShop(String name) {
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.flowers = new ArrayList<>();
        this.total = 0;
        this.appRunning = true;
        this.ui = new UserInterface();
        addFlowersToShop();
    }

    public void runDialog() {
        while (appRunning) {
            ui.showMenu(this.name);
            String userInput = ui.readInput("Indtast dit valg");

            switch (userInput) {
                case "1":
                    showFlowersForSale();
                    addFlowersToShoppingBasket();
                    break;
                case "2":
                    showShoppingCart();
                    break;
                case "3":
                    goToCheckOut();
                    break;
                case "x":
                    ui.printMessage("Tak fordi du besøgte " + this.name + " 🌷");
                    appRunning = false;
                    break;
                default:
                    ui.printMessage("Ikke en valid handling prøv igen");
            }
        }
    }

    private void showFlowersForSale() {
        ui.printMessage("Prisliste:");

        for (int i = 0; i < flowers.size(); i++) {
            ui.printMessage(i + 1 + ". " + flowers.get(i));
        }
        ui.printMessage("Buket pris: " + bouquetPrice + " kr.");
        ui.printMessage("");

    }

    private void addFlowersToShoppingBasket() {
        boolean buyFlowers = ui.promptBinary("Vil du købe blomster Y/N ?");

        if (buyFlowers) {
            int counter = 3;

            while (counter > 0) {

                int choice = ui.promptNumeric("Vælg en blomst ud fra nummer, du mangler at tilføje: " + counter);
                choice--;

                if (choice >= 0 && choice < flowers.size()) {
                    Flower chosenFlower = flowers.get(choice);
                    shoppingCart.add(chosenFlower);
                    addToTotal(chosenFlower.getPrice());
                    counter--;
                } else {
                    ui.printMessage("Venligst vælg en blomst udfra nummer på listen");
                }
            }

            boolean userWantsBouquet = ui.promptBinary("Vil du have bundet blomsterne i en buket +50.00 kr. Y/N?");
            if (userWantsBouquet) {
                ui.printMessage("Dine blomster bliver bundet til en flot buket");
                addToTotal(bouquetPrice);
            } else {
                ui.printMessage("Blomsterne er tilføjet enkeltvis til din kurv");
            }

        }
    }

    private void showShoppingCart() {
        if (shoppingCart == null || shoppingCart.isEmpty()) {
            ui.printMessage("Ingen varer er tilføjet indkøbskurv");
        } else {
            ui.printMessage("Din indkøbs kurv:");
            showFlowersInBasket();
            ui.printMessage("Total: " + this.total + " Kr.");
        }
    }

    private void addToTotal(double amount) {
        this.total += amount;
    }

    private void goToCheckOut() {
        if (shoppingCart == null || shoppingCart.isEmpty()) {
            ui.printMessage("Din indkøbskurv er tom.. Tilføj varer før du går til kassen");
            return;
        }

        boolean pay = ui.promptBinary("Vil du betale Y/N");
        if (pay) {
            ui.printMessage("---Kvittering---");
            showFlowersInBasket();
            if (userWantsFlowerBouquet) {
                ui.printMessage("Buket, pris: 50.00 kr.");
            }
            ui.printMessage("----------------");
            ui.printMessage("Total: " + this.total + " kr.");
            ui.printMessage("Tak for dit køb");
            this.total = 0;
            this.shoppingCart = null;
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

    private void showFlowersInBasket() {
        for (Flower flower : shoppingCart) {
            ui.printMessage(flower.toString());
        }
    }
}

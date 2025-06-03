
import java.util.List;

public class FlowerShop {

    private String name;
    private UserInterface ui;
    private CartManager cartManager;
    private Inventory inventory;
    private boolean appRunning;
    private List<Flower> flowersForSale;

    public FlowerShop(String name) {
        this.name = name;
        this.cartManager = new CartManager();
        this.inventory = new Inventory();
        this.ui = new UserInterface();
        this.appRunning = true;
        this.flowersForSale = inventory.getFlowers();
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

        for (int i = 0; i < flowersForSale.size(); i++) {
            ui.printMessage(i + 1 + ". " + flowersForSale.get(i));
        }
        ui.printMessage("Buket pris: " + cartManager.getBouquetPrice() + " kr.");
        ui.printMessage("");
    }

    private void addFlowersToShoppingBasket() {
        boolean buyFlowers = ui.promptBinary("Vil du købe blomster Y/N ?");

        if (buyFlowers) {
            int counter = 3;

            while (counter > 0) {
                int choice = ui.promptNumeric("Vælg en blomst ud fra nummer, du mangler at tilføje: " + counter);
                choice--;

                if (choice >= 0 && choice < flowersForSale.size()) {
                    Flower chosenFlower = inventory.getFlowerByIndex(choice);
                    cartManager.addToShoppingCart(chosenFlower);
                    counter--;
                    ui.printMessage("Du har valgt en: " + chosenFlower.getName());
                } else {
                    ui.printMessage("Venligst vælg en blomst ud fra nummer på listen");
                }
            }

            boolean userWantsBouquet = ui.promptBinary("Vil du have bundet blomsterne i en buket +50.00 kr. Y/N?");
            if (userWantsBouquet) {
                ui.printMessage("Dine blomster bliver bundet til en flot buket");
                cartManager.addBouquet();
            } else {
                ui.printMessage("Blomsterne er tilføjet enkeltvis til din kurv");
            }
        }
    }

    private void showShoppingCart() {
        if (isShoppingCartEmpty()) {
            ui.printMessage("Ingen varer er tilføjet indkøbskurv");
        } else {
            ui.printMessage("Din indkøbs kurv:");
            showFlowersInBasket();
            ui.printMessage("Total: " + cartManager.getTotal() + " Kr.");
        }
    }

    private void goToCheckOut() {
        if (isShoppingCartEmpty()) {
            ui.printMessage("Din indkøbskurv er tom.. Tilføj varer før du går til kassen");
            return;
        }

        boolean pay = ui.promptBinary("Vil du betale Y/N");
        if (pay) {
            ui.printMessage("---Kvittering---");
            showFlowersInBasket();
            if (cartManager.getUserWantsFlowerBouquet()) {
                double bouquetPrice = cartManager.getBouquetPrice() * cartManager.getBouquetCount();
                ui.printMessage("Buket pris: " + bouquetPrice);
            }
            ui.printMessage("----------------");
            ui.printMessage("Total: " + cartManager.getTotal() + " kr.");
            ui.printMessage("Tak for dit køb");
            cartManager.clearCart();
        }
    }

    private void showFlowersInBasket() {
        List<Flower> flowers = cartManager.getShoppingCart();
        for (Flower flower : flowers) {
            ui.printMessage(flower.toString());
        }
    }

    private boolean isShoppingCartEmpty() {
        return cartManager.getShoppingCart() == null || cartManager.getShoppingCart().isEmpty();
    }
}

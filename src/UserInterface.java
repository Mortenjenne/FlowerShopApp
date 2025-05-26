import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(String shopName) {
        System.out.println("");
        System.out.println("Velkommen til " + shopName);
        System.out.println("1) Køb blomster");
        System.out.println("2) Se indkøbskurv");
        System.out.println("3) Fjern en vare fra indkøbskurv");
        System.out.println("4) Gå til kassen");
        System.out.println("x) Forlad butik");
    }

    public String readInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int promptNumeric(String message) {
        System.out.println(message);
        int numberInput = 0;
        boolean isNumberValid = false;
        while (!isNumberValid) {
            String input = scanner.nextLine();
            try {
                numberInput = Integer.parseInt(input);
                isNumberValid= true;
            } catch (NumberFormatException e) {
                System.out.println("Venligts indtast et nummer");
            }
        }
        return numberInput;
    }

    public boolean promptBinary(String msg) {
        String choice = readInput(msg);
        boolean userHasPressedYesOrNo = false;

        while (!userHasPressedYesOrNo){
            if(choice.equalsIgnoreCase("Y")){
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
        } else {
                System.out.println("Venligst indtast Y/N");
            }




        }
    }

}

import java.util.Scanner;

public class Main {


    private void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        KrebsDealershipAutoInventory autoInventory = new KrebsDealershipAutoInventory();
        Main run = new Main();

        boolean continuing = true;

        //read from storage file to set arraylist with auto list to be manipulated by user
        autoInventory.readFromFile();

        run.print("***Krebs DealerShip Vehicle Inventory Database***");

        //try.. catch used to collect all exception in all method created and ran
        try {
            //as long as user does not end program the while loop will not be broken out of and changed can be made
            while (continuing) {
                run.print("");
                run.print("Pick from the following by typing the corresponding number.");
                run.print("1. Display Inventory");
                run.print("2. Add Vehicle To Inventory");
                run.print("3. Update Vehicle In Inventory");
                run.print("4. Delete Vehicle From Inventory");
                run.print("5. Save Inventory To Your File");
                run.print("6. End Program");

                String option = input.nextLine();

                //correct method from KrebsDealerShipAutoInventory class will run depending on the action the user would like to complete
                if (option.equals("1")) {
                    autoInventory.autoInventoryDisplay();
                } else if (option.equals("2")) {
                    autoInventory.autoInventoryAdd();
                    run.print("");
                    autoInventory.saveProgress();
                } else if (option.equals("3")) {
                    autoInventory.autoInventoryUpdate();
                    run.print("");
                    autoInventory.saveProgress();
                } else if (option.equals("4")) {
                    autoInventory.autoInventoryDelete();
                    run.print("");
                    autoInventory.saveProgress();
                } else if (option.equals("5")) {
                    autoInventory.writeToFileForUser();
                } else if (option.equals("6")) {
                    autoInventory.writeToFile();
                    continuing = false;
                } else {
                    run.print("An invalid number was entered.");
                }
            }
        } catch (Exception e) {
            run.print(e.getMessage());
        }
    }
}

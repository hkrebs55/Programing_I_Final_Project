import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class KrebsDealershipAutoInventory {

    Scanner input = new Scanner(System.in);
    ArrayList<KrebsDealershipAuto> autoInventoryList = new ArrayList<>();

    String make;
    String model;
    int year;
    String colour;
    float mileage;

    //method to add new auto to the arraylist
    //new auto is saved as a object in the constructor
    public void autoInventoryAdd() {
        print("New vehicle");
        print("Make: ");
        make = input.nextLine();
        make = make.substring(0,1).toUpperCase() + make.substring(1).toLowerCase();
        print("Model: ");
        model = input.nextLine();
        model = model.substring(0,1).toUpperCase() + model.substring(1).toLowerCase();
        print("Year: ");
        year = input.nextInt();
        input.nextLine();
        print("Colour: ");
        colour = input.nextLine();
        colour = colour.substring(0,1).toUpperCase() + colour.substring(1).toLowerCase();
        print("Mileage: ");
        mileage = input.nextFloat();
        input.nextLine();
        KrebsDealershipAuto autoNew = new KrebsDealershipAuto(make, model, year, colour, mileage);

        if (autoInventoryList.contains(autoNew)) {
            print("This vehicle is already inventoried. No vehicle added.");
        } else {
            autoInventoryList.add(autoNew);
            print("Vehicle added.");
        }
    }

    //method to update an existing auto
    //method will ask for auto information to determine if auto exist
    //if does exist user is asked what is to be updated
    //continues to ask if updated until user states no
    public void autoInventoryUpdate() {
        print("Which vehicle are you updating?");
        print("Make: ");
        make = input.nextLine();
        make = make.substring(0,1).toUpperCase() + make.substring(1).toLowerCase();
        print("Model: ");
        model = input.nextLine();
        model = model.substring(0,1).toUpperCase() + model.substring(1).toLowerCase();
        print("Year: ");
        year = input.nextInt();
        input.nextLine();
        print("Colour: ");
        colour = input.nextLine();
        colour = colour.substring(0,1).toUpperCase() + colour.substring(1).toLowerCase();
        print("Mileage: ");
        mileage = input.nextFloat();
        input.nextLine();
        KrebsDealershipAuto updateAuto = new KrebsDealershipAuto(make, model, year, colour, mileage);

        boolean match = false;
        boolean correctMore = true;
        String updateMore;
        boolean retry = false;


        for (int i = 0; i < autoInventoryList.size(); i++) {
            if (autoInventoryList.get(i).objToString().equals(updateAuto.objToString())) {
                match = true;
                while (correctMore) {
                    //set back to true once set to false to break out of while loop later
                   boolean incorrect = true;
                    print("What are you wanting to update?");
                    print("Type in the corresponding number");
                    print("1. Make");
                    print("2. Model");
                    print("3. Year");
                    print("4. Colour");
                    print("5. Mileage");
                    int toUpdate = input.nextInt();
                    input.nextLine();

                    if (toUpdate == 1) {
                        print("What is the new make?");
                        make = input.nextLine();
                        make = make.substring(0,1).toUpperCase() + make.substring(1).toLowerCase();
                        autoInventoryList.get(i).setInventoriedMake(make);
                        print("The make has been updated.");
                    } else if (toUpdate == 2) {
                        print("What is the new model?");
                        model = input.nextLine();
                        model = model.substring(0,1).toUpperCase() + model.substring(1).toLowerCase();
                        autoInventoryList.get(i).setInventoriedModel(model);
                        print("The model has been updated.");
                    } else if (toUpdate == 3) {
                        print("What is the new year?");
                        year = input.nextInt();
                        input.nextLine();
                        autoInventoryList.get(i).setInventoriedYear(year);
                        print("The year has been updated.");
                    } else if (toUpdate == 4) {
                        print("What is the new colour?");
                        colour = input.nextLine();
                        colour = colour.substring(0,1).toUpperCase() + colour.substring(1).toLowerCase();
                        autoInventoryList.get(i).setInventoriedColour(colour);
                        print("The colour has been updated.");
                    } else if (toUpdate == 5) {
                        print("What is the new mileage?");
                        mileage = input.nextFloat();
                        input.nextLine();
                        autoInventoryList.get(i).setInventoriedMiles(mileage);
                        print("The mileage has been updated.");
                    } else {
                        print("You have entered in an invalid number. Please try again.");
                        retry = true;
                    }

                    //used if valid string is scanned in, will be skipped if invalid string
                    if (!retry) {
                        while (incorrect) {
                            print("Do you need to update more to this vehicle? Type 'Y' for yes and 'N' for no.");
                            updateMore = input.nextLine().toUpperCase();
                            if (updateMore.equals("N")) {
                                incorrect = false;
                                correctMore = false;
                            } else if (updateMore.equals("Y")) {
                                incorrect = false;
                            } else {
                                print("Incorrect entry.");
                            }
                        }
                    }
                }
            }
        }
        if (!match) {
            print("The vehicle is not inventoried. No update can be made.");
        }
    }

    //method to delete existing auto from arraylist
    //method will ask for auto information to determine if auto exist
    //if does exist auto is deleted from arraylist/constructor
    public void autoInventoryDelete() {
        print("Delete vehicle");
        print("Make: ");
        make = input.nextLine();
        make = make.substring(0,1).toUpperCase() + make.substring(1).toLowerCase();
        print("Model: ");
        model = input.nextLine();
        model = model.substring(0,1).toUpperCase() + model.substring(1).toLowerCase();
        print("Year: ");
        year = input.nextInt();
        input.nextLine();
        print("Colour: ");
        colour = input.nextLine();
        colour = colour.substring(0,1).toUpperCase() + colour.substring(1).toLowerCase();
        print("Mileage: ");
        mileage = input.nextFloat();
        input.nextLine();
        KrebsDealershipAuto autoDelete = new KrebsDealershipAuto(make, model, year, colour, mileage);

        boolean match = false;

        for (int i = 0; i < autoInventoryList.size(); i++) {
            if (autoInventoryList.get(i).objToString().equals(autoDelete.objToString())) {
                autoInventoryList.remove(i);
                print("Vehicle deleted.");
                match = true;
            }
        }
        if (!match) {
            print("The vehicle is not inventoried. No vehicle deleted.");
        }
    }

    //method to print to console arraylist of inventory autos
    public void autoInventoryDisplay() {
        print("Krebs Dealership Inventory:");
        for (int a = 0; a < autoInventoryList.size(); a++) {
            print(autoInventoryList.get(a).objToString());
        }
    }

    //method to write to file for useres use
    public void writeToFileForUser() {
        try {
            PrintWriter writeAutoFile = new PrintWriter(new FileOutputStream("C:\\Users\\hkreb\\Desktop\\School\\CSC320-2\\User_Wanted_Auto_File.txt"));
            for (int a = 0; a < autoInventoryList.size(); a++) {
                writeAutoFile.write(autoInventoryList.get(a).objToString());
                writeAutoFile.write(System.getProperty("line.separator"));
            }
            writeAutoFile.close();
        } catch (Exception e) {
            print(e.getMessage());
        }
        print("Progress has been saved.");
    }

    //method asking if user wanted to update their file with new progress
    public void saveProgress() {
        print("Save progress?");
        print("Type 'Y' for yes and 'N' for no.");
        String save = input.nextLine().toUpperCase();


        if (save.equals("Y")) {
            writeToFileForUser();
        } else if (save.equals("N")){
            print("Progress not saved.");
        } else {
            print("Invalid entry, progress not saved.");
        }
    }

    //method to write to storage file, not same file as users file
    public void writeToFile() {
        try {
            PrintWriter writeAutoFile = new PrintWriter(new FileOutputStream("C:\\Users\\hkreb\\Desktop\\School\\CSC320-2\\Stored_Auto_File.txt"));
            for (int a = 0; a < autoInventoryList.size(); a++) {
                writeAutoFile.write(autoInventoryList.get(a).objToString());
                writeAutoFile.write(System.getProperty("line.separator"));
            }
            writeAutoFile.close();
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    //method to read from storage file and add file lines to arraylist
    public void readFromFile() {
        try {
            Scanner readAutoFile = new Scanner(new FileInputStream("C:\\Users\\hkreb\\Desktop\\School\\CSC320-2\\Stored_Auto_File.txt"));
            while (readAutoFile.hasNext()) {
                String listedAuto = readAutoFile.nextLine();
                String[] field = listedAuto.replaceAll("\\s", "").split(",");
                make = field[0];
                model = field[1];
                year = Integer.parseInt(field[2]);
                colour = field[3];
                mileage = Float.parseFloat(field[4]);
                autoInventoryList.add(new KrebsDealershipAuto(make, model, year, colour, mileage));
            }
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    //method to print text to console without typing long System code
    private void print(String text) {
        System.out.println(text);
    }
}

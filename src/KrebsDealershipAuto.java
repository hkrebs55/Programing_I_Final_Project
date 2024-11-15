public class KrebsDealershipAuto {

    //set private variables for default constructor
    private String inventoriedMake;
    private String inventoriedModel;
    private int inventoriedYear;
    private String inventoriedColour;
    private float inventoriedMiles;

    //parameterized constructor
    public KrebsDealershipAuto(String inventoriedMake, String inventoriedModel, int inventoriedYear, String inventoriedColour, Float inventoriedMiles) {
            this.inventoriedMake = inventoriedMake;
            this.inventoriedModel = inventoriedModel;
            this.inventoriedYear = inventoriedYear;
            this.inventoriedColour = inventoriedColour;
            this.inventoriedMiles = inventoriedMiles;
    }

    //set object to string for arraylist purposes
    public String objToString() {
            return inventoriedMake + ", " + inventoriedModel + ", " +inventoriedYear + ", " +inventoriedColour + ", " +inventoriedMiles;
    }

    //methods that set variables in the parameterized constructor
    public void setInventoriedMake(String make) {
        this.inventoriedMake = make;
    }

    public void setInventoriedModel(String model) {
        this.inventoriedModel = model;
    }

    public void setInventoriedYear(int year) {
        this.inventoriedYear = year;
    }

    public void setInventoriedColour(String colour) {
        this.inventoriedColour = colour;
    }

    public void setInventoriedMiles(float mileage) {
        this.inventoriedMiles = mileage;
    }
}

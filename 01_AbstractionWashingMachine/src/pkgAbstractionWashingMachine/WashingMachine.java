package pkgAbstractionWashingMachine;

public class WashingMachine {

    // attributes
    private String brand;
    private int capacity;
    private int totalWater;

    // actions
    private boolean isOn = false;

    public WashingMachine() {
        this.brand = brand;
        this.capacity = capacity;
        this.totalWater = totalWater;
    }

    public void turnOnOff() {
        if (!isOn) {
            isOn = true;
            System.out.println("Washing Machine Turned On");
        } else {
            isOn = false;
            System.out.println("Washing Machine Turned Off");
        }
    }

    public void addWater(int addedWater) {
        totalWater += addedWater;
        if (totalWater > 100) {
            totalWater = 100;
        } else if (totalWater < 0) {
            totalWater = 0;
        }
    }

    public void wash() {
        if (isOn && totalWater > 0) {
            System.out.println("Washing...");
        } else {
            System.out.println("It must be turned on and have water");
        }
    }

    public void viewInformation() {
        System.out.println("On: " + isOn + " Water amount: " + totalWater + " Brand: " + brand);
    }
}

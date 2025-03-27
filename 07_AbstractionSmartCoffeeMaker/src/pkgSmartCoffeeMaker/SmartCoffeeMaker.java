package pkgSmartCoffeeMaker;

public class SmartCoffeeMaker {

    private boolean isOn = false;
    private String coffeeType;
    private int temperature = 45;

    public SmartCoffeeMaker() {
        this.coffeeType = coffeeType;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Coffee Maker is On");
        } else {
            isOn = false;
            System.out.println("Coffee Maker is Off");
        }
    }

    public void selectCoffee(int counter) {
        if (isOn) {
            temperature += 5;
            if (temperature > 60) {
                temperature = 50;
            }
            if (counter == 1) {
                coffeeType = "espresso";
            } else if (counter == 2) {
                coffeeType = "americano";
            } else if (counter == 3) {
                coffeeType = "cappuccino";
            }
            System.out.println("Selected coffee type: " + coffeeType);
        } else {
            System.out.println("You need to turn on the coffee maker");
        }
    }

    public void viewInfo() {
        if (temperature == 45) {
            temperature = 50;
        }
        System.out.println("Is on: " + isOn + "  Temperature: " + temperature + "  Coffee Type: " + coffeeType);
    }

}

package pkgAirConditioner;

public class AirConditioner {
    private boolean isIncreasingTemperature = false;
    private boolean isDecreasingTemperature = false;
    private boolean isOn = false;
    private int temperature = 14;

    public AirConditioner() {
        this.isIncreasingTemperature = false;
        this.isDecreasingTemperature = false;
        this.isOn = false;
        this.temperature = 14;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Air conditioner turned on");
        } else {
            isOn = false;
            System.out.println("Air conditioner turned off");
        }
    }

    public void increaseTemperature() {
        isIncreasingTemperature = true;
        if (isOn) {
            if (isIncreasingTemperature) {
                temperature += 1;
                if (temperature > 25) {
                    temperature = 25;
                }
                System.out.println("Temperature: " + temperature);
            }
        }
    }

    public void decreaseTemperature() {
        isDecreasingTemperature = true;
        if (isOn) {
            if (isDecreasingTemperature) {
                temperature -= 1;
                if (temperature < 5) {
                    temperature = 5;
                }
                System.out.println("Temperature: " + temperature);
            }
        }
    }

    public void displayInfo() {
        System.out.println("Air conditioner is on: " + isOn + " | Temperature: " + temperature);
    }
}

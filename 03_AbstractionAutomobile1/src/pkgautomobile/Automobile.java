package pkgautomobile;

public class Automobile {

    private String licensePlate;
    private int manufacturingYear;
    private int totalSpeed;
    private boolean registered;
    private boolean isOn = false;
    private boolean isAccelerating = false;
    private boolean isBraking = false;

    public Automobile(String licensePlate, int manufacturingYear) {
        this.licensePlate = licensePlate;
        this.manufacturingYear = manufacturingYear;
        this.totalSpeed = 0;
        this.registered = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Car turned on");
        } else {
            isOn = false;
            System.out.println("Car turned off");
        }
    }

    public void register() {
        if (!registered) {
            registered = true;
            System.out.println("Car registered");
        } else {
            registered = false;
            System.out.println("Car unregistered");
        }
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            totalSpeed = 0;
        } else if (speed > 100) {
            totalSpeed = 100;
        } else {
            totalSpeed = speed;
        }
    }

    public void accelerate() {
        isAccelerating = true;
        if (isOn) {
            totalSpeed += 1;
            if (totalSpeed > 100) {
                totalSpeed = 100;
            }
        } else {
            System.out.println("Turn on the car first");
        }
    }

    public void brake() {
        isBraking = true;
        if (isOn) {
            totalSpeed -= 1;
            if (totalSpeed < 0) {
                totalSpeed = 0;
            }
        } else {
            System.out.println("Turn on the car first");
        }
    }

    public void viewInformation() {
        System.out.println("Car is on: " + isOn +
                           " | Speed: " + totalSpeed +
                           " | Registered: " + registered +
                           " | License Plate: " + licensePlate +
                           " | Manufacturing Year: " + manufacturingYear);
    }
}

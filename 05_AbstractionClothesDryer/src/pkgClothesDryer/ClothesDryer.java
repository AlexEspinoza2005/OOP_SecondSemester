package pkgClothesDryer;

public class ClothesDryer {

    private boolean isOn;
    private int cycle;

    public ClothesDryer() {
        this.isOn = isOn;
        this.cycle = cycle;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Dryer is on");
        } else {
            isOn = false;
            System.out.println("Dryer is off");
        }
    }

    public void chooseCycle(int cycleOption) {
        if (isOn) {
            if (cycleOption == 1) {
                cycle = 20;
                System.out.println("20-minute cycle....");
            } else if (cycleOption == 2) {
                cycle = 40;
                System.out.println("40-minute cycle....");
            } else if (cycleOption == 3) {
                cycle = 60;
                System.out.println("60-minute cycle....");
            }
        } else {
            System.out.println("Turn on the dryer");
        }
    }

    public void viewInfo() {
        System.out.println("Is on:    " + isOn + "   Current cycle: " + cycle + " minutes");
    }
}

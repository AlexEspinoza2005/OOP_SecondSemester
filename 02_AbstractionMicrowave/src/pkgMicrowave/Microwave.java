package pkgMicrowave;

public class Microwave {

    private boolean isOn = false;
    private int heatingTime;

    public Microwave() {
        this.heatingTime = heatingTime;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Microwave is On");
        } else {
            isOn = false;
            System.out.println("Microwave is Off");
        }
    }

    public void setHeatingTime(int time) {
        if (time == 1) {
            heatingTime = 30;
        } else if (time == 2) {
            heatingTime = 60;
        } else if (time == 3) {
            heatingTime = 90;
        }else{
            heatingTime=0;
        }
    }

    public void heat() {
        if (heatingTime != 0 && isOn) {
            System.out.println("Heating...");
        } else {
            System.out.println("Please turn on and set the heating time");
        }
    }

    public void viewInfo() {
        System.out.println("Is On: " + isOn + "   Heating Time: " + heatingTime);
    }
}

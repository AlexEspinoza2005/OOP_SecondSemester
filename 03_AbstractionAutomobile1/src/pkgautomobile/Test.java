package pkgautomobile;

import java.util.Scanner;

public class Test {

    public void run() {
        Automobile car = new Automobile("EXEDX1", 1985);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        
        System.out.println("Enter your option:");
        
        do {
            System.out.println("1. Turn On    2. Register   3. Enter Speed   4. Accelerate   5. Brake   6. View Info   0. Exit");
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    car.turnOn();
                    break;
                case 2:
                    car.register();
                    break;
                case 3:
                    System.out.println("Enter speed:");
                    int speed = sc.nextInt();
                    car.setSpeed(speed);
                    break;
                case 4:
                    car.accelerate();
                    break;
                case 5:
                    car.brake();
                    break;
                case 6:
                    car.viewInformation();
                    break;
            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }
}

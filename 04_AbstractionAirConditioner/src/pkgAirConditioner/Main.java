package pkgAirConditioner;

import java.util.Scanner;

public class Main {

    public void run() {
        AirConditioner airConditioner = new AirConditioner();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        System.out.println("Enter your option:");

        do {
            System.out.println("1. View status    2. Turn on    3. Increase temperature    4. Decrease temperature    0. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    airConditioner.displayInfo();
                    break;
                case 2:
                    airConditioner.turnOn();
                    break;
                case 3:
                    airConditioner.increaseTemperature();
                    break;
                case 4:
                    airConditioner.decreaseTemperature();
                    break;
            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.run();
    }
}

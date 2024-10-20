package pkgMicrowave;

import java.util.Scanner;

public class Test {

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int timeOption = 0;
        int time = 0;
        Microwave microwave = new Microwave();
        System.out.println("Enter your option: ");
        do {
            System.out.println("1. Turn On        2. Set Time          3. Heat         4. View Info     0. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    microwave.turnOn();
                    break;
                case 2: {
                    do {
                        System.out.println("1. 30s      2. 60s      3. 90s      4. 0s");
                        timeOption = sc.nextInt();
                        switch (timeOption) {
                            case 1:
                                time = 1;
                                break;
                            case 2:
                                time = 2;
                                break;
                            case 3:
                                time = 3;
                                break;
                            case 4:
                                time = 0;
                                break;
                        }
                    } while (timeOption < 1 || timeOption > 4);
                    microwave.setHeatingTime(time);
                }
                break;
                case 3:
                    microwave.heat();
                    break;
                case 4:
                    microwave.viewInfo();
                    break;
            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }
}

package pkgClothesDryer;

import java.util.Scanner;

public class Test {

    public void run() {
        ClothesDryer clothesDryer = new ClothesDryer();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Enter an option");
        do {
            System.out.println("1. Turn on       2. Choose cycle       3. View information     0.Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    clothesDryer.turnOn();
                    break;
                case 2:
                    int cycleOption = 0;
                    do {
                        System.out.println("1. 20-minute cycle      2. 40-minute cycle     3. 60-minute cycle");
                        cycleOption = sc.nextInt();
                        switch (cycleOption) {
                            case 1:
                                cycleOption = 1;
                                break;
                            case 2:
                                cycleOption = 2;
                                break;
                            case 3:
                                cycleOption = 3;
                                break;
                        }
                    } while (cycleOption < 1 || cycleOption > 3);
                    clothesDryer.chooseCycle(cycleOption);
                    break;

                case 3:
                    clothesDryer.viewInfo();
                    break;

            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

}

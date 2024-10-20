package pkgAbstractionWashingMachine;

import java.util.Scanner;

public class Main {

    public void run() {
        Scanner sc = new Scanner(System.in);
        WashingMachine washingMachine = new WashingMachine();
        int option;
        System.out.println("Enter your option: ");
        do {
            System.out.println("1. Turn On/Off    2. Add Water    3. Wash    4. View Information    0. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    washingMachine.turnOnOff();
                    break;
                case 2:
                    System.out.println("Enter the amount of water");
                    int addedWater = sc.nextInt();
                    washingMachine.addWater(addedWater);
                    break;
                case 3:
                    washingMachine.wash();
                    break;
                case 4:
                    washingMachine.viewInformation();
                    break;
            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.run();
    }
}

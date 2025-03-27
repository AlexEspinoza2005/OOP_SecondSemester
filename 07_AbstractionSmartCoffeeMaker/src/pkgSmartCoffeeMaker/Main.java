package pkgSmartCoffeeMaker;

import java.util.Scanner;

public class Main {

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int counter = 0;
        SmartCoffeeMaker coffeeMaker = new SmartCoffeeMaker();
        System.out.println("Enter an option");
        do {
            System.out.println("1. Turn On     2. Press Next Coffee (espresso, americano, and cappuccino)   3. View Information   0. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    coffeeMaker.turnOn();
                    break;
                case 2:
                    counter++;
                    if (counter > 3) {
                        counter = 1;
                    }
                    coffeeMaker.selectCoffee(counter);
                    break;
                case 3:
                    coffeeMaker.viewInfo();
                    break;

            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.run();
    }

}



package pkgTelevision;

import java.util.Scanner;

public class Test {

    public void run() {
        Television television = new Television();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Enter your option");
        do {
            System.out.println("1. Turn on    2. Choose Channel    3. Next Channel"
                    + "    4. Previous Channel    5. Decrease Volume      6. Increase Volume "
                    + "    7. View Information   0. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    television.turnOn();
                    break;
                case 2:
                    System.out.print("Enter a channel between 1 and 5: ");
                    int selectedChannel = sc.nextInt();
                    television.changeChannel(selectedChannel);
                    break;
                case 3:
                    television.increaseChannel();
                    break;
                case 4:
                    television.decreaseChannel();
                    break;
                case 5:
                    television.decreaseVolume();
                    break;
                case 6:
                    television.increaseVolume();
                    break;
                case 7:
                    television.viewInfo();
                    break;

            }

        } while (option != 0);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

}

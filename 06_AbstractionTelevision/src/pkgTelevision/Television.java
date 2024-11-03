package pkgTelevision;

public class Television {

    private boolean isOn = false;
    private int channel = 0;
    private boolean increaseVolume = false;
    private boolean decreaseVolume = false;
    private boolean nextChannel = false;
    private boolean previousChannel = false;
    private int volume = 0;

    public Television() {
        this.channel = channel;
        this.volume = volume;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Television is on");
        } else {
            isOn = false;
            System.out.println("Television is off");
        }
    }

    public void changeChannel(int selectedChannel) {
        if (isOn) {
            if (selectedChannel > 5 || selectedChannel < 0) {
                System.out.println("Channel is out of range");
            } else {
                channel = selectedChannel;
                System.out.println("Channel: " + channel);
            }
        } else {
            System.out.println("Turn on the television");
        }
    }

    public void increaseChannel() {
        nextChannel = true;
        if (isOn) {
            if (nextChannel) {
                channel += 1;
                if (channel > 5) {
                    channel = 1;
                }
                System.out.println("Channel: " + channel);
            }
        } else {
            System.out.println("You need to turn on the television");
        }
    }

    public void decreaseChannel() {
        previousChannel = true;
        if (isOn) {
            if (previousChannel) {
                channel -= 1;
                if (channel < 0) {
                    channel = 5;
                }
                System.out.println("Channel: " + channel);
            }
        } else {
            System.out.println("You need to turn on the television");
        }
    }

    public void decreaseVolume() {
        decreaseVolume = true;
        if (isOn) {
            if (decreaseVolume) {
                volume -= 1;
                if (volume < 0) {
                    volume = 0;
                }
                System.out.println("Volume: " + volume);
            }
        } else {
            System.out.println("You need to turn on the television");
        }
    }

    public void increaseVolume() {
        increaseVolume = true;
        if (isOn) {
            if (increaseVolume) {
                volume += 1;
                if (volume > 10) {
                    volume = 10;
                }
                System.out.println("Volume: " + volume);
            }
        } else {
            System.out.println("You need to turn on the television");
        }
    }

    public void viewInfo() {
        System.out.println("Is on: " + isOn + "  Channel: " + channel + "  Volume: " + volume);
    }

}

// Implementor Interface
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

// Concrete Implementor 1: TV
class TV implements Device 
{
    public void turnOn() {
        System.out.println("TV is now ON");
    }
    public void turnOff() {
        System.out.println("TV is now OFF");
    }
    public void setVolume(int volume) {
        System.out.println("TV Volume set to " + volume);
    }
}

// Concrete Implementor 2: Radio
class Radio implements Device 
{
    public void turnOn() {
        System.out.println("Radio is now ON");
    }
    public void turnOff() {
        System.out.println("Radio is now OFF");
    }
    public void setVolume(int volume) {
        System.out.println("Radio Volume set to " + volume);
    }
}

// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setVolume(int volume);
}

// Refined Abstraction: BasicRemote
class BasicRemote extends RemoteControl {

    public BasicRemote(Device device) {
        super(device);
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new BasicRemote(tv);

        remote.turnOn();
        remote.setVolume(10);
        remote.turnOff();

        // Now using a Radio with the same BasicRemote
        Device radio = new Radio();
        remote = new BasicRemote(radio);

        remote.turnOn();
        remote.setVolume(5);
        remote.turnOff();
    }
}
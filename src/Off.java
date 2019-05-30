public class Off implements MovieDownloaderState {
    @Override
    public void entry() {
        System.out.println("enter Off state");
    }

    @Override
    public void turnOn(MovieDownloaderMachine machine) {
        machine.setState(new On());
    }

    @Override
    public void turnOff(MovieDownloaderMachine machine) {
    }

    @Override
    public void exit() {
        System.out.println("exit Off state");
    }
}

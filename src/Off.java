public class Off implements MovieDownloaderState {
    private MovieDownloaderMachine machine;
    public Off(MovieDownloaderMachine machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter Off state");
    }

    @Override
    public void turnOn() {
        On newON = machine.getOnState();
        machine.setState(newON);
        newON.initialize();
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void exit() {
        System.out.println("exit Off state");
    }

    @Override
    public void triggerEvent(String input) {
    }
}

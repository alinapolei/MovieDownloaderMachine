public class On implements MovieDownloaderState {
    @Override
    public void entry() {
        System.out.println("enter On state");
    }

    @Override
    public void turnOn(MovieDownloaderMachine machine) {
    }

    @Override
    public void turnOff(MovieDownloaderMachine machine) {
        machine.setState(new Off());
    }

    @Override
    public void exit() {
        System.out.println("exit On state");
    }


}

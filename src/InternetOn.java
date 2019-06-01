public class InternetOn implements IInternetStatus {
    public On machine;

    public InternetOn(On m) { machine = m; }
    @Override
    public void internetOn() { }

    @Override
    public void internetOff() {
        machine.setInternetStatus(new InternetOff(machine));

    }

    @Override
    public void entry() {
        System.out.println("enter InternetOn state");
        /*if(machine.getDownload() instanceof PauseMovie)
        {
            System.out.println("exit PauseMovie state\n");
            machine.setWatchMovie(new WatchMovie(machine));
        }*/
    }

    @Override
    public void exit() {
        System.out.println("exist InternetOn state");
    }
}

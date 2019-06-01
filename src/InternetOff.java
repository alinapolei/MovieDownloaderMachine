public class InternetOff implements IInternetStatus {

    private On machine;
    public InternetOff(On m) { machine = m; }


    @Override
    public void internetOn() {
        machine.setInternetStatus(new InternetOn(machine));
    }

    @Override
    public void internetOff() { }

    @Override
    public void entry() {
        System.out.println("enter InternetOff state");
        /*if(machine.getDownload() instanceof WatchMovie)
        {
            System.out.println("exit WatchMovie state\n");
            machine.setWatchMovie(new PauseMovie(machine));
        }*/
    }

    @Override
    public void exit() {
        System.out.println("exist InternetOff state");
    }
}

public class On implements MovieDownloaderState {
    private MovieDownloaderMachine machine;
    private IInternetStatus networkRegionState;
    private ILevelUserState levelUserState = new BeginnerState(this);

    public On(MovieDownloaderMachine machine){
        this.machine = machine;
    }

    public void initialize() {
        networkRegionState = new InternetOff(this);
        networkRegionState.entry();
        levelUserState.entry();
    }

    public void setInternetStatus(IInternetStatus state){
        this.networkRegionState.exit();
        this.networkRegionState = state;
        this.networkRegionState.entry();
    }

    public void setLevelUserState(ILevelUserState levelUserState) {
        this.levelUserState.exit();
        this.levelUserState = levelUserState;
        this.levelUserState.entry();
    }

    public int getScore() {
        return machine.getScore();
    }
    public void setScore(int score) {
        machine.setScore(score);
        levelUserState.when();
    }

    public double getSpeed(){ return machine.getSpeed(); }
    public void setSpeed(double speed){ machine.setSpeed(speed); }

    @Override
    public void entry() {
        System.out.println("enter On state");
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
        machine.setState(machine.getOffState());
    }

    @Override
    public void exit() {
        System.out.println("exit On state");
    }

    @Override
    public void triggerEvent(String input) {
        switch (input){
            case "internetOn":
                networkRegionState.internetOn();
                break;
            case "internetOff":
                networkRegionState.internetOff();
                break;

            case "Up1":
                setScore(4);
                break;
            case "Up2":
                setScore(7);
                break;
            case "Down1":
                setScore(3);
                break;
            case "Down2":
                setScore(6);
                break;
        }
    }
}

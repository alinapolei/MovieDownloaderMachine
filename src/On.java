public class On implements MovieDownloaderState {
    private MovieDownloaderMachine machine;
    private IInternetStatus networkRegionState;
    private ILevelUserState levelUserState = new BeginnerState(this);
    private IDownload downloadState = new Download(this);
    private IWarchMovie watchMovieState;

    public On(MovieDownloaderMachine machine){
        this.machine = machine;
    }

    public void initialize() {
        networkRegionState = new InternetOff(this);
        networkRegionState.entry();
        levelUserState.entry();
        //downloadState.entry();
        watchMovieState = new IdleWatchMovie(this);
        watchMovieState.entry();
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

    public void setWatchMovie(IWarchMovie watchMovie) {
        this.watchMovieState.exit();
        this.watchMovieState = watchMovie;
        this.watchMovieState.entry();
    }

    public boolean isInDownload(){
        return downloadState instanceof Download;
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

    public int getDownloadStatus() { return machine.getDownloadStatus(); }
    public void setDownloadStatus(int downloadStatus) { machine.setDownloadStatus(downloadStatus); }

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
                watchMovieState.pause();
                break;
            case "movieOn":
                watchMovieState.movieOn();
                break;
            case "restartMovie":
                watchMovieState.restartMovie();
                break;
            case "holdMovie":
                watchMovieState.holdMovie();
                break;
            case "movieOff":
                watchMovieState.abort();
                break;
            case "resume":
                watchMovieState.resume();
                break;
            case "downloadAborted":
                watchMovieState.abort();
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

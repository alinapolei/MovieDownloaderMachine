public class On implements MovieDownloaderState {
    private MovieDownloaderMachine machine;
    private IInternetStatus networkRegionState;
    private ILevelUserState levelUserState = new BeginnerState(this);
    private IDownload downloadState = new WaitForFile(this);
    private IWarchMovie watchMovieState;
    private boolean istried = false;
    private double fileSize = 0;

    public On(MovieDownloaderMachine machine){
        this.machine = machine;
    }

    public void initialize() {
        networkRegionState = new InternetOff(this);
        networkRegionState.entry();
        levelUserState.entry();
        downloadState.entry();
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

    public void setDownloadState(IDownload downloadState) {
        this.downloadState.exit();
        this.downloadState = downloadState;
        this.downloadState.entry();
    }

    public boolean isInDownload(){
        return downloadState instanceof Download;
    }
    public boolean isInInternetOn(){
        return networkRegionState instanceof InternetOn;
    }
    public void downloadFinished(){
        watchMovieState.abort();
    }
    public void downloadStarted(){
        watchMovieState.unPause();
    }
    public void timeToAbort(){
        watchMovieState.abort();
    }


    public int getScore() {
        return machine.getScore();
    }
    public void setScore(int score) {
        machine.setScore(score);
        levelUserState.when();
    }

    public boolean isTried() {
        return istried;
    }
    public void setIstried(boolean istried) {
        this.istried = istried;
    }

    public double getSpeed(){ return machine.getSpeed(); }
    public void setSpeed(double speed){ machine.setSpeed(speed); }

    public int getDownloadStatus() { return machine.getDownloadStatus(); }
    public void setDownloadStatus(int downloadStatus) { machine.setDownloadStatus(downloadStatus); }

    public double getFreeSpace() { return machine.getFreeSpace(); }
    public void setFreeSpace(double freeSpace) { machine.setFreeSpace(freeSpace); }


    public double getFileSize() {
        return fileSize;
    }
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

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
        if(input.split(" ")[0].equals("fileRequest")) {
            fileSize = Double.parseDouble(input.split(" ")[1]);
            downloadState.fileRequest();
        }
        switch (input){
            case "turnOff":
                downloadState.turnOff();
                break;
            case "internetOn":
                networkRegionState.internetOn();
                downloadState.internetOn();
                break;
            case "internetOff":
                networkRegionState.internetOff();
                watchMovieState.pause();
                downloadState.internetOff();
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
                downloadState.downloadAborted();
                break;
            case "fileRequest":
                downloadState.fileRequest();
                break;
            case "downloadError":
                downloadState.downloadError();
                watchMovieState.pause();
                break;
            case "errorFixed":
                downloadState.errorFixed();
                break;
        }
    }
}

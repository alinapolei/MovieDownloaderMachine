import java.util.Queue;

public class MovieDownloaderMachine {
    private MovieDownloaderState state;
    private On onState;
    private Off offState;
    private int Score = 0 ;
    private double speed = 0.0;
    private int downloadStatus=20;

    public MovieDownloaderMachine(){
        onState = new On(this);
        offState = new Off(this);
        state = offState;
        state.entry();
    }

    public void setState(MovieDownloaderState state){
        this.state.exit();
        this.state = state;
        this.state.entry();
    }

    public On getOnState() {
        return onState;
    }
    public Off getOffState() {
        return offState;
    }

    public int getScore() {
        return Score;
    }
    public void setScore(int score) {
        Score = score;
    }

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDownloadStatus() {
        return downloadStatus;
    }
    public void setDownloadStatus(int downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public void triggerEvent(String input){
        switch (input){
            case "turnOn":
                state.turnOn();
                break;
            case "turnOff":
                state.turnOff();
                break;
            default:
                state.triggerEvent(input);
        }
    }
}

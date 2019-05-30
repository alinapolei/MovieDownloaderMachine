import java.util.Queue;

public class MovieDownloaderMachine {
    private MovieDownloaderState state;

    public MovieDownloaderMachine(){
        state = new Off();
        state.entry();
    }

    public void setState(MovieDownloaderState state){
        this.state.exit();
        this.state = state;
        this.state.entry();
    }

    public void triggerEvent(String input){
        switch (input){
            case "turnOn":
                state.turnOn(this);
                break;
            case "turnOff":
                state.turnOff(this);
                break;
        }
    }
}

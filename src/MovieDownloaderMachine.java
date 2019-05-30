import java.util.Queue;

public class MovieDownloaderMachine {
    private MovieDownloaderState state;

    public MovieDownloaderMachine(){
        state = new Off();
    }

    public void setState(MovieDownloaderState state){
        this.state = state;
    }

    public void triggerEvent(String input){
        switch (input){
            case "turnOn":
                state.turnOn(this);
        }
    }
}

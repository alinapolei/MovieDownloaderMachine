import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class NoSpace implements IDownload {
    private On machine;
    public NoSpace(On machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter NoSpace state");
        doFunc();
    }

    Timer timer;
    private void doFunc() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                machine.setIstried(true);
                machine.setDownloadState(new CheckFile(machine));
                timer.cancel();
            }
        }, 4000);
    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {
        timer.cancel();
        machine.setDownloadState(new WaitForFile(machine));
    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void turnOff() {
        timer.cancel();
    }

    @Override
    public void exit() {
        System.out.println("exit NoSpace state");
    }
}

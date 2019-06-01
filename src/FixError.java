import java.util.Timer;
import java.util.TimerTask;

public class FixError implements IDownload {
    private On machine;
    public FixError(On machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter FixError state");
        doFunc();
    }

    Timer timer;
    private void doFunc() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                machine.setScore(machine.getScore()-1);
                machine.setDownloadState(new WaitForFile(machine));
                machine.timeToAbort();
            }
        }, 3000);
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
        timer.cancel();
        machine.setDownloadState(new Download(machine));
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
        System.out.println("exit FixError state");
    }
}

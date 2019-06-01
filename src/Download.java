import java.util.Timer;
import java.util.TimerTask;

public class Download implements IDownload {
    private On machine;
    private Timer timer;

    public Download(On machine) {
        this.machine = machine;
    }
    public void init(){
        counter = 0;
    }

    @Override
    public void entry() {
        System.out.println("enter Download state");
        machine.downloadStarted();
        doFunc();
    }

    static int counter;
    private void doFunc() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                counter++;
                int per = (int) Math.ceil((counter*machine.getSpeed()*100)/machine.getFileSize());
                machine.setDownloadStatus(per);
                /*if(per > 100)
                    System.out.println("100%");
                else
                    System.out.println(machine.getDownloadStatus() + "%");*/

                if(machine.getDownloadStatus() >= 100) {
                    timer.cancel();
                    machine.setDownloadState(new FinishDownload(machine));
                }
            }
        }, 0, 1000);
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
        timer.cancel();
        machine.setDownloadState(new FixError(machine));
    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void internetOff() {
        timer.cancel();
        machine.setDownloadState(new WaitForInternet(machine));
    }

    @Override
    public void internetOn() {

    }

    @Override
    public void turnOff() {
        timer.cancel();
        machine.setDownloadState(new WaitForInternet(machine));
    }

    @Override
    public void exit() {
        System.out.println("exit Download state");
    }
}

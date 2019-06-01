public class WaitForInternet implements IDownload {
    private On machine;
    public WaitForInternet(On machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter WaitForInternet state");
    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {
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
        machine.setDownloadState(new Download(machine));
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void exit() {
        System.out.println("exit WaitForInternet state");
    }
}

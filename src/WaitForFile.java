public class WaitForFile implements IDownload {
    private On machine;
    public WaitForFile(On machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter WaitForFile state");
        machine.setIstried(false);
        machine.setFileSize(0);
    }

    @Override
    public void fileRequest() {
        machine.setDownloadState(new CheckFile(machine));
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

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void exit() {
        System.out.println("exit WaitForFile state");
    }
}

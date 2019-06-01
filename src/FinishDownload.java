public class FinishDownload implements IDownload {
    private On machine;
    public FinishDownload(On machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter FinishDownload state");
        machine.setFreeSpace(machine.getFreeSpace()-machine.getFileSize());
        machine.setScore(machine.getScore()+1);
        machine.downloadFinished();
        machine.setDownloadState(new WaitForFile(machine));
    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {

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
        System.out.println("exit FinishDownload state");
    }
}

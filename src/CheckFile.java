public class CheckFile implements IDownload {
    private On machine;
    public CheckFile(On machine){
        this.machine = machine;
    }

    @Override
    public void entry() {
        System.out.println("enter CheckFile state");
        doFunc();
    }

    private void doFunc(){
        boolean isSpace = machine.getFreeSpace() >= machine.getFileSize();
        if(!machine.isInInternetOn()){
            machine.setScore(machine.getScore()-1);
            machine.setDownloadState(new WaitForFile(machine));
        }
        else if(!isSpace && !machine.isTried())
            machine.setDownloadState(new NoSpace(machine));
        else if(!isSpace && machine.isTried()) {
            machine.setScore(machine.getScore()-1);
            machine.setDownloadState(new WaitForFile(machine));
        }
        else if(isSpace && machine.isInInternetOn()){
            machine.setDownloadStatus(0);
            Download download = new Download(machine);
            download.init();
            machine.setDownloadState(download);
        }
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

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void exit() {
        System.out.println("exit CheckFile state");
    }
}

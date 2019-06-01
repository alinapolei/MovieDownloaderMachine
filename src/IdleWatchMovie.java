public class IdleWatchMovie implements IWarchMovie {

    On machine;
    public IdleWatchMovie(On m) { machine = m ;}

    @Override
    public void entry() { System.out.println("enter IdleWatchMovie state"); }

    @Override
    public void movieOn()
    {
        if(machine.getDownloadStatus() >= 20 && machine.isInDownload() )
            machine.setWatchMovie(new InitializationWatchMovie(machine));
    }

    @Override
    public void restartMovie() { }

    @Override
    public void holdMovie() { }

    @Override
    public void resume() { }

    @Override
    public void abort() { }

    @Override
    public void pause() {

    }

    @Override
    public void unPause() {

    }

    @Override
    public void exit() {
        System.out.println("exit IdleWatchMovie state");
    }
}

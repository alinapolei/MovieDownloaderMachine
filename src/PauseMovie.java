public class PauseMovie implements IWarchMovie {

    private On machine;
    public PauseMovie(On m) { machine = m;}

    @Override
    public void entry() { System.out.println("enter PauseMovie state");}

    @Override
    public void movieOn() { }

    @Override
    public void restartMovie() { }

    @Override
    public void holdMovie() { }

    @Override
    public void resume() { }

    @Override
    public void abort() {
        machine.setWatchMovie(new StopMovie(machine));
    }

    @Override
    public void pause() { }

    @Override
    public void unPause() {
        machine.setWatchMovie(new WatchMovie(machine));
    }

    @Override
    public void exit() {
        System.out.println("exit PauseMovie state");
    }
}

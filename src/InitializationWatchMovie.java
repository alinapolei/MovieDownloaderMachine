public class InitializationWatchMovie implements IWarchMovie {
    private On machine ;
    public InitializationWatchMovie(On m) { machine = m; }

    @Override
    public void entry() {
        System.out.println("enter InitializationWatchMovie state");
        machine.setWatchMovie(new WatchMovie(machine));
    }

    @Override
    public void movieOn() { }

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
        System.out.println("exit InitializationWatchMovie state");
    }
}

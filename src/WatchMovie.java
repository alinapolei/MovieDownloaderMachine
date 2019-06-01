public class WatchMovie implements IWarchMovie {

    public On machine;

    public WatchMovie(On m) { machine = m ; }

    @Override
    public void entry() {
        System.out.println("enter WatchMovie state");
    }

    @Override
    public void movieOn() { }

    @Override
    public void restartMovie() {
        machine.setWatchMovie(new InitializationWatchMovie(machine));
    }

    @Override
    public void holdMovie() {
        machine.setWatchMovie(new holdMovie(machine));
    }

    @Override
    public void resume() { }

    @Override
    public void abort() {
        machine.setWatchMovie(new StopMovie(machine));
    }

    @Override
    public void pause() {
        machine.setWatchMovie(new PauseMovie(machine));
    }

    @Override
    public void unPause() {

    }

    @Override
    public void exit() {
        System.out.println("exit WatchMovie state");
    }
}

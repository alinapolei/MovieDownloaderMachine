public class StopMovie implements  IWarchMovie {

    public On machine;

    public StopMovie(On m) { machine = m;}

    @Override
    public void entry() {
        System.out.println("enter StopMovie state");
        machine.setWatchMovie(new IdleWatchMovie(machine));
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
        System.out.println("exit StopMovie state");
    }
}

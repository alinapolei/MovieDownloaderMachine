public class holdMovie implements IWarchMovie {
    public  On machine;
    public holdMovie(On m) { machine = m ;}

    @Override
    public void entry() { System.out.println("enter holdMovie state"); }


    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void resume() {
        machine.setWatchMovie(new WatchMovie(machine));
    }

    @Override
    public void abort() {
        machine.setWatchMovie(new StopMovie(machine));
    }

    @Override
    public void pause() {

    }

    @Override
    public void unPause() {

    }

    @Override
    public void exit() {
        System.out.println("exit holdMovie state");
    }
}

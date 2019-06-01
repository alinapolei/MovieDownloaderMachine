public class BeginnerState implements ILevelUserState {

    On machine;

    public BeginnerState(On m) {machine = m; }

    @Override
    public void entry() {
        System.out.println("enter Beginner state");
        machine.setSpeed(1);
    }

    @Override
    public void when() {
        if(machine.getScore() == 4 )
            machine.setLevelUserState(new AdvancedState(machine));
    }

    @Override
    public void exit() {
        System.out.println("exit Beginner state");
    }

}

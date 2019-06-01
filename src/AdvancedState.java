public class AdvancedState implements ILevelUserState {

    private On machine;

    public AdvancedState(On m) {machine = m; }

    @Override
    public void entry() {
        System.out.println("enter Advance state");
        machine.setSpeed(1.2);
    }

    @Override
    public void when() {
        if(machine.getScore() == 7 )
            machine.setLevelUserState(new ProfessionalState(machine));
        else if(machine.getScore() < 4)
            machine.setLevelUserState(new BeginnerState(machine));
    }

    @Override
    public void exit() {
        System.out.println("exit Advanced state");
    }
}

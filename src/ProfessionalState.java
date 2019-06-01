public class ProfessionalState implements ILevelUserState {

    private On machine;

    public ProfessionalState(On m) {
        machine = m;
    }

    @Override
    public void entry() {
        System.out.println("enter Professional state");
        machine.setSpeed(1.5);
    }

    @Override
    public void when() {
        if (machine.getScore() < 7)
            machine.setLevelUserState(new AdvancedState(machine));
    }

    @Override
    public void exit() {
        System.out.println("exit Professional state");
    }

}

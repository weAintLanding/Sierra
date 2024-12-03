public class Axis {
    private int axisValue = 0;

    public void changeAxis(Players pilot, Players copilot) {
        Integer pilotValue = pilot.getAxis();
        Integer copilotValue = copilot.getAxis();
        int changeValue = copilotValue - pilotValue;
        axisValue = axisValue + changeValue;
    }

    public int getAxisValue() {
        return axisValue;
    }
}

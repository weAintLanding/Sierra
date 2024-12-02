public class Engine {
    private final Airplane airplane;
    private int blueAeroMarker = 4;
    private int orangeAeroMarker = 8;
    private int redBrakeMarker = 1;

    public Engine(Airplane airplane) {
        this.airplane = airplane;
    }

    //Getter and Setter for AeroMarkers
    public int getBlueAeroMarker() {
        return blueAeroMarker;
    }

    public void setBlueAeroMarker(int blueAeroMarker) {
        this.blueAeroMarker = blueAeroMarker;
    }

    public int getOrangeAeroMarker() {
        return orangeAeroMarker;
    }

    public void setOrangeAeroMarker(int orangeAeroMarker) {
        this.orangeAeroMarker = orangeAeroMarker;
    }

    public int getRedBrakeMarker() {
        return redBrakeMarker;
    }

    public void setRedBrakeMarker(int redBrakeMarker) {
        this.redBrakeMarker = redBrakeMarker;
    }

    public void movePlane(int pilotValue, int copilotValue) {
        int engineSum = pilotValue + copilotValue;

        if (engineSum <= blueAeroMarker) {
            System.out.println("Plane does not move");
        } else if (engineSum <= orangeAeroMarker) {
            System.out.println("Plane moves 1 position.");
            airplane.setApproachPosition(airplane.getApproachPosition() + 1);
        } else {
            System.out.println("Plane moves 2 positions.");
            airplane.setApproachPosition(airplane.getApproachPosition() + 2);
        }
    }
}

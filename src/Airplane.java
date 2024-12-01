class Axis{
    private final Airplane airplane;
    private int axisValue = 0;

    public Axis(Airplane airplane){
        this.airplane = airplane;
    }

    private void changeAxis(int pilotValue, int copilotValue){
        int changeValue = copilotValue - pilotValue;
        axisValue = axisValue + changeValue;

        if(axisValue < -2 || axisValue > 2){
            System.out.println("Plane has crashed.");
        }
    }

    public int getAxisValue() {
        return axisValue;
    }
}

class Engine{
    private final Airplane airplane;
    private int blueAeroMarker = 5;
    private int orangeAeroMarker = 9;

    public Engine(Airplane airplane){
        this.airplane = airplane;
    }

    //Getter and Setter for AeroMarkers
    public int getBlueAeroMarker(){
        return blueAeroMarker;
    }
    public void setBlueAeroMarker(int blueAeroMarker){
        this.blueAeroMarker = blueAeroMarker;
    }
    public int getOrangeAeroMarker(){
        return  orangeAeroMarker;
    }
    public void setOrangeAeroMarker(int orangeAeroMarker){
        this.orangeAeroMarker = orangeAeroMarker;
    }

    private void movePlane(int pilotValue, int copilotValue){
        int engineSum = pilotValue+copilotValue;

        if(engineSum < blueAeroMarker){
            System.out.println("Plane does not move");
        }
        else if(engineSum < orangeAeroMarker){
            System.out.println("Plane moves 1 position.");
            airplane.setApproachPosition(airplane.getApproachPosition()+1);
        }
        else{
            System.out.println("Plane moves 2 positions.");
            airplane.setApproachPosition(airplane.getApproachPosition()+2);
        }
    }
}

class Brakes{
    private int redBrakeMarker = 2;
    private final Airplane airplane;

    public Brakes(Airplane airplane) {
        this.airplane = airplane;
    }

    //Getter and Setter for brakeMarker
    public int getRedBrakeMarker() {
        return redBrakeMarker;
    }
    public void setRedBrakeMarker(int redBrakeMarker) {
        this.redBrakeMarker = redBrakeMarker;
    }
}

class LandingGear{
    private final Airplane airplane;

    public LandingGear(Airplane airplane) {
        this.airplane = airplane;
    }
}

class Flaps{
    private final Airplane airplane;

    public Flaps(Airplane airplane) {
        this.airplane = airplane;
    }
}

class Radio{
    private final Airplane airplane;

    public Radio(Airplane airplane) {
        this.airplane = airplane;
    }
}

class Concentration{
    private final Airplane airplane;

    public Concentration(Airplane airplane) {
        this.airplane = airplane;
    }
}


class Airplane{
    private int altitude = 0;
    private int approachPosition = 0;

    private Axis axis;
    private Engine engine;
    private Brakes brakes;
    private LandingGear landingGear;
    private Flaps flaps;
    private Radio radio;
    private Concentration concentration;

    public Airplane(){
        engine = new Engine(this);
        axis = new Axis(this);
        brakes = new Brakes(this);
        landingGear = new LandingGear(this);
        flaps = new Flaps(this);
        radio = new Radio(this);
        concentration = new Concentration(this);
    }

    public Axis getAxis() {
        return axis;
    }
    public Engine getEngine(){
        return engine;
    }
    public Brakes getBrakes() {
        return brakes;
    }
    public LandingGear getLandingGear() {
        return landingGear;
    }
    public Flaps getFlaps(){
        return flaps;
    }
    public Radio getRadio(){
        return radio;
    }
    public Concentration getConcentration() {
        return concentration;
    }

    //Getter and Setter for ApproachPosition
    public int getApproachPosition(){
        return approachPosition;
    }
    public void setApproachPosition(int approachPosition){
        this.approachPosition = approachPosition;
    }

    public int getAltitude(){
        return altitude;
    }
    public void setAltitude(int altitude){
        this.altitude = altitude;
    }
}
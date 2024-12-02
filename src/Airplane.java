class Axis{
    private int axisValue = 0;

    public void changeAxis(Players pilot, Players copilot){
        Integer pilotValue = pilot.getAxis();
        Integer copilotValue = copilot.getAxis();
        int changeValue = copilotValue - pilotValue;
        axisValue = axisValue + changeValue;
    }

    public int getAxisValue() {
        return axisValue;
    }
}

class Engine{
    private final Airplane airplane;
    private int blueAeroMarker = 4;
    private int orangeAeroMarker = 8;
    private int redBrakeMarker = 1;

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
    public int getRedBrakeMarker(){
        return redBrakeMarker;
    }
    public void setRedBrakeMarker(int redBrakeMarker){
        this.redBrakeMarker = redBrakeMarker;
    }

    public void movePlane(int pilotValue, int copilotValue){
        int engineSum = pilotValue+copilotValue;

        if(engineSum <= blueAeroMarker){
            System.out.println("Plane does not move");
        }
        else if(engineSum <= orangeAeroMarker){
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
    private final Airplane airplane;

    private final boolean[] brakeFields = {false,false,false};
    private int activatedBrakeFields = 0;

    public Brakes(Airplane airplane){
        this.airplane = airplane;
    }

    public int getActivatedBrakeFields() {
        return activatedBrakeFields;
    }

    //Brake fields
    public void setBrakeFieldsTrue(int index) {
        for(int i=0; i<=index; i++){
            if(i!=index && !brakeFields[i]){
                System.out.println("Previous field(s) not true");
                return;
            }else if(i==index && !brakeFields[i]){
                brakeFields[i] = true;
                activatedBrakeFields++;
                if(activatedBrakeFields == 1){
                    airplane.getEngine().setRedBrakeMarker((airplane.getEngine().getRedBrakeMarker())+1);
                }else if(activatedBrakeFields <= 3){
                    airplane.getEngine().setRedBrakeMarker((airplane.getEngine().getRedBrakeMarker())+2);
                }
                return;
            }
        }
    }
}

class LandingGear{
    private final Airplane airplane;

    private final boolean[] landingGearFields = {false,false,false};
    private int activatedLandingGearFields = 0;

    public LandingGear(Airplane airplane) {
        this.airplane = airplane;
    }

    public int getActivatedLandingGearFields() {
        return activatedLandingGearFields;
    }

    public void setLandingGearFieldsTrue(int index) {
        if(index>=0 && index<landingGearFields.length && !landingGearFields[index]){
            landingGearFields[index] = true;
            activatedLandingGearFields++;
            airplane.getEngine().setBlueAeroMarker((airplane.getEngine().getBlueAeroMarker())+1);
        }
    }
}

class Flaps{
    private final Airplane airplane;

    private final boolean[] flapFields = {false,false,false,false};
    private int activatedFlapFields = 0;

    public Flaps(Airplane airplane) {
        this.airplane = airplane;
    }

    public int getActivatedFlapFields() {
        return activatedFlapFields;
    }

    public void setFlapFieldsTrue(int index) {
        for(int i=0; i<index+1; i++){
            if(i!=index && !flapFields[i]){
                System.out.println("Previous field(s) not true");
                return;
            }else if(i==index && !flapFields[i]){
                flapFields[i] = true;
                activatedFlapFields++;
                airplane.getEngine().setOrangeAeroMarker((airplane.getEngine().getOrangeAeroMarker())+1);
                return;
            }
        }
    }

}

class Radio{
    private final int radioFields = 0;

    public int getRadioFields() {
        return radioFields;
    }
}

class Concentration{
    private final int coffeeAvailable = 0;

    public int getCoffeeAvailable(){
        return coffeeAvailable;
    }
}

class Airplane{
    private int altitude = 6000;
    private int approachPosition = 0;

    private final Axis axis;
    private final Engine engine;
    private final Brakes brakes;
    private final LandingGear landingGear;
    private final Flaps flaps;
    private final Radio radio;
    private final Concentration concentration;

    public Airplane(){
        engine = new Engine(this);
        axis = new Axis();
        brakes = new Brakes(this);
        landingGear = new LandingGear(this);
        flaps = new Flaps(this);
        radio = new Radio();
        concentration = new Concentration();
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
    public void setAltitude(){
        if(altitude>0 && altitude<=6000){
            this.altitude = altitude-1000;
        }
    }
}
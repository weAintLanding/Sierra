public class Airplane{
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
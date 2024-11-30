import java.util.ArrayList;
import java.util.Random;

class LandingGear{

}

class Brakes{
    private int redBrakeMarker = 2;

    //Getter and Setter for brakeMarker
    public int getRedBrakeMarker() {
        return redBrakeMarker;
    }
    public void setRedBrakeMarker(int redBrakeMarker) {
        this.redBrakeMarker = redBrakeMarker;
    }
}

class Flaps{

}

class Axis{
    private int axisValue = 0;

    private void changeAxis(int pilotValue, int copilotValue){
        int changeValue = copilotValue - pilotValue;
        axisValue = axisValue + changeValue;

        if(axisValue < -2 || axisValue > 2){
            System.out.println("Plane has crashed.");
        }
    }
}

class Radio{

}

class Concentration{

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

class Airplane{
    private int Altitue = 0;
    private int approachPosition = 0;

    private LandingGear landingGear = new LandingGear();
    private Brakes brakes = new Brakes();
    private Flaps flaps = new Flaps();
    private Axis axis = new Axis();
    private Radio radio = new Radio();
    private Concentration concentration = new Concentration();
    private Engine engine;


    public Airplane(){
        engine = new Engine(this);
    }

    public Engine getEngine(){
        return engine;
    }

    //Getter and Setter for ApproachPosition
    public int getApproachPosition(){
        return approachPosition;
    }
    public void setApproachPosition(int approachPosition){
        this.approachPosition = approachPosition;
    }



}
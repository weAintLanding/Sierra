public class Main {
    public static void main(String[] args) {
        System.out.println("Player Temporary Testing");
        CoPilot copilot = new CoPilot();
        Pilot pilot = new Pilot();
        //Dice roll test
        pilot.rollDice();
        copilot.rollDice();
        //Coffee test
        pilot.setCoffee(2);
        // pilot.useCoffee(5,1);
        pilot.getCoffee();
        pilot.getDiceRolls();
        //Throttle test
        pilot.setThrottle(6);
        pilot.getThrottle();
        //Axis test
        pilot.setAxis(4);
        copilot.setAxis(2);
        //Radio test
        copilot.setRadio(3);
        copilot.getRadio();
        copilot.setRadio(2);
        copilot.getRadio();
        pilot.setRadio(1);
        pilot.setRadio(5);

        System.out.println();
        System.out.println("Airplane Temporary Testing");
        System.out.println();

        Airplane airplane = new Airplane();
        System.out.println("Axis: " + airplane.getAxis().getAxisValue());
        airplane.getAxis().changeAxis(pilot,copilot);
        System.out.println("Axis: " + airplane.getAxis().getAxisValue());
        System.out.println();

        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getEngine().movePlane(4,4);
        System.out.println("Position: " + airplane.getApproachPosition());
        System.out.println();

        System.out.println("Blue Aero Marker(Landing Gear): " + airplane.getEngine().getBlueAeroMarker());
        System.out.println("Landing Gears Activated: " + airplane.getLandingGear().getActivatedLandingGearFields());
        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getEngine().movePlane(2,3);
        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getLandingGear().setLandingGearFieldsTrue(1);
        System.out.println("Blue Aero Marker(Landing Gear): " + airplane.getEngine().getBlueAeroMarker());
        System.out.println("Landing Gears Activated: " + airplane.getLandingGear().getActivatedLandingGearFields());
        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getEngine().movePlane(2,3);
        System.out.println("Position: " + airplane.getApproachPosition());
        System.out.println();

        System.out.println("Orange Aero Marker(Flaps): " + airplane.getEngine().getOrangeAeroMarker());
        System.out.println("Flaps Activated: " + airplane.getFlaps().getActivatedFlapFields());
        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getEngine().movePlane(5,4);
        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getFlaps().setFlapFieldsTrue(1);
        airplane.getFlaps().setFlapFieldsTrue(2);
        airplane.getFlaps().setFlapFieldsTrue(0);
        System.out.println("Orange Aero Marker(Flaps): " + airplane.getEngine().getOrangeAeroMarker());
        System.out.println("Flaps Activated: " + airplane.getFlaps().getActivatedFlapFields());
        System.out.println("Position: " + airplane.getApproachPosition());
        airplane.getEngine().movePlane(5,4);
        System.out.println("Position: " + airplane.getApproachPosition());
        System.out.println();

        System.out.println("Red Brake Marker: " + airplane.getEngine().getRedBrakeMarker());
        System.out.println("Brakes Activated: " + airplane.getBrakes().getActivatedBrakeFields());
        airplane.getBrakes().setBrakeFieldsTrue(1);
        airplane.getBrakes().setBrakeFieldsTrue(2);
        airplane.getBrakes().setBrakeFieldsTrue(0);
        System.out.println("Red Brake Marker: " + airplane.getEngine().getRedBrakeMarker());
        airplane.getBrakes().setBrakeFieldsTrue(2);
        airplane.getBrakes().setBrakeFieldsTrue(1);
        System.out.println("Red Brake Marker: " + airplane.getEngine().getRedBrakeMarker());
        airplane.getBrakes().setBrakeFieldsTrue(0);
        System.out.println("Red Brake Marker: " + airplane.getEngine().getRedBrakeMarker());
        airplane.getBrakes().setBrakeFieldsTrue(2);
        System.out.println("Red Brake Marker: " + airplane.getEngine().getRedBrakeMarker());
        System.out.println();

        System.out.println("Coffee Available: " + airplane.getConcentration().getCoffeeAvailable());
        System.out.println("Radio Available: " + airplane.getRadio().getRadioFields());

        System.out.println();

        System.out.println("Altitude: " + airplane.getAltitude());
        airplane.setAltitude();
        System.out.println("Altitude: " + airplane.getAltitude());
    }
}

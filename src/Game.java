public class Game {
    private Airplane airplane;
    private Pilot pilot;
    private CoPilot copilot;
    private int roundNumber;
    private int rerollsAvailable;
    private int startingPlayer;
    private ApproachTrack approachTrack;
    private Players currentPlayer;
    private final int maxRounds = 5;
    private AltitudeTrack altitudeTrack;

    public Game() {
        this.airplane = new Airplane();
        this.pilot = new Pilot();
        this.copilot = new CoPilot();
        this.roundNumber = 1;
        this.rerollsAvailable = 0;
        this.currentPlayer = pilot;
        this.approachTrack = new ApproachTrack();
    }


    public boolean checkWin() {
        if (airplane.getApproachPosition() == 6 // Final position in the approach track
                && airplane.getAltitude() == 0 // Altitude must be 0
                && airplane.getAxis().getAxisValue() == 0 // Axis must be balanced
                && airplane.getLandingGear().getActivatedLandingGearFields() == 3 // Landing gear engaged
                && airplane.getBrakes().getActivatedBrakeFields() == 3 // Brakes engaged
                && airplane.getFlaps().getActivatedFlapFields() == 4) { // Flaps fully engaged
            return true;
        }
        return false;
    }

    public boolean checkCrash() {
        if (airplane.getAxis().getAxisValue() < -2 || airplane.getAxis().getAxisValue() > 2) {
            System.out.println("Crash: Axis out of balance");
            return true;
        }
        if (airplane.getAltitude() < 0) {
            System.out.println("Crash: Altitude below safe levels");
            return true;
        }
        int currentPosition = airplane.getApproachPosition();
        if (approachTrack.hasAirplanesAt(currentPosition)) {
            System.out.println("Crash: Collision detected at position " + currentPosition + ".");
            return true;
        }
        return false;
    }
    public void switchPlayer() {
        currentPlayer = (currentPlayer == pilot) ? copilot : pilot;
        System.out.println("Next turn: " + currentPlayer.getClass().getSimpleName());
    }
    public Players getCurrentPlayer() {
        return currentPlayer;
    }


    public boolean checkLandingConditions() {
        if (airplane.getLandingGear().getActivatedLandingGearFields() < 3) {
            System.out.println("Landing conditions not met: Landing gear incomplete.");
            return false;
        }
        if (airplane.getBrakes().getActivatedBrakeFields() < 3) {
            System.out.println("Landing conditions not met: Brake fields incomplete.");
            return false;
        }
        if (airplane.getAxis().getAxisValue() != 0) {
            System.out.println("Landing conditions not met: Axis not balanced.");
            return false;
        }
        if (airplane.getAltitude() > 0) {
            System.out.println("Landing conditions not met: Altitude too high.");
            return false;
        }
        return true;
    }


}






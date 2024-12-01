import java.util.ArrayList;

class Game {
    private Airplane airplane;
    private Pilot pilot;
    private CoPilot copilot;
    private int roundNumber;
    private int rerollsAvailable;
    private int startingPlayer;
    private ApproachTrack approachTrack;
    private Players currentPlayer;
    private final int maxRounds = 5;

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





class ApproachTrack {
    private final int length = 7; // Total length of the approach track
    private final ArrayList<Integer> track; // Number of airplanes at each Index

    // Constructor: Initialize the track with predefined airplane counts
    public ApproachTrack() {
        this.track = new ArrayList<>();
        // Populate the track: (0, 0), (1, 0), (2, 1), (3, 2), (4, 1), (5, 3), (6, 2)
        track.add(0); // Index 0
        track.add(0); // Index 1
        track.add(1); // Index 2
        track.add(2); // Index 3
        track.add(1); // Index 4
        track.add(3); // Index 5
        track.add(2); // Index 6
    }
    public int getLength() {
        return length;
    }
    // Getter for the airplane count at a specific position
    public int getAirplanesAt(int position) {
        if (position >= 0 && position < length) {
            return track.get(position);
        }
        System.out.println("Position out of bounds: " + position);
        return 0;
    }
    // Remove an airplane from a specific position
    public boolean removeAirplane(int position) {
        if (position >= 0 && position < length && track.get(position) > 0) {
            track.set(position, track.get(position) - 1); // Decrease airplane count
            return true; // Successfully removed
        }
        System.out.println("No airplanes to remove at position " + position);
        return false; // Nothing to remove
    }
    // Check if a position contains airplanes
    public boolean hasAirplanesAt(int position) {
        if (position >= 0 && position < length) {
            return track.get(position) > 0;
        }
        return false;
    }

    public boolean removeAirplaneWithRadio(int currentPosition, int diceValue) {
        int targetPosition = currentPosition + diceValue - 1; // Adjust for 1-based counting
        if (targetPosition >= 0 && targetPosition < length) {
            return removeAirplane(targetPosition);
        } else {
            System.out.println("Target position out of bounds: " + targetPosition);
            return false;
        }
    }

}


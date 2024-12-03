import java.util.ArrayList;

public class ApproachTrack {
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

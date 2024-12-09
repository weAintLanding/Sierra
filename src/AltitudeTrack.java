public class AltitudeTrack {
    private final int[] altitudes = {6000, 5000, 4000, 3000, 2000, 1000, 0};
    private final int[] rerollTokens = {1,0,0,0,2,0,0};
    private int currentAltitudeIndex;

    public AltitudeTrack() {
        currentAltitudeIndex = 0;
    }

    public int getCurrentAltitude() {
        return altitudes[currentAltitudeIndex];
    }

    public int getRerollTokens() {
        return rerollTokens[currentAltitudeIndex];
    }

    public void descend() {
        if (currentAltitudeIndex < altitudes.length - 1) {
            currentAltitudeIndex++;
            System.out.print("Descending and Current Altitude is: " + getCurrentAltitude());
            if (getRerollTokens() > 0) {
                System.out.println(" | Reroll Tokens: " + getRerollTokens());
            } else {
                System.out.println();
            }
        } else {
            System.out.println("Already at the final altitude (landed).");
        }
    }
    public void displayAltitudeStatus() {
        System.out.print("Current Altitude: " + getCurrentAltitude());
        if (getRerollTokens() > 0) {
            System.out.println(" | Reroll Tokens: " + getRerollTokens());
        } else {
            System.out.println();
        }
    }
}



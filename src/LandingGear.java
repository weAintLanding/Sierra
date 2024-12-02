public class LandingGear {
    private final Airplane airplane;

    private final boolean[] landingGearFields = {false, false, false};
    private int activatedLandingGearFields = 0;

    public LandingGear(Airplane airplane) {
        this.airplane = airplane;
    }

    public int getActivatedLandingGearFields() {
        return activatedLandingGearFields;
    }

    public void setLandingGearFieldsTrue(int index) {
        if (index >= 0 && index < landingGearFields.length && !landingGearFields[index]) {
            landingGearFields[index] = true;
            activatedLandingGearFields++;
            airplane.getEngine().setBlueAeroMarker((airplane.getEngine().getBlueAeroMarker()) + 1);
        }
    }
}

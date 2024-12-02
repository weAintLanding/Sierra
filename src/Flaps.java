public class Flaps {
    private final Airplane airplane;

    private final boolean[] flapFields = {false, false, false, false};
    private int activatedFlapFields = 0;

    public Flaps(Airplane airplane) {
        this.airplane = airplane;
    }

    public int getActivatedFlapFields() {
        return activatedFlapFields;
    }

    public void setFlapFieldsTrue(int index) {
        for (int i = 0; i < index + 1; i++) {
            if (i != index && !flapFields[i]) {
                System.out.println("Previous field(s) not true");
                return;
            } else if (i == index && !flapFields[i]) {
                flapFields[i] = true;
                activatedFlapFields++;
                airplane.getEngine().setOrangeAeroMarker((airplane.getEngine().getOrangeAeroMarker()) + 1);
                return;
            }
        }
    }

}

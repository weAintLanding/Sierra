public class Brakes {
    private final Airplane airplane;

    private final boolean[] brakeFields = {false, false, false};
    private int activatedBrakeFields = 0;

    public Brakes(Airplane airplane) {
        this.airplane = airplane;
    }

    public int getActivatedBrakeFields() {
        return activatedBrakeFields;
    }

    //Brake fields
    public void setBrakeFieldsTrue(int index) {
        for (int i = 0; i <= index; i++) {
            if (i != index && !brakeFields[i]) {
                System.out.println("Previous field(s) not true");
                return;
            } else if (i == index && !brakeFields[i]) {
                brakeFields[i] = true;
                activatedBrakeFields++;
                if (activatedBrakeFields == 1) {
                    airplane.getEngine().setRedBrakeMarker((airplane.getEngine().getRedBrakeMarker()) + 1);
                } else if (activatedBrakeFields <= 3) {
                    airplane.getEngine().setRedBrakeMarker((airplane.getEngine().getRedBrakeMarker()) + 2);
                }
                return;
            }
        }
    }
}

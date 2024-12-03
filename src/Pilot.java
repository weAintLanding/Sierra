public class Pilot extends Players {
    @Override
    public void setRadio(int diceValue) {
        if (getRadioSlots() < 1) {
            super.setRadio(diceValue);
        } else System.out.println(this.getClass().getSimpleName() + " cannot place more dice in the Radio slot");
    }
}

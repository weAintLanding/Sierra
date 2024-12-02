public class CoPilot extends Players {
    @Override
    public void setRadio(int diceValue) {
        if (getRadioSlots() < 2) {
            super.setRadio(diceValue);
        } else System.out.println(this.getClass().getSimpleName() + " cannot place more dice in the Radio slot");
    }
}

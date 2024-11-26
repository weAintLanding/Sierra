public class Main {
    public static void main(String[] args) {
        CoPilot copilot = new CoPilot();
        Pilot pilot = new Pilot();
        pilot.rollDice();
        copilot.rollDice();
        pilot.setRadio(4);
        pilot.setRadio(3);
        copilot.setRadio(4);
        copilot.setRadio(3);
        copilot.setRadio(2);
    }
}

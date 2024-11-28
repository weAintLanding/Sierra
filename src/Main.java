public class Main {
    public static void main(String[] args) {
        CoPilot copilot = new CoPilot();
        Pilot pilot = new Pilot();
        pilot.rollDice();
        copilot.rollDice();
        pilot.setCoffee(2);
        pilot.setCoffee(1);
        pilot.useCoffee(5,1);
        pilot.getDiceRolls();
    }
}

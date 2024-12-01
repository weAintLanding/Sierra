public class Main {
    public static void main(String[] args) {
        CoPilot copilot = new CoPilot();
        Pilot pilot = new Pilot();
        //Dice roll test
        pilot.rollDice();
        copilot.rollDice();
        //Coffee test
        pilot.setCoffee(2);
        // pilot.useCoffee(5,1);
        pilot.getCoffee();
        pilot.getDiceRolls();
        //Throttle test
        pilot.setThrottle(6);
        pilot.getThrottle();
        //Axis test
        pilot.setAxis(3);
        pilot.getAxis();
        //Radio test
        copilot.setRadio(3);
        copilot.getRadio();
        copilot.setRadio(2);
        copilot.getRadio();
        pilot.setRadio(1);
        pilot.setRadio(5);


    }
}

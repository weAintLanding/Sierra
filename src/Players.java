import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Players {
    private List<Dice> diceRolls;
    private Integer axisSlot = null;
    private Integer throttle = null;
    private int radioSlots;
    private Integer radio = null;
    private static final int maxRadioSlots = 2;
    private static int coffee = 0;
    private static final int maxCoffee = 3;
    Random random = new Random();


    public Players() {
        diceRolls = new ArrayList<>();
        rollDice();
    }

    public void rollDice () {
        for(int i = 0; i < 4; i++){
            diceRolls.add(new Dice());
        }
    }
    public String getDiceRolls () {
        List<Integer> diceArray = new ArrayList<>();
        for(int i = 0; i < diceRolls.size(); i++){
            diceArray.add(diceRolls.get(i).getDiceValue());
        }
        return diceArray.toString();
    }

    public boolean isDiceThere (int diceValue){
        for(Dice dice : diceRolls){
            if(dice.getDiceValue() == diceValue) return true;
        }
        return false;
    }

    public void removeDice (int diceValue){
        for (Dice dice : diceRolls){
            if (dice.getDiceValue() == diceValue){
                diceRolls.remove(dice);
                return;
            }
        }
    }

    public void reroll() {
        for (int i = 0; i < diceRolls.size(); i++) {
            Dice dice = diceRolls.get(i);
            int newValue = random.nextInt(6)+1;
            dice.setDiceValue(newValue);
        }
    }

    public void setAxis(int diceValue){
        if (axisSlot != null) {
            System.out.println("Axis slot is already occupied");
        }
        if (isDiceThere(diceValue)) {
            this.throttle = diceValue;
            removeDice(diceValue);
            System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " on their Axis slot");
        }else System.out.println("No such dice exists for the player");
    }
    public Integer getAxis() {
        return axisSlot;
    }

    public void setThrottle(int diceValue){
        if (throttle != null) {
            System.out.println("Throttle slot is already occupied");
        }
        if (isDiceThere(diceValue)) {
                this.throttle = diceValue;
                removeDice(diceValue);
                System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " on their Throttle slot");
        }else System.out.println("No such dice exists for the player");
    }
    public void getThrottle() {
        if (throttle != null) System.out.println("Throttle for " + this.getClass().getSimpleName() + " : " + throttle);
        else System.out.println("Throttle for " + this.getClass().getSimpleName() + " is: empty");
    }

    public void setRadio (int diceValue){
        if (radioSlots < maxRadioSlots){
            if (isDiceThere(diceValue)){
                radioSlots++;
                radio = diceValue;
                removeDice(diceValue);
                System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " on their Radio slot");
            }else System.out.println("No such dice exists for the player");
        }else System.out.println(this.getClass().getSimpleName() + " cannot place more dice in the Radio slot");
    }
    public int getRadioSlots(){
        return radioSlots;
    }
    public void getRadio() {
        if (radio != null) System.out.println("Radio for " + this.getClass().getSimpleName() + " is: " + radio);
        else System.out.println("Radio for " + this.getClass().getSimpleName() + " is: empty");
    }

    public void setCoffee (int diceValue){
        if (coffee < maxCoffee){
            if(isDiceThere(diceValue)){
                coffee++;
                removeDice(diceValue);
                System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " in Concentration");
            }else System.out.println("No such dice exists for the player");
        }else System.out.println("No more dice can be placed");
    }
    public void useCoffee (int diceValue, int coffeeValue){
        int coffeeNeeded = Math.abs(coffeeValue);
        if (coffeeValue == 0) {
            System.out.println("Invalid: Coffee can not be 0");
            return;
        }

        if (coffee < coffeeNeeded){
            System.out.println("Invalid: Not enough coffees available");
            return;
        }

        if(!isDiceThere(diceValue)){
            System.out.println("Invalid: No such dice exists for the player");
            return;
        }

        for(Dice dice : diceRolls){
            if(dice.getDiceValue() == diceValue) {
                int index = diceRolls.indexOf(dice);
                int adjustedValue = diceValue + coffeeValue;
                if (adjustedValue >= 0 && adjustedValue <= 6) {
                    dice.setDiceValue(adjustedValue);
                    coffee -= coffeeNeeded;
                    return;
                } else System.out.println("Invalid number: Out of bounds");
            }
        }
    }
    public void getCoffee() {
        System.out.println("Total no. of Coffees: " + coffee);
    }
}


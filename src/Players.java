import java.util.ArrayList;
import java.util.Random;

public class Players {
    private ArrayList<Integer> diceRolls = new ArrayList<Integer>();
    private Integer axisSlot = null;
    private Integer throttle = null;
    private int radioSlots;
    private Integer radio = null;
    private static final int maxRadioSlots = 2;
    private static int coffee = 0;
    private static final int maxCoffee = 3;
    Random random = new Random();

    public void rollDice () {
//        for (int i = 0; i < 4; i++){
//            diceRolls.add(random.nextInt(6)+1);
//         }
        diceRolls.add(5);
        diceRolls.add(3);
        diceRolls.add(2);
        diceRolls.add(1);
        diceRolls.add(6);
        diceRolls.add(4);
    }
    public void getDiceRolls () {
        System.out.println("Current dice: " + diceRolls);
    }

    public void setAxis(int diceValue){
        if (axisSlot != null){
            System.out.println("Axis slot is already occupied");
        }else {
            if (diceRolls.contains(diceValue)){
                this.axisSlot = diceValue;
                diceRolls.remove(Integer.valueOf(diceValue));
                System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " on their Axis slot");
            }else System.out.println("No such dice exists for the player");
        }
    }
    public Integer getAxis() {
        return axisSlot;
    }

    public void setThrottle(int diceValue){
        if (throttle != null){
            System.out.println("Throttle slot is already occupied");
        }else {
            if (diceRolls.contains(diceValue)){
                this.throttle = diceValue;
                diceRolls.remove(Integer.valueOf(diceValue));
                System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " on their Throttle slot");
            }else System.out.println("No such dice exists for the player");
        }
    }
    public void getThrottle() {
        if (throttle != null) System.out.println("Throttle for " + this.getClass().getSimpleName() + " : " + throttle);
        else System.out.println("Throttle for " + this.getClass().getSimpleName() + " is: empty");
    }

    public void setRadio (int diceValue){
        if (radioSlots < maxRadioSlots){
            if (diceRolls.contains(diceValue)){
                radioSlots++;
                radio = diceValue;
                diceRolls.remove(Integer.valueOf(diceValue));
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
           coffee++;
           diceRolls.remove(Integer.valueOf(diceValue));
           System.out.println(this.getClass().getSimpleName() + " placed " + diceValue + " in Concentration");
        } else {
            System.out.println("No more dice can be placed");
        }
    }
    public void useCoffee (int diceValue, int coffeeValue){
        int coffeeNeeded = Math.abs(coffeeValue);
        if (coffeeValue != 0 && coffee >= coffeeNeeded && diceRolls.contains(diceValue)){
            int index = diceRolls.indexOf(diceValue);
            int adjustedValue = diceValue + coffeeValue;
            if (adjustedValue >= 0 && adjustedValue <= 6) {
                diceRolls.set(index, adjustedValue);
                coffee -= coffeeNeeded;
            } else System.out.println("Invalid number: Out of bounds");
        }else System.out.println("Not valid");
    }
    public void getCoffee() {
        System.out.println("Total no. of Coffees: " + coffee);
    }

    public void reroll(){
        for(int i = 0; i < diceRolls.size(); i++){
            diceRolls.set(i, (random.nextInt(6)+1));
        }
    }
}


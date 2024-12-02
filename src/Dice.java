import java.util.Random;

public class Dice {
    private final int diceValue;
    Random random = new Random();

    public Dice() {
        diceValue = random.nextInt(6)+1;
    }

    public int getDiceValue() {
        return diceValue;
    }
}

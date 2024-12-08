public class Field {
    private String fieldType;
    private String owner;
    private int diceValue;
    private boolean occupied;

    public Field(){
        this.fieldType = fieldType;
        this.owner = owner;
        this.occupied = false;
        this.diceValue = -1;
    }

    public boolean placeDice(int diceValue){
        if(occupied){
            System.out.println("Field is already occupied. Cannot place another die.");
            return false;
        }
        this.diceValue = diceValue;
        this.occupied = true;
        System.out.println("Dice value " + diceValue + " placed on " + fieldType + " field.");
        return true;
    }
    public void resetField(){
        this.diceValue = -1;
        this.occupied = false;
        System.out.println(fieldType + " field has been reset.");
    }

    public boolean isOccupied(){
        return occupied;
    }

    public void displayState() {
        System.out.println("Field Type: " + fieldType);
        System.out.println("Owner: " + owner);
        System.out.println("Occupied: " + occupied);
        if (occupied) {
            System.out.println("Dice Value: " + diceValue);
        } else {
            System.out.println("No dice placed yet.");
        }
    }
    public String getFieldType() {
        return fieldType;
    }

    public String getOwner() {
        return owner;
    }

    public int getDiceValue() {
        return diceValue;
    }
}



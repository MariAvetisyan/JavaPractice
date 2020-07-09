import exeptions.InvalidPositionException;

/**
 * Created by mari.avetisyan on 24/06/2020.
 */
class Position implements IPosition {
    private String position;

    Position(String position) {
        setPosition(position);
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        try {
            isPositionValid(position.toLowerCase());
            this.position = position.toLowerCase();
        } catch (InvalidPositionException e) {
            System.err.println(e);
        }
    }

    public char getPositionX() {
        return this.position.toLowerCase().charAt(0);
    }

    int getPositionXNumericValue() {
        return getPositionX() - 97;
    }

    public int getPositionY() {
        return Character.getNumericValue(this.position.charAt(1));
    }

    static void isPositionValid(String position) throws InvalidPositionException {
        if (!(position.length() == 2 && Character.getNumericValue(position.charAt(1)) >= 1 && Character.getNumericValue(position.charAt(1)) <= 8 &&
                position.toLowerCase().charAt(0) >= 'a' && position.toLowerCase().charAt(0) <= 'h')) {
            throw new InvalidPositionException("Your entered position is invalid");
        }
    }

    public boolean isPositionsEqual(Position position) {
        return (getPositionY() == position.getPositionY()) && (getPositionX() == position.getPositionX());
    }

    public void printPosition() {
        System.out.print(getPositionX() + "" + getPositionY());
    }

    public String toString(){
        return getPositionX() + "" + getPositionY();
    }
}

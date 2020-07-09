import exeptions.InvalidPositionException;

/**
 * Created by mari.avetisyan on 26/06/2020.
 */
public interface IPosition {
    String getPosition();
    void setPosition(String position);
    char getPositionX();
    int getPositionY();
    static void isPositionValid(String position)throws InvalidPositionException{};
    boolean isPositionsEqual(Position position);
    void printPosition();
}

package exeptions;

/**
 * Created by mari.avetisyan on 06/07/2020.
 */
public class InvalidPositionException extends Exception {
    public InvalidPositionException(String s) {
        super(s);
    }

    public InvalidPositionException() {
        super();
    }
}


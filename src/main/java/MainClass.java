/**
 * Created by mari.avetisyan on 21/05/20 20.
 */
public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();

        //In case if you want to play a game from beginning
//        game.initGame();
//        game.startGame();

        //In case if you want to play a game from several position
        try {
            game.arrangeThePosition();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}

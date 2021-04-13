package model;

public class Game {

    private static boolean start = false;

    //Singleton.
    private Game(){}
    private static Game game = null;
    public static Game getInstance(){
        if (game == null){
            game = new Game();
            start = true;
            System.out.println("➽ Game Start!");
        }
        return game;
    }

    public static boolean isStart() {
        return start;
    }

}

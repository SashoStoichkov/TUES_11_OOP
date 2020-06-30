package main.java.com.oop;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player(game, "1");
        Player player2 = new Player(game, "2");
        Player player3 = new Player(game, "3");
        Player player4 = new Player(game, "4");


        try {
            game.addPlayer(player1);
            game.addPlayer(player2);
            game.addPlayer(player3);
            game.addPlayer(player4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        game.init();

//        System.out.println(game.getPlayers());
//        System.out.println(game.getBoard());
//
//        try {
//            game.removePlayer(player3);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(game.getPlayers());
//        System.out.println(game.getBoard());
    }
}

package main.java.com.oop;

public class Player implements Runnable {
    private final Game game;
    private final String name;

    public Player(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{ " + name + " }";
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Integer movesToMake = Die.roll();
            Integer currentPosition = game.getBoard().indexOf(this);
            Integer futurePosition;

            if (currentPosition + movesToMake > 19) {
                futurePosition = movesToMake - (20 - currentPosition);
            } else {
                futurePosition = currentPosition + movesToMake;
            }

            if (game.getBoard().get(futurePosition) != null) {
                System.out.println(game.getBoard().get(futurePosition) + " is out!");
                try {
                    game.removePlayer(game.getBoard().get(futurePosition));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println(this + " goes from position " + currentPosition + " to position " + futurePosition);
            game.getBoard().add(futurePosition, this);
            game.getBoard().remove(futurePosition + 1);

            game.getBoard().add(currentPosition, null);
            game.getBoard().remove(currentPosition + 1);

            System.out.println(this + " in position " + futurePosition);

            try {
                game.finishTurn(this);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

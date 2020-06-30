package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Game {
    private List<Player> players;
    private List<Player> board;
    private ExecutorService playersExecutor;

    public Game() {
        this.players = new ArrayList<>();
        this.board = new ArrayList<>();
        this.playersExecutor = Executors.newFixedThreadPool(4);
    }

    public void init() {
        IntStream.range(0, 4).forEach(i -> {
            board.add(players.get(i));
            IntStream.range(0, 4).forEach(j -> board.add(null));
        });
    }

    public List<Player> getPlayers() {
        return players;
    }

    public synchronized List<Player> getBoard() {
        return board;
    }

    public void addPlayer(Player player) throws Exception {
        if (players.size() + 1 > 4) throw new Exception("Maximum player count reached");
        else {
            players.add(player);
            playersExecutor.submit(player);
        }
    }

    public void removePlayer(Player player) throws Exception {
        if (!players.contains(player)) throw new Exception("Player not in game!");
        else {
            players.add(players.indexOf(player), null);
            players.remove(player);

            board.add(board.indexOf(player), null);
            board.remove(player);
        }
    }

    public void finishTurn(Player player) throws Exception {
        if (!players.contains(player)) throw new Exception("Player not in game!");
        else {
            for (int i = players.indexOf(player); i < 4; i++) {
                if (players.indexOf(player) == 3) i = 0;
                if (players.get(i) != null) {
                    players.get(i).notify();
                    break;
                }
            }
        }
    }
}

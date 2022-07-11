package storage.players;

import model.Player;

import java.util.List;

public interface PlayersStorage {

    void addPlayer(Player player);

    void updatePlayer(Player player);

    Player getPlayer(String name);

    void deletePlayer(Player player);

    List<Player> getAllPlayerSorted();

    int size();
}

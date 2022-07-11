package storage.players;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerStorageClass implements PlayersStorage {
    protected final List<Player> STORAGE = new ArrayList<>();

    @Override
    public void addPlayer(Player player) {
        Integer searchKey = findNotExistingSearchKey(player.getName());
        doAddPlayer(player);
    }

    @Override
    public void updatePlayer(Player player) {
        Integer searchKey = findExistingSearchKey(player.getName());
        doUpdatePlayer(player, searchKey);
    }

    @Override
    public Player getPlayer(String name) {
        Integer searchKey = findExistingSearchKey(name);
        return doGetPlayer(searchKey);
    }

    @Override
    public void deletePlayer(Player player) {
        Integer searchKey = findExistingSearchKey(player.getName());
        doDeletePlayer(searchKey);
    }

    @Override
    public List<Player> getAllPlayerSorted() {
        Comparator<Player> PLAYER_COMPARATOR = Comparator.comparing(Player::getName);
        List<Player> players = getPlayerList();
        players.sort(PLAYER_COMPARATOR);
        return players;
    }

    @Override
    public int size() {
        return STORAGE.size();
    }

    protected Integer findSearchKey(String name) {
        for (Player player : STORAGE) {
            if (player.getName().equals(name)) {
                return STORAGE.indexOf(player);
            }
        }
        return -1;
    }

    protected Integer findNotExistingSearchKey(String name) {
        Integer searchKey = findSearchKey(name);
        if (isPlayerExist(searchKey)) {
            throw new ExistStorageException(name);
        }
        return searchKey;
    }

    protected Integer findExistingSearchKey(String name) {
        Integer searchKey = findSearchKey(name);
        if (!isPlayerExist(searchKey)) {
            throw new NotExistStorageException(name);
        }
        return searchKey;
    }

    protected boolean isPlayerExist(Integer searchKey) {
        return searchKey >= 0;
    }

    protected void doAddPlayer(Player player) {
        STORAGE.add(player);
    }

    protected void doUpdatePlayer(Player player, Integer searchKey) {
        STORAGE.set(searchKey, player);
    }

    protected Player doGetPlayer(Integer index) {
        return STORAGE.get(index);
    }

    protected void doDeletePlayer(Integer index) {
        STORAGE.remove((int) index);
    }

    protected List<Player> getPlayerList() {
        return new ArrayList<>(STORAGE);
    }
}

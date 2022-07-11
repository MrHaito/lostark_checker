import model.Player;
import storage.players.PlayerStorageClass;
import storage.players.PlayersStorage;

public class MainTestPlayerStorage {
    private final static PlayersStorage PLAYERS_STORAGE = new PlayerStorageClass();

    public static void main(String[] args) {
        final Player p1 = new Player("Haito");
        final Player p2 = new Player("Abserber");
        final Player p3 = new Player("Anothersoul");

        PLAYERS_STORAGE.addPlayer(p1);
        PLAYERS_STORAGE.addPlayer(p2);
        PLAYERS_STORAGE.addPlayer(p3);

        System.out.println("Get p1: " + PLAYERS_STORAGE.getPlayer(p1.getName()));
        System.out.println("Size: " + PLAYERS_STORAGE.size());

        printAllPlayers();
        p1.addCharacter("Хайточка");
        p1.addCharacter("Haitosan");
        p1.getAllCharacterSorted();
        p1.deleteCharacter("Хайточка");
        p1.getAllCharacterSorted();
        p1.changeName("Haitosan", "Хайточка");
        p1.setClassName("Хайточка", "Призывательница");
        p1.setLevel("Хайточка", 51);
        p1.setLegacyLevel("Хайточка", 111);
        p1.getAllCharacterSorted();
    }

    static void printAllPlayers() {
        System.out.println("\nGet All");
        for (Player p : PLAYERS_STORAGE.getAllPlayerSorted()) {
            System.out.println(p.getName());
        }
    }
}

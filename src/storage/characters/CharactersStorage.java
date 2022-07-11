package storage.characters;

public interface CharactersStorage {
    void addCharacter(String name);

    void deleteCharacter(String name);

    void getAllCharacterSorted();
}

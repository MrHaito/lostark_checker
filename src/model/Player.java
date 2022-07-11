package model;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import storage.characters.CharactersStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player implements CharactersStorage {

    private String name;
    private final List<Character> characters = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*Блок управления списком персонажей*/

    @Override
    public void addCharacter(String name) {
        Character character = new Character(name);
        Integer searchKey = findNotExistingSearchKey(character.getName());
        doAddCharacter(character);
    }

    @Override
    public void deleteCharacter(String name) {
        Integer searchKey = findExistingSearchKey(name);
        doDeleteCharacter(searchKey);
    }

    public void getAllCharacterSorted() {
        Comparator<Character> PLAYER_COMPARATOR = Comparator.comparing(Character::getName);
        List<Character> characters = getCharacterList();
        characters.sort(PLAYER_COMPARATOR);
        System.out.println("Все персонажи игрока " + this.name + ": ");
        for (Character character : characters) {
            System.out.println(character);
        }
    }

    public void changeName(String name, String newName) {
        Integer searchKey = findExistingSearchKey(name);
        doChangeName(searchKey, newName);
    }

    public void setClassName(String name, String className) {
        Integer searchKey = findExistingSearchKey(name);
        doSetClassName(searchKey, className);
    }

    public void setLevel(String name, Integer level) {
        Integer searchKey = findExistingSearchKey(name);
        doSetLevel(searchKey, level);
    }

    public void setLegacyLevel(String name, Integer legacyLevel) {
        Integer searchKey = findExistingSearchKey(name);
        doSetLegacyLevel(searchKey, legacyLevel);
    }

    protected Integer findSearchKey(String name) {
        for (Character character : characters) {
            if (character.getName().equals(name)) {
                return characters.indexOf(character);
            }
        }
        return -1;
    }

    protected Integer findNotExistingSearchKey(String name) {
        Integer searchKey = findSearchKey(name);
        if (isCharacterExist(searchKey)) {
            throw new ExistStorageException(name);
        }
        return searchKey;
    }

    protected Integer findExistingSearchKey(String name) {
        Integer searchKey = findSearchKey(name);
        if (!isCharacterExist(searchKey)) {
            throw new NotExistStorageException(name);
        }
        return searchKey;
    }

    protected boolean isCharacterExist(Integer searchKey) {
        return searchKey >= 0;
    }

    protected void doAddCharacter(Character character) {
        characters.add(character);
    }

    protected void doDeleteCharacter(Integer index) {
        characters.remove((int) index);
    }

    protected List<Character> getCharacterList() {
        return new ArrayList<>(characters);
    }

    protected void doChangeName(Integer index, String name) {
        characters.get(index).setName(name);
    }

    protected void doSetClassName(Integer index, String className) {
        characters.get(index).setClassName(className);
    }

    protected void doSetLevel(Integer index, Integer level) {
        characters.get(index).setLevel(level);
    }

    protected void doSetLegacyLevel(Integer index, Integer level) {
        characters.get(index).setLegacyLevel(level);
    }
}

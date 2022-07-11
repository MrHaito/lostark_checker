package model;

public class Character {

    private String name;
    private String className;
    private int level;
    private int legacyLevel;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLegacyLevel() {
        return legacyLevel;
    }

    public void setLegacyLevel(int legacyLevel) {
        this.legacyLevel = legacyLevel;
    }

    @Override
    public String toString() {
        if (className == null && level == 0 && legacyLevel == 0) {
            return name;
        }
        if (className == null && level == 0) {
            return name +
                    ", " + legacyLevel + " уровень наследия";
        }
        if (className == null && legacyLevel == 0) {
            return name +
                    ", " + level + " уровень";
        }
        if (level == 0 && legacyLevel == 0) {
            return name +
                    ", " + className;
        }
        return name +
                ", " + className +
                ", " + level + " уровень" +
                ", " + legacyLevel + " уровень наследия";
    }
}

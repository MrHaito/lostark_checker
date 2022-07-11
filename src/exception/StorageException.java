package exception;

public class StorageException extends RuntimeException {
    private final String name;


    public StorageException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

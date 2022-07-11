package exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String name) {
        super("Игрок с именем " + name + " не найден", name);
    }
}

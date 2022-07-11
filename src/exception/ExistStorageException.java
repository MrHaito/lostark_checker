package exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String name) {
        super("Игрок с именем " + name + " уже есть", name);
    }
}

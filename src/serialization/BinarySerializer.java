package serialization;
import java.io.*;

public class BinarySerializer {
    public static void serialize(String path, Object serializableObject) throws IOException {
        if (serializableObject == null)
            throw new NullPointerException("Сериализуемый объект не может быть равен null!");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(serializableObject);
    }

    public static Object deserialize(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return objectInputStream.readObject();
    }
}
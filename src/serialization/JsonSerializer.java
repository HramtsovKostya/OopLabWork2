package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class JsonSerializer {
    public static void serialize(String path, Object serializableObject) throws IOException {
        if (serializableObject == null)
            throw new NullPointerException("Сериализуемый объект не может быть равен null!");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(fileOutputStream, serializableObject);
    }

    public static Object deserialize(String path, Object deserializedObject) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(fileInputStream, deserializedObject.getClass());
    }
}
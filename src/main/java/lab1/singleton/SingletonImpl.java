package lab1.singleton;

import java.io.*;
import java.util.Properties;

public class SingletonImpl {

    private static Properties properties;
    private static SingletonImpl singleton;

    private SingletonImpl() {
        properties = new Properties();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (stream != null) {
                properties.load(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Properties getProperties() {
        if (singleton == null) {
            singleton = new SingletonImpl();
        }
        return properties;
    }


}

package controleur.utils;

import java.util.Properties;
import java.io.InputStream;

public class ConfigUtility {
    private Properties props;

    private static final ConfigUtility instance = new ConfigUtility();

    public ConfigUtility() {
        this.readConfig();
    }

    public static ConfigUtility getInstance() {
        return instance;
    }

    public String getInfo(String kw) {
        return this.props.getProperty(kw);
    }

    public Properties readConfig() {
        props = new Properties();
        String resourceName = "config.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            InputStream resourceStream = loader.getResourceAsStream(resourceName);
            props.load(resourceStream);
            return props;
        } catch (Exception e) {
            System.out.printf("Exception: " + e);
        }
        return null;
    }

}

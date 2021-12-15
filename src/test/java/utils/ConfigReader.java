package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    /**
     * This method will read a property file from specified location
     * @param filepath
     * @return Properties
     */
    public static Properties readProperties(String filepath) {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return prop;
    }

    /**
     * this method retrieves single value based on the specified key
     * @param key
     * @return property of specified key
     */

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }

}


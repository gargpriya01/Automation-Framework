package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop=new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                prop.load(is);
            } else {
                throw new RuntimeException("config.properties not found in classpath");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
        public static String get(String key){
            return prop.getProperty(key);
        }

        public static String get(String key,String defaultVal){
            return prop.getProperty(key,defaultVal);
        }

        public static int getInt(String key,int defaultVal){
            String val=prop.getProperty(key);
            return (val !=null && !val.isEmpty())?Integer.parseInt(val):defaultVal;
        }
    }


package com.testproject.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String URL;
    public static final String DB_USERNAME;
    public static final String DB_PASSWORD;
    public static final String DB_URL;

    static {
        Properties properties = null;
        String env = System.getProperty("environment") != null ? System.getProperty("environment") : ConfigurationReader.getProperty("environment");

        try {
            String path = System.getProperty("user.dir") + "src/test/resources/Environments/" + env + ".properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        URL = properties.getProperty("url");
        DB_URL = properties.getProperty("db_url");
        DB_USERNAME = properties.getProperty("db_username");
        DB_PASSWORD = properties.getProperty("db_password");
    }
}

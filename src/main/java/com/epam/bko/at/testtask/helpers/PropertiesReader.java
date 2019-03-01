package com.epam.bko.at.testtask.helpers;

import groovy.beans.PropertyReader;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesReader {

    private static final String PROPERTIES_FILE = "/application.properties";
    private static final Properties PROPERTIES = getPropertiesInstance();

    @SneakyThrows(IOException.class)
    private static Properties getPropertiesInstance() {
        Properties instance = new Properties();
        try (
                InputStream resourceStream = PropertyReader.class.getResourceAsStream(PROPERTIES_FILE);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
        ) {
            instance.load(inputStream);
        }
        return instance;
    }

    public static String getProperty(String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        return systemProperty == null ? PROPERTIES.getProperty(propertyName) : systemProperty;
    }
    public static Properties getProperties() {
        return PROPERTIES;
    }
}

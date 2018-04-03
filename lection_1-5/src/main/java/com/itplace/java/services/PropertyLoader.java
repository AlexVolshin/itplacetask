package com.itplace.java.services;

import com.itplace.java.data.PropertyData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

/**
 * Класс загружает данные из *.properties файла
 */
public class PropertyLoader {

    private Properties properties;

    public PropertyLoader(String propertiesFile) {
        try {
            this.properties = new Properties();
            this.properties.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(propertiesFile),
                    Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            System.err.println("Не найден *.properties файл!\n" + e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Возвращает загруженный набор данных
     * @return набор данных
     */
    public PropertyData getDataFromProperties() {
        return new PropertyData(
                this.properties.getProperty("FIO", ""),
                this.properties.getProperty("DOB", ""),
                this.properties.getProperty("phone", ""),
                this.properties.getProperty("email", ""),
                this.properties.getProperty("skype", ""),
                this.properties.getProperty("avatar", ""),
                Arrays.asList(this.properties.getProperty("target", "").split("\",\"")),
                Arrays.asList(this.properties.getProperty("experience", "").split("\",\"")),
                Arrays.asList(this.properties.getProperty("education", "").split("\",\"")),
                Arrays.asList(this.properties.getProperty("additional", "").split("\",\"")),
                Arrays.asList(this.properties.getProperty("skills", "").split("\",\"")),
                Arrays.asList(this.properties.getProperty("example", "").split("\",\""))
        );
    }

    /**
     * Возвращает загруженный набор данных
     * @return набор данных
     */
    public PropertyData getDataFromHashMap() {
        HashMap<String, String> properties = new HashMap<>();
        for (final String name : this.properties.stringPropertyNames())
            properties.put(name, this.properties.getProperty(name));
        return new PropertyData(
                properties.getOrDefault("FIO", ""),
                properties.getOrDefault("DOB", ""),
                properties.getOrDefault("phone", ""),
                properties.getOrDefault("email", ""),
                properties.getOrDefault("skype", ""),
                properties.getOrDefault("avatar", ""),
                Arrays.asList(properties.getOrDefault("target", "").split("\",\"")),
                Arrays.asList(properties.getOrDefault("experience", "").split("\",\"")),
                Arrays.asList(properties.getOrDefault("education", "").split("\",\"")),
                Arrays.asList(properties.getOrDefault("additional", "").split("\",\"")),
                Arrays.asList(properties.getOrDefault("skills", "").split("\",\"")),
                Arrays.asList(properties.getOrDefault("example", "").split("\",\""))
        );
    }

}

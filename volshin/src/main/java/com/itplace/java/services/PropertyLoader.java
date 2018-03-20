package com.itplace.java.services;

import com.itplace.java.data.PropertyData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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
    public PropertyData getData() {
        return new PropertyData(
                this.properties.getProperty("FIO", ""),
                this.properties.getProperty("DOB", ""),
                this.properties.getProperty("phone", ""),
                this.properties.getProperty("email", ""),
                this.properties.getProperty("skype", ""),
                this.properties.getProperty("avatar", ""),
                this.properties.getProperty("target", ""),
                this.properties.getProperty("experience", ""),
                this.properties.getProperty("education", ""),
                this.properties.getProperty("additional", ""),
                this.properties.getProperty("skills", ""),
                this.properties.getProperty("example", "")
        );
    }

}
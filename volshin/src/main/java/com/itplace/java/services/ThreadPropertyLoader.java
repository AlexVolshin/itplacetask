package com.itplace.java.services;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Properties;

public class ThreadPropertyLoader implements Runnable {

    private HashMap<String, String> properties;
    private String filename;

    public ThreadPropertyLoader(HashMap<String, String> properties, String filename) {
        this.properties = properties;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            Properties prop = new Properties();
            prop.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename),
                    Charset.forName("UTF-8")));
            synchronized (this) {
                for (final String name : prop.stringPropertyNames())
                    this.properties.put(name, prop.getProperty(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

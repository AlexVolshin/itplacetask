package com.itplace.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        // простая проверка входных данных (число аргуметов)
        if (args.length < 2) {
            System.err.println("Usage: task <property_file> <result_file>");
            return;
        }
        Properties properties = new Properties();
        try {
            // загружаем информацию из .properties файла
            properties.load(new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8")));
            // генерируем html страничку
            HtmlCreator creator = new HtmlCreator(properties);
            creator.create(args[1]);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

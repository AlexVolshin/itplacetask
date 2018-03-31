package com.itplace.java;

import com.itplace.java.data.PropertyData;
import com.itplace.java.services.ThreadPropertyLoader;
import com.itplace.java.services.api.Creator;
import com.itplace.java.services.HtmlCreator;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        try {
            HashMap<String, String> properties = new HashMap<>();
            Thread tr0 = new Thread(new ThreadPropertyLoader(properties, "input0.properties"));
            Thread tr1 = new Thread(new ThreadPropertyLoader(properties, "input1.properties"));
            tr0.start();
            tr1.start();
            tr0.join();
            tr1.join();
            Creator creator = new HtmlCreator(PropertyData.fromHashMap(properties));
            creator.write("result.html");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

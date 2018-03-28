package com.itplace.java;

import com.itplace.java.services.PropertyLoader;
import com.itplace.java.services.api.Creator;
import com.itplace.java.services.HtmlCreator;

public class App {
    public static void main(String[] args) {
        PropertyLoader loader = new PropertyLoader("input.properties");
        Creator creator = new HtmlCreator(loader.getDataFromHashMap());
        creator.write("result.html");
    }
}

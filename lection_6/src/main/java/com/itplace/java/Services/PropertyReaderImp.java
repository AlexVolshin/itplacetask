package com.itplace.java.Services;

import com.itplace.java.Api.PropertyReader;
import org.springframework.stereotype.Component;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

@Component
public class PropertyReaderImp implements PropertyReader {

    @Override
    public Properties read(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName),
                    Charset.forName("UTF-8")));
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

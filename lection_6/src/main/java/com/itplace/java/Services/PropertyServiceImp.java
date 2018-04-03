package com.itplace.java.Services;

import com.itplace.java.Api.PropertyReader;
import com.itplace.java.Api.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class PropertyServiceImp implements PropertyService {

    private PropertyReader reader;

    @Autowired
    public PropertyServiceImp(@Qualifier("propertyReaderImp") PropertyReader reader) {
        this.reader = reader;
    }

    @Override
    public Properties getProperties(String propertyFile) {
        return this.reader.read(propertyFile);
    }
}

package com.itplace.volshin.homework8.service;

import com.itplace.volshin.homework8.data.SummaryData;
import com.itplace.volshin.homework8.service.api.SummaryService;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

@Service
public class SummaryServiceImp implements SummaryService {

    private SummaryData summaryData = null;

    public SummaryServiceImp() {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(getClass().getClassLoader()
                    .getResourceAsStream("input.properties"), Charset.forName("UTF-8")));
            this.summaryData = new SummaryData(
                    properties.getProperty("FIO", ""),
                    properties.getProperty("DOB", ""),
                    properties.getProperty("phone", ""),
                    properties.getProperty("email", ""),
                    properties.getProperty("skype", ""),
                    properties.getProperty("avatar", ""),
                    properties.getProperty("target", ""),
                    properties.getProperty("experience", ""),
                    properties.getProperty("education", ""),
                    properties.getProperty("additional", ""),
                    properties.getProperty("skills", ""),
                    properties.getProperty("example", "")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SummaryData getData() {
        return this.summaryData;
    }
}

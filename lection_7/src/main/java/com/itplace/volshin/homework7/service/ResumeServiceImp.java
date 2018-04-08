package com.itplace.volshin.homework7.service;

import com.itplace.volshin.homework7.data.ResumeData;
import com.itplace.volshin.homework7.service.api.ResumeService;
import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class ResumeServiceImp implements ResumeService {

    private ResumeData resumeData;

    public ResumeServiceImp() {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(getClass().getClassLoader().
                    getResourceAsStream("input.properties"), Charset.forName("UTF-8")));
            this.resumeData = new ResumeData(
                    properties.getProperty("FIO", ""),
                    properties.getProperty("DOB", ""),
                    properties.getProperty("phone", ""),
                    properties.getProperty("email", ""),
                    properties.getProperty("skype", ""),
                    properties.getProperty("avatar", ""),
                    stringToList(properties.getProperty("target", "")),
                    stringToList(properties.getProperty("experience", "")),
                    stringToList(properties.getProperty("education", "")),
                    stringToList(properties.getProperty("additional", "")),
                    stringToList(properties.getProperty("skills", "")),
                    stringToList(properties.getProperty("example", ""))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> stringToList(final String str) {
        if (str.isEmpty())
            return null;
        List<String> list = Arrays.asList(str.split("\",\""));
        if (list.size() == 1)
            return list;
        final String firstElement = list.get(0);
        list.set(0, firstElement.substring(1, firstElement.length()));
        final String endElement = list.get(list.size() - 1);
        list.set(list.size() - 1, endElement.substring(0, endElement.length() - 1));
        return list;
    }

    @Override
    public ResumeData getResumeData() {
        return this.resumeData;
    }

}

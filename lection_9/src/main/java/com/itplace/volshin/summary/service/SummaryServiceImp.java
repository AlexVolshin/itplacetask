package com.itplace.volshin.summary.service;

import com.itplace.volshin.summary.entity.Summary;
import com.itplace.volshin.summary.repository.SummaryRepository;
import com.itplace.volshin.summary.service.api.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

@Component
public class SummaryServiceImp implements SummaryService {

    private SummaryRepository summaryRepository;

    @Autowired
    public SummaryServiceImp(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    @Override
    public void open(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName),
                    Charset.forName("UTF-8")));
            Summary summary = new Summary();
            summary.setFullname(properties.getProperty("FIO", ""));
            summary.setBirthday(properties.getProperty("DOB", ""));
            summary.setPhone(properties.getProperty("phone", ""));
            summary.setEmail(properties.getProperty("email", ""));
            summary.setSkype(properties.getProperty("skype", ""));
            summary.setImage(properties.getProperty("avatar", ""));
            summary.setTarget(properties.getProperty("target", ""));
            summary.setExperience(properties.getProperty("experience", ""));
            summary.setEducation(properties.getProperty("education", ""));
            summary.setAdditional(properties.getProperty("additional", ""));
            summary.setSkills(properties.getProperty("skills", ""));
            summary.setExample(properties.getProperty("example", ""));
            this.summaryRepository.save(summary);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

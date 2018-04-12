package com.itplace.volshin.homework8.data;

import lombok.Getter;

@Getter
public class SummaryData {

    private final String fullname;
    private final String birthday;
    private final String phonenumber;
    private final String email;
    private final String skype;
    private final String image;
    private final String target;
    private final String experience;
    private final String education;
    private final String additional;
    private final String skills;
    private final String example;

    public SummaryData(String fullname, String birthday, String phonenumber, String email, String skype,
                      String image, String target, String experience, String education, String additional,
                      String skills, String example) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.email = email;
        this.skype = skype;
        this.image = image;
        this.target = target;
        this.experience = experience;
        this.education = education;
        this.additional = additional;
        this.skills = skills;
        this.example = example;
    }

}

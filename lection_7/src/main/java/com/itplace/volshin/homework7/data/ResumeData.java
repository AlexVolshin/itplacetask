package com.itplace.volshin.homework7.data;

import java.util.List;

public class ResumeData {

    private final String fullname;
    private final String birthday;
    private final String phonenumber;
    private final String email;
    private final String skype;
    private final String image;
    private final List<String> target;
    private final List<String> experience;
    private final List<String> education;
    private final List<String> additional;
    private final List<String> skills;
    private final List<String> example;

    public ResumeData(String fullname, String birthday, String phonenumber, String email, String skype, String image,
                      List<String> target, List<String> experience, List<String> education, List<String> additional,
                      List<String> skills, List<String> example) {
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

    public String getFullname() {
        return fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public String getImage() {
        return image;
    }

    public List<String> getTarget() {
        return target;
    }

    public List<String> getExperience() {
        return experience;
    }

    public List<String> getEducation() {
        return education;
    }

    public List<String> getAdditional() {
        return additional;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<String> getExample() {
        return example;
    }

}

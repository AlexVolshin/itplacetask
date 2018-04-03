package com.itplace.java.data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс - модель с данными из *.properties файла
 */
public class PropertyData {
    private String fullname;
    private String birthday;
    private String phonenumber;
    private String email;
    private String skype;
    private String image;
    private List<String> target;
    private List<String> experience;
    private List<String> education;
    private List<String> additional;
    private List<String> skills;
    private List<String> example;

    public PropertyData(String fullname,
                        String birthday,
                        String phonenumber,
                        String email,
                        String skype,
                        String image,
                        List<String> target,
                        List<String> experience,
                        List<String> education,
                        List<String> additional,
                        List<String> skills,
                        List<String> example) {
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

    /**
     * Возвращает ФИО
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Возвращает дату рождения
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Возвращает номер телефона
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Возвращает адрес электронной почты
     */
    public String getEmail() {
        return email;
    }

    /**
     * Возвращает Скайп ИД
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Возвращает фотографию
     */
    public String getImage() {
        return image;
    }

    /**
     * Возвращает текст с жизненными целями
     */
    public List<String> getTarget() {
        return target;
    }

    /**
     * Возвращает текст с опытом работы
     */
    public List<String> getExperience() {
        return experience;
    }

    /**
     * Возвращает текст с образованием
     */
    public List<String> getEducation() {
        return education;
    }

    /**
     * Возвращает текст с дополнительным образованием
     */
    public List<String> getAdditional() {
        return additional;
    }

    /**
     *  Возвращает список умений
     */
    public List<String> getSkills() {
        return skills;
    }

    /**
     *  Возвращает пример кода
     */
    public List<String> getExample() {
        return example;
    }

    public static PropertyData fromHashMap(ConcurrentHashMap<String, String> propertiesMap) {
        return new PropertyData(
                propertiesMap.getOrDefault("FIO", ""),
                propertiesMap.getOrDefault("DOB", ""),
                propertiesMap.getOrDefault("phone", ""),
                propertiesMap.getOrDefault("email", ""),
                propertiesMap.getOrDefault("skype", ""),
                propertiesMap.getOrDefault("avatar", ""),
                Arrays.asList(propertiesMap.getOrDefault("target", "").split("\",\"")),
                Arrays.asList(propertiesMap.getOrDefault("experience", "").split("\",\"")),
                Arrays.asList(propertiesMap.getOrDefault("education", "").split("\",\"")),
                Arrays.asList(propertiesMap.getOrDefault("additional", "").split("\",\"")),
                Arrays.asList(propertiesMap.getOrDefault("skills", "").split("\",\"")),
                Arrays.asList(propertiesMap.getOrDefault("example", "").split("\",\""))
        );
    }

}

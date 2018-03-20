package com.itplace.java.data;

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
    private String target;
    private String experience;
    private String education;
    private String additional;
    private String skills;
    private String example;

    public PropertyData(String fullname,
                        String birthday,
                        String phonenumber,
                        String email,
                        String skype,
                        String image,
                        String target,
                        String experience,
                        String education,
                        String additional,
                        String skills,
                        String example) {
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
    public String getTarget() {
        return target;
    }

    /**
     * Возвращает текст с опытом работы
     */
    public String getExperience() {
        return experience;
    }

    /**
     * Возвращает текст с образованием
     */
    public String getEducation() {
        return education;
    }

    /**
     * Возвращает текст с дополнительным образованием
     */
    public String getAdditional() {
        return additional;
    }

    /**
     *  Возвращает список умений
     */
    public String getSkills() {
        return skills;
    }

    /**
     *  Возвращает пример кода
     */
    public String getExample() {
        return example;
    }

}

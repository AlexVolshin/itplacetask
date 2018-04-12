package com.itplace.volshin.homework8.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Summary {

    @Id
    @GeneratedValue
    private Long id;

    private String fullname;
    private String birthday;
    private String email;
    private String phone;
    private String skype;
    private String image;
    private String target;
    private String experience;
    private String education;
    private String additional;
    private String skills;
    private String example;

}

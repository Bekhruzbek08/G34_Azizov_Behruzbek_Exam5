package org.example.domain;

import lombok.Builder;
import lombok.Data;

@Builder
public class User {
@Builder.Default
    private static Integer sequence = 0;

    {
        ++sequence;
    }

    private String name;
    private Integer age;
    private String userPhoneNumber;
    private String email;
    @Builder.Default
    private Integer id = sequence;
    private String password;

    public static Integer getSequence() {
        return sequence;
    }

    public static void setSequence(Integer sequence) {
        User.sequence = sequence;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, Integer age, String userPhoneNumber, String email, Integer id, String password) {
        this.name = name;
        this.age = age;
        this.userPhoneNumber = userPhoneNumber;
        this.email = email;
        this.password = password;
    }
}



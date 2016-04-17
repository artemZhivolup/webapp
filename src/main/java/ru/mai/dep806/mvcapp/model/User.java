package ru.mai.dep806.mvcapp.model;

import java.util.Date;

public class User {
    private Long id;
    private String login;
    private String name;
    private String email;
    private Date birthDate;
    private boolean active;

    public User(String login, String name, String email, Date birthDate, boolean active) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.active = active;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                '}';
    }
}

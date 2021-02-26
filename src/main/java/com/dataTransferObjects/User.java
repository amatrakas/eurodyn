package com.dataTransferObjects;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    @NotNull
    @Size(min=4,max=15)
    private String name;
    @NotNull
    @Size(min=4,max=15)
    private String surname;
    @NotNull
    @Size(min=8,max = 15)
    private String phone;
    @Email
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Email doesn't match with pattern")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

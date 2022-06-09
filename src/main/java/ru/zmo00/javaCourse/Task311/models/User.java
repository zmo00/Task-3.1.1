package ru.zmo00.javaCourse.Task311.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 1, max = 100, message = "incorrect firstname")
    private String firstname;

    @Column
    @Size(min = 1, max = 100, message = "incorrect lastname")
    private String lastname;

    @Column
    @NotEmpty(message = "incorrect email")
    @Email(message = "incorrect email")
    private String email;

    public User() {

    }

    public User(String firstName, String lastName, String email) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User#" + id + ": " + lastname + "_" + firstname.charAt(0) + ". -- " + email;
    }

}

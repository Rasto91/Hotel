package com.engeto.hotel;

import java.time.LocalDate;

public class Guest {
    private String firstname;
    private String lastname;
    private LocalDate birthDate;

    // Konstruktor
    public Guest(String firstname, String lastname, LocalDate birthDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    // Gettery
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Setter pre zmenu dátumu narodenia
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}


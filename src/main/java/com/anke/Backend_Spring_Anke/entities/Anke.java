package com.anke.Backend_Spring_Anke.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.io.Serializable;

@Schema(name = "Anke", description = "Anke model")
@Entity // This class is an entity
@Table(name = "anke") // Table name in the database
public class Anke implements Serializable {

    @Schema(name = "id", description = "Anke id", example = "1")
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private Long id;

    @Schema(name = "name")
    @Column(name = "name") // Column name in the database
    private String name;

    @Schema(name = "surname")
    @Column(name = "surname")
    private String surname;

    @Schema(name = "age")
    @Column(name = "age")
    private int age;

    public Anke() {
    }

    public Anke(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Anke{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

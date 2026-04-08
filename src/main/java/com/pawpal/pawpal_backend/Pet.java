package com.pawpal.pawpal_backend;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //defining the fields in the database
    private String name;
    private Integer age;
    private String breed;
    private String gender;
    private String type;
    private Double weight;

    //defining relationship with user database
    @ManyToOne
    @JoinColumn(name="user_id") 
    @JsonIgnore               
    private User user;

   
    //getters and setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

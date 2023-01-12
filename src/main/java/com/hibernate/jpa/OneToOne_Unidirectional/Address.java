package com.hibernate.jpa.OneToOne_Unidirectional;


import jakarta.persistence.*;

@Entity
@Table(name = "adress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;


    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

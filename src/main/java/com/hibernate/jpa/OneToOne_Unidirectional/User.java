package com.hibernate.jpa.OneToOne_Unidirectional;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address adress;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAdress() {
        return adress;
    }

    public User(String name, Address adress) {
        this.name = name;
        this.adress = adress;
    }
}

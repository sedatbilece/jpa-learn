package com.hibernate.jpa.model.OneToOne;


import jakarta.persistence.*;

@Entity
@Table(name="owner")
public class Owner {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne()
    @JoinColumn(name="car_id" ,referencedColumnName = "id")
    private Car car;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}

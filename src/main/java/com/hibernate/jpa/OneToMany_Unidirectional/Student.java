package com.hibernate.jpa.OneToMany_Unidirectional;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String indexNumber;


    public Student() {
    }

    public Student(String indexNumber) {
        this.indexNumber = indexNumber;
    }


    public String getIndexNumber() {
        return indexNumber;
    }
}

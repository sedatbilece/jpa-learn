package com.hibernate.jpa.OneToMany_Unidirectional;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="university")
public class University {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="university_id" )
    private List<Student> students = new ArrayList<>();

    public University(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public University() {
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}

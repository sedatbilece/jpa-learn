package com.hibernate.jpa.ManyToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stream")
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "followedStreams")
    private List<Viewer> followers=new ArrayList<>();

    public Stream(String name) {
        this.name = name;
    }
    public void addViewer(Viewer viewer){
        followers.add(viewer);
    }
}

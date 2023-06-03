package com.example.ormsandbox.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="child_a")
public class ChildA {
    @Id
    @Column(name="id")
    private int id;

    @OneToOne(mappedBy = "childA")
    private Root root;

    public ChildA(){}
    public ChildA(int id) {
        this.id = id;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
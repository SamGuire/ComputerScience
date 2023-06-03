package com.example.ormsandbox.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="child_b")
public class ChildB {
    @Id
    @Column(name="id")
    private int id;

    @OneToOne(mappedBy = "childB")
    private Root root;

    public ChildB(){}
    public ChildB(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}

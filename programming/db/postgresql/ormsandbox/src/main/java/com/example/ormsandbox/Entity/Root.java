package com.example.ormsandbox.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="root")
public class Root {
    @Id
    @Column(name="id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="child_a_id",referencedColumnName ="id")
    private ChildA childA;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="child_b_id")
    private ChildB childB;


    public Root(){}

    public Root(int id,ChildA childA, ChildB childb) {
        this.id = id;
        this.childA = childA;
        this.childB = childb;
    }

    public ChildA getChildA() {
        return childA;
    }

    public ChildB getChildB() {
        return childB;
    }

    public int getId() {
        return id;
    }

    public void setChildA(ChildA childA) {
        this.childA = childA;
    }

    public void setChildB(ChildB childB) {
        this.childB = childB;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.example.ormsandbox.DTO;

public class RootDTO {

    private int id;

    private ChildADTO childA;

    private ChildBDTO childB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChildADTO getChildA() {
        return childA;
    }

    public ChildBDTO getChildB() {
        return childB;
    }

    public void setChildA(ChildADTO childA) {
        this.childA = childA;
    }

    public void setChildB(ChildBDTO childB) {
        this.childB = childB;
    }
}

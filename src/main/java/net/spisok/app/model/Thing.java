package net.spisok.app.model;

public class Thing {
    private int id;
    private String name;

    private String  bought;

    public Thing(int id, String name, String bought) {
        this.id = id;
        this.name = name;
        this.bought = bought;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBought() {
        return bought;
    }

    public void setBought(String bought) {
        this.bought = bought;
    }
}

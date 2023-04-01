package com.itptit.hieudh;

public class Model {
    int id;

    String name;

    String description;

    String finishDate;

    String gender;

    public Model() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Model(int id, String name, String description, String finishDate, String gender) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.finishDate = finishDate;
        this.gender = gender;
    }
}

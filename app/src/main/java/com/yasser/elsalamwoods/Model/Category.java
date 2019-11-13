package com.yasser.elsalamwoods.Model;

public class Category {

    String id,catName;
    int catImg;

    public Category(String catName, int catImg) {
        this.catName = catName;
        this.catImg = catImg;
    }

    public Category(String id, String catName, int catImg) {
        this.id = id;
        this.catName = catName;
        this.catImg = catImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatImg() {
        return catImg;
    }

    public void setCatImg(int catImg) {
        this.catImg = catImg;
    }
}

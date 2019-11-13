package com.yasser.elsalamwoods;

public class Category {
    String catName;
    int catImg;

    public Category(String catName, int catImg) {
        this.catName = catName;
        this.catImg = catImg;
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

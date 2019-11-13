package com.yasser.elsalamwoods.Model;

import com.parse.ParseFile;

public class Product {
    String id,catId,prImageURL,prName,prType,prDescri,prPriceMwoza3,prPrice3amel;

    public Product(String id, String catId, String prImageURL, String prName, String prType, String prDescri, String prPriceMwoza3, String prPrice3amel) {
        this.id = id;
        this.catId = catId;
        this.prImageURL = prImageURL;
        this.prName = prName;
        this.prType = prType;
        this.prDescri = prDescri;
        this.prPriceMwoza3 = prPriceMwoza3;
        this.prPrice3amel = prPrice3amel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getPrImageURL() {
        return prImageURL;
    }

    public void setPrImageURL(String prImageURL) {
        this.prImageURL = prImageURL;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public String getPrType() {
        return prType;
    }

    public void setPrType(String prType) {
        this.prType = prType;
    }

    public String getPrDescri() {
        return prDescri;
    }

    public void setPrDescri(String prDescri) {
        this.prDescri = prDescri;
    }

    public String getPrPriceMwoza3() {
        return prPriceMwoza3;
    }

    public void setPrPriceMwoza3(String prPriceMwoza3) {
        this.prPriceMwoza3 = prPriceMwoza3;
    }

    public String getPrPrice3amel() {
        return prPrice3amel;
    }

    public void setPrPrice3amel(String prPrice3amel) {
        this.prPrice3amel = prPrice3amel;
    }
}

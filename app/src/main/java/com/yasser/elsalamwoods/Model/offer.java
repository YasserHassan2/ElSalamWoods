package com.yasser.elsalamwoods.Model;

public class offer {
    String offer_imageURL,offer_title,offer_desc,offer_enddate;

    public offer(String offer_imageURL, String offer_title, String offer_desc, String offer_enddate) {
        this.offer_imageURL = offer_imageURL;
        this.offer_title = offer_title;
        this.offer_desc = offer_desc;
        this.offer_enddate = offer_enddate;
    }

    public String getOffer_imageURL() {
        return offer_imageURL;
    }

    public void setOffer_imageURL(String offer_imageURL) {
        this.offer_imageURL = offer_imageURL;
    }

    public String getOffer_title() {
        return offer_title;
    }

    public void setOffer_title(String offer_title) {
        this.offer_title = offer_title;
    }

    public String getOffer_desc() {
        return offer_desc;
    }

    public void setOffer_desc(String offer_desc) {
        this.offer_desc = offer_desc;
    }

    public String getOffer_enddate() {
        return offer_enddate;
    }

    public void setOffer_enddate(String offer_enddate) {
        this.offer_enddate = offer_enddate;
    }
}

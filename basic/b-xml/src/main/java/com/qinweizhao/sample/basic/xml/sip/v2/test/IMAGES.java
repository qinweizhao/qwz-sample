package com.qinweizhao.sample.basic.xml.sip.v2.test;

import java.util.List;

public class IMAGES {


    public IMAGES() {
    }

    public IMAGES(String xpath) {
        this.xpath = xpath;
    }


//    private List<Image> IMAGE;

    private String xpath;
    private String img;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Image> IMAGE;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public List<Image> getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(List<Image> IMAGE) {
        this.IMAGE = IMAGE;
    }
}

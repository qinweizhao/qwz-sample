package com.qinweizhao.sample.basic.xml.sip.v2.test;

public class Image {



    private String FILE_NAME;
    private String FILE_PATH;
    private String ORDER_NO;


    protected String xpath;


    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
    public Image() {
    }

    public Image(String xpath) {
        this.xpath=xpath;
    }


    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public void setFILE_PATH(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public String getORDER_NO() {
        return ORDER_NO;
    }

    public void setORDER_NO(String ORDER_NO) {
        this.ORDER_NO = ORDER_NO;
    }


    @Override
    public String toString() {
        return "Image{" +
                "FILE_NAME='" + FILE_NAME + '\'' +
                ", FILE_PATH='" + FILE_PATH + '\'' +
                ", ORDER_NO='" + ORDER_NO + '\'' +
                '}';
    }
}

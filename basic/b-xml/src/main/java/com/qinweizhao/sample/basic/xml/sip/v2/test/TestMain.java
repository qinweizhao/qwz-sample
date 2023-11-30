package com.qinweizhao.sample.basic.xml.sip.v2.test;

import com.qinweizhao.sample.basic.xml.sip.v2.XmlConvert;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class TestMain {

    public static void main(String[] args) throws Exception {

        System.out.println("start run!");
        String xml = FileUtils.readFileToString(new File("E:\\Code\\qwz\\qwz-sample\\basic\\b-xml\\src\\main\\resources\\xml\\8088.xml"));
//        Image image = new Image("/POLICY_PRINT/IMAGES/IMAGE");
//        Image note = (Image) XmlConvert.convertNode(xml,image);
//        System.out.println("note = " + note);



        IMAGES IMAGES = new IMAGES("/POLICY_PRINT/IMAGES");
        IMAGES note2 = (IMAGES) XmlConvert.convertNode(xml, IMAGES);
        System.out.println("note2 = " + note2);





    }




}

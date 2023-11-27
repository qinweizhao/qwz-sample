package com.qinweizhao.sample.basic.xml;


import com.qinweizhao.sample.basic.xml.util.XmlUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
//        String xml = FileUtils.readFileToString(new File("E:\\Code\\qwz\\qwz-sample\\basic\\b-xml\\src\\main\\resources\\xml\\8088673426179668_20230414135141.xml"));
//        String valueV = XmlUtils.getValue(xml, "/POLICY_PRINT/INSUREDS/INSURED/NAME");
//        String xmlV = XmlUtils.getXml(xml, "/POLICY_PRINT/INSUREDS");
//        List<String> nodesV = XmlUtils.getNodes(xml, "/POLICY_PRINT/IMAGES/IMAGE");
//        System.out.println("valueV = " + valueV);
//        System.out.println("xmlV = " + xmlV);
//        System.out.println("nodesV = " + nodesV);

        List<String> list  = new ArrayList<>();
        list.add("1");
        list.add("11");
        List<String> list2  = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.addAll(list2);

        System.out.println(list);
    }
}
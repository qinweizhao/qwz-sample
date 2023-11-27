package com.qinweizhao.sample.basic.xml.util;


import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 此工具类需要 dom4j version>2
 *
 * @author qinweizhao
 * @since 2023-11-23
 */
public class XmlUtils {

    /**
     * 私有化构造函数
     */
    private XmlUtils() {
    }


    /**
     * [example]:
     * (xml)：
     * <INSUREDS>
     * <INSURED>
     * <NAME>福宝宝</NAME>
     * <GENDER>男</GENDER>
     * <AGE>37周岁</AGE>
     * <BIRTHDAY>1980年01月01日</BIRTHDAY>
     * <CERTI_TYPE>中国护照</CERTI_TYPE>
     * <CERTI_NO>12547852</CERTI_NO>
     * </INSURED>
     * </INSUREDS>
     * (path):
     * /INSUREDS/INSURED/NAME
     * return:
     * 福宝宝
     *
     * @param xml  原始 xml 内容
     * @param path 路径
     * @return 值
     * @throws DocumentException 异常
     */
    public static String getValue(String xml, String path) throws DocumentException {
        Document document = DocumentHelper.parseText(xml);
        Node node = document.selectSingleNode(path);
        return node.getText();
    }


    /**
     * [example]:
     * (xml)：
     * <INSUREDS>
     * <INSURED>
     * <NAME>福宝宝</NAME>
     * <GENDER>男</GENDER>
     * <AGE>37周岁</AGE>
     * <BIRTHDAY>1980年01月01日</BIRTHDAY>
     * <CERTI_TYPE>中国护照</CERTI_TYPE>
     * <CERTI_NO>12547852</CERTI_NO>
     * </INSURED>
     * </INSUREDS>
     * (path):
     * /INSUREDS/INSURED
     * return:
     * <INSURED>
     * <NAME>福宝宝</NAME>
     * <GENDER>男</GENDER>
     * <AGE>37周岁</AGE>
     * <BIRTHDAY>1980年01月01日</BIRTHDAY>
     * <CERTI_TYPE>中国护照</CERTI_TYPE>
     * <CERTI_NO>12547852</CERTI_NO>
     * </INSURED>
     *
     * @param xml  原始 xml 内容
     * @param path 路径
     * @return 值
     * @throws DocumentException 异常
     */
    public static String getXml(String xml, String path) throws DocumentException {
        Document document = DocumentHelper.parseText(xml);
        Node node = document.selectSingleNode(path);
        return node.asXML();
    }


    /**
     * [example]:
     * (xml)：
     * <Root>
     * <CASH_VALUES>
     * <CASH_VALUE>
     * <POLICY_YEAR>1</POLICY_YEAR>
     * <SV_CASH>18,200.00</SV_CASH>
     * </CASH_VALUE>
     * <CASH_VALUE>
     * <POLICY_YEAR>2</POLICY_YEAR>
     * <SV_CASH>46,300.00</SV_CASH>
     * </CASH_VALUE>
     * <CASH_VALUES>
     * </Root>
     * (path):
     * /Root/CASH_VALUES/CASH_VALUE
     * return:
     * []
     *
     * @param xml  原始 xml 内容
     * @param path 路径
     * @return 值
     * @throws DocumentException 异常
     */
    public static List<String> getNodes(String xml, String path) throws DocumentException {
        Document document = DocumentHelper.parseText(xml);
        List<Node> nodes = document.selectNodes(path);
        List<String> list = new LinkedList<>();
        nodes.forEach(item -> list.add(item.asXML()));
        return list;
    }


    /**
     * 测试
     * 结果：
     * valueV = 福宝宝
     * xmlV = <INSUREDS>
     * <INSURED>
     * <NAME>福宝宝</NAME>
     * <GENDER>男</GENDER>
     * <AGE>37周岁</AGE>
     * <BIRTHDAY>1980年01月01日</BIRTHDAY>
     * <CERTI_TYPE>中国护照</CERTI_TYPE>
     * <CERTI_NO>12547852</CERTI_NO>
     * </INSURED>
     * </INSUREDS>
     * nodesV = [<IMAGE>
     * <FILE_NAME>8088673426179668_20230415_1_38.png</FILE_NAME>
     * <FILE_PATH>/opt/appdata/policyPrint/policyPrintImage/2023/04/15/8088673426179668/8088673426179668_20230415_1_38.png</FILE_PATH>
     * <ORDER_NO>1</ORDER_NO>
     * </IMAGE>, <IMAGE>
     * <FILE_NAME>8088673426179668_20230415_2_88.png</FILE_NAME>
     * <FILE_PATH>/opt/appdata/policyPrint/policyPrintImage/2023/04/15/8088673426179668/8088673426179668_20230415_2_88.png</FILE_PATH>
     * <ORDER_NO>2</ORDER_NO>
     * </IMAGE>]
     *
     * @param args args
     * @throws Exception e
     */
    public static void main(String[] args) throws Exception {
        System.out.println("start run!");
        String xml = FileUtils.readFileToString(new File("E:\\Code\\qwz\\qwz-sample\\basic\\b-xml\\src\\main\\resources\\xml\\8088673426179668_20230414135141.xml"));
        String valueV = XmlUtils.getValue(xml, "/POLICY_PRINT/INSUREDS/INSURED/NAME");
        String xmlV = XmlUtils.getXml(xml, "/POLICY_PRINT/INSUREDS");
        List<String> nodesV = XmlUtils.getNodes(xml, "/POLICY_PRINT/IMAGES/IMAGE");
        System.out.println("valueV = " + valueV);
        System.out.println("xmlV = " + xmlV);
        System.out.println("nodesV = " + nodesV);
    }


}

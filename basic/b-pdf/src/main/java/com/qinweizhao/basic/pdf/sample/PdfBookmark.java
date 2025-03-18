package com.qinweizhao.basic.pdf.sample;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.SimpleBookmark;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfBookmark {
    public static void main(String[] args) throws Exception{
        // Creating a PdfWriter
        String dest = "C:\\Users\\YVKG\\Desktop\\00001dfd.pdf";
        String outPutFilePath = "E:\\2.txt";
        String separator= "=";
        run(dest, outPutFilePath, separator);


    }

    private static void run(String pdfFilePath, String outPutFilePath, String separator) throws Exception {
        List<Map<String, Object>> container = new ArrayList<>();


        PdfReader reader = new PdfReader(pdfFilePath);
        List<Map<String,Object>> bookmarkList = SimpleBookmark.getBookmark(reader);

        for (int i = 0; i < bookmarkList.size(); i++) {
            Map<String, Object> containerMap = new HashMap<>();
            Map<String,Object> bookmarkDict = bookmarkList.get(i);
//			// 提取书签名称、页面编号等信息
            Map<String, Object> hasValueMap = putValue(containerMap, bookmarkDict, separator);
            List<Map<String, Object>> childrenContainer = new ArrayList<>();
            hasValueMap.put("Children", childrenContainer);
            List<Map<String, Object>> kids = (ArrayList) bookmarkDict.get("Kids");
            if (ObjectUtil.isNotEmpty(kids)) {
                getChildren(childrenContainer, kids, separator);
            }
            container.add(containerMap);
        }

        String xml = formatXml(genXml(container));
        System.out.println("result-json = " + JSONUtil.toJsonStr(container));
        System.out.println("result-xml = " + xml);
        
        FileUtil.writeString(xml, outPutFilePath, StandardCharsets.UTF_8);


    }


    private static String genXml(List<Map<String, Object>> container) {
        StringBuilder result = new StringBuilder();
        result.append("<Bookmark>\n");
        if (ObjectUtil.isNotEmpty(container)) {
            appendNode(result, container);
        }

        result.append("</Bookmark>\n");
        return result.toString();
    }

    private static void appendNode(StringBuilder result, List<Map<String, Object>> container) {
        container.forEach(item -> {
            result.append("\n");
            StringBuilder nodeBuilder = new StringBuilder();
            String name = valueOf(item.get("Name"));
            String value = valueOf(item.get("Value"));
            String open = valueOf(item.get("Open"));
            String pageNo = valueOf(item.get("PageNo"));
            String action = valueOf(item.get("Action"));


            String node =
                    "<Title Name=\"" + name + "\" Value=\"" + value + "\" Open=\"" + open + "\" PageNo=\"" + pageNo + "\" Action=\"" + action + "\">";
            List<Map<String, Object>> childrenMap = (List<Map<String, Object>>) item.get("Children");
            if (ObjectUtil.isNotEmpty(childrenMap)) {
                appendNode(nodeBuilder, childrenMap);
            }
            result.append(node);
            result.append(nodeBuilder);
            result.append("\n");
            result.append(System.lineSeparator());
            result.append("</Title>");

        });

    }

    public static String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }

    private static String formatXml(String xml) throws Exception{

        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new ByteArrayInputStream(xml.getBytes()));
        //创建输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //制定输出xml的编码类型
        format.setEncoding("UTF-8");

        StringWriter writer = new StringWriter();
        //创建一个文件输出流
        XMLWriter xmlwriter = new XMLWriter( writer, format );
        //将格式化后的xml串写入到文件
        xmlwriter.write(document);
        String returnValue = writer.toString();
        writer.close();

        //返回编译后的字符串格式
        return returnValue;
    }

    private static Map<String, Object> putValue(Map<String, Object> containerMap, Map<String, Object> bookmarkDict, String splitChart) {
        String title = (String) bookmarkDict.get("Title");
        String pageNumber = (String) bookmarkDict.get("Page");
        if (ObjectUtil.isEmpty(pageNumber)){
            containerMap.put("PageNo", 1);
        }else {
            String[] pageNumberSplit = pageNumber.split(" ");
            containerMap.put("PageNo", pageNumberSplit[0]);
        }
        String open = (String) bookmarkDict.get("Open");
        String action = (String) bookmarkDict.get("Action");
        String[] titleSplit = title.split(splitChart);
        containerMap.put("Name", titleSplit[0]);
        if (titleSplit.length > 1) {
            containerMap.put("Value", titleSplit[1]);
        }

        containerMap.put("Open", open);
        containerMap.put("Action", action);

        return containerMap;
    }

    private static void getChildren(List<Map<String, Object>> container, List<Map<String, Object>> kids, String splitChart) {

        kids.forEach(item -> {
            Map<String, Object> itemMap = new HashMap<>();
            Map<String, Object> hasValueMap = putValue(itemMap, item, splitChart);
            List<Map<String, Object>> childrenContainer = new ArrayList<>();
            hasValueMap.put("Children", childrenContainer);
            List<Map<String, Object>> itemKids = (List<Map<String, Object>>) item.get("Kids");
            if (ObjectUtil.isNotEmpty(itemKids)) {
                getChildren(childrenContainer, itemKids, splitChart);
            }
            container.add(itemMap);
        });

    }


}

package com.qinweizhao.sample.basic.xml.sip;


import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {


    /**
     * xml转 map
     * @param xml 待转换数据xml字符串
     * @return JSONObject对象
     */
    public static Map<String,Object> xmlToMap(String xml) {
        Map<String, Object> map = null;
        try {
            map = new HashMap<>();
            Document document = DocumentHelper.parseText(xml);
            // 获取根节点元素对象
            Element root = document.getRootElement();
            iterateNodes(root, map);
        } catch (Exception e) {
            return map;
        }
        return map;
    }

    public static void iterateNodes(Element node, Map<String, Object> map) {
        // 获取当前元素的名称
        String nodeName = node.getName();
        // 判断已遍历的 Map 中是否已经有了该元素的名称
        if (map.containsKey(nodeName)) {
            // 该元素在同级下有多个
            Object Object = map.get(nodeName);
            List<Object> array;
            if (Object instanceof List) {
                array = (List<java.lang.Object>) Object;
            }
            else {
                array = new ArrayList<>();
                array.add(Object);
            }
            // 获取该元素下所有子元素
            List<Element> listElement = node.elements();
            if (listElement.isEmpty()) {
                // 该元素无子元素，获取元素的值
                String nodeValue = node.getTextTrim();
                array.add(nodeValue);
                map.put(nodeName, array);
                return;
            }
            // 有子元素
            Map<String, Object> newJson = new HashMap<>();
            // 遍历所有子元素
            for (Element e : listElement) {
                // 递归
                iterateNodes(e, newJson);
            }
            array.add(newJson);
            map.put(nodeName, array);
            return;
        }
        // 该元素同级下第一次遍历
        // 获取该元素下所有子元素
        List<Element> listElement = node.elements();
        if (listElement.isEmpty()) {
            // 该元素无子元素，获取元素的值
            String nodeValue = node.getTextTrim();
            map.put(nodeName, nodeValue);
            return;
        }
        // 有子节点，新建一个 Map 来存储该节点下子节点的值
        Map<String, Object> object = new HashMap<>();
        // 遍历所有一级子节点
        for (Element e : listElement) {
            // 递归
            iterateNodes(e, object);
        }
        map.put(nodeName, object);
    }



    //=====================   方法   ==============================//



    public static void main(String[] args) throws Exception {
        String xml = FileUtils.readFileToString(new File("E:\\Code\\qwz\\qwz-sample\\basic\\b-xml\\src\\main\\resources\\xml\\8088673426179668_20230414135141.xml"));

        Utils utils = new Utils();
        Map<String, Object> stringObjectMap = utils.xmlToMap(xml);
        System.out.println(stringObjectMap);


    }

}

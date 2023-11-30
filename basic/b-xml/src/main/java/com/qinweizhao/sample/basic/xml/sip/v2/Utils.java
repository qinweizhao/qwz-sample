package com.qinweizhao.sample.basic.xml.sip.v2;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.qinweizhao.sample.basic.xml.sip.v2.test.IMAGES;
import com.qinweizhao.sample.basic.xml.sip.v2.test.Image;
import org.apache.commons.io.FileUtils;
import org.dom4j.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {


    /**
     * xml转 map
     *
     * @param xml 待转换数据xml字符串
     * @return JSONObject对象
     */
    public static Object convert(String xml, Object obj) {

        Object result = null;
        try {
            Document document = DocumentHelper.parseText(xml);
            Method getXpath = obj.getClass().getMethod("getXpath");
            Object invoke = getXpath.invoke(obj);
            Node node = document.selectSingleNode(String.valueOf(invoke));


            String newXml = node.asXML();
            Document doc = null;
            try {
                doc = DocumentHelper.parseText(newXml);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
            Element rootElement = doc.getRootElement();
            Map<String, Object> map = new HashMap<>();
            iterateNodes(rootElement, map);
            Object images = map.get(rootElement.getName());
            String s = JSON.toJSONString(images);

            result = JSON.parseObject(s, obj.getClass());

        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    public static void iterateNodes(Element node, Map<String, Object> map) {
        // 获取当前元素的名称
        String nodeName = node.getName();
        //  属性处理
        List<Attribute> attributes = node.attributes();
        Map<String,Object> attrMap = new HashMap<>();
        attributes.forEach(attr-> attrMap.put(attr.getName(),attr.getValue()));
        // 判断已遍历的 Map 中是否已经有了该元素的名称
        if (map.containsKey(nodeName)) {
            // 该元素在同级下有多个
            Object Object = map.get(nodeName);
            List<Object> array;
            if (Object instanceof List) {
                array = (List<java.lang.Object>) Object;
            } else {
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
        object.putAll(attrMap);

        map.put(nodeName, object);
    }


    //=====================   方法   ==============================//


    public static void main(String[] args) throws Exception {

        String xml = FileUtils.readFileToString(new File("E:\\Code\\qwz\\qwz-sample\\basic\\b-xml\\src\\main\\resources\\xml\\8088.xml"));
        Image IMAGES = new Image("/POLICY_PRINT/IMAGES/IMAGE");

        Image image = (Image) Utils.convert(xml, IMAGES);

        System.out.println(JSON.toJSONString(image));

    }

}

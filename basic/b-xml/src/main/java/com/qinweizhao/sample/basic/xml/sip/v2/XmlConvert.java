package com.qinweizhao.sample.basic.xml.sip.v2;

import com.qinweizhao.sample.basic.xml.sip.v2.test.Image;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class XmlConvert {

    private XmlConvert() {
    }


    /**
     * 转换节点
     * @param xml xml
     * @param xpath xpath
     * @param aClass aClass
     */
    public static void convertNodes(String xml ,String xpath,Object aClass) {
//        //使用dom4j进行xml解析
//        try {
//
//            Document document = DocumentHelper.parseText(xml);
//            List<Node> nodes = document.selectNodes(xpath);
//
//
//            SAXReader saxReader = new SAXReader();
//            Document doc = saxReader.read("./note.xml");
//            Element rootElement = doc.getRootElement();
//            List<Element> elements = rootElement.elements();
//
//
//            Field[] declaredFields = aClass.getDeclaredFields();
//            for (Element element : elements) {
//                String name = element.getName();
//                Object data = element.getData();
//                //使用java反射设置属性
//                for (Field declaredField : declaredFields) {
//                    if (declaredField.getName().equals(name)) {
//                        declaredField.setAccessible(true);
//                        String type = declaredField.getType().getName();
//                        //针对不同类型做处理
//                        if (type.equals("int")) {
//                            Integer intData = Integer.valueOf(data.toString());
//                            declaredField.set(note, intData);
//                        } else {
//                            declaredField.set(note, data);
//                        }
//                    }
//                }
//            }
//            System.out.println(note);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    /**
     * 转换节点
     * @param xml xml
     * @param obj aClass
     */
    public static Object convertNode(String xml ,Object obj) {
        //使用dom4j进行xml解析
        try {
            Document document = DocumentHelper.parseText(xml);
            Object note = obj.getClass().newInstance();
            Method getXpath = obj.getClass().getMethod("getXpath");
            Object invoke = getXpath.invoke(obj);
            Node nodes = document.selectSingleNode(String.valueOf(invoke));
            String newXml = nodes.asXML();
            Document doc = DocumentHelper.parseText(newXml);
            Element rootElement = doc.getRootElement();
            List<Element> elements = rootElement.elements();



            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Element element : elements) {
                String name = element.getName();
                Object data = element.getText();
                //使用java反射设置属性
                for (Field declaredField : declaredFields) {


                    ParameterizedType genericType = (ParameterizedType) declaredField.getGenericType();
                    Class<?> actualTypeArgument =(Class<?>) genericType.getActualTypeArguments()[0];
                    Field[] declaredFields1 = actualTypeArgument.getDeclaredFields();
                    System.out.println(declaredFields1);


                    if (declaredField.getName().equals(name)) {
                        declaredField.setAccessible(true);
                        String type = declaredField.getType().getName();
                        //针对不同类型做处理
                        if (type.equals("int")) {
                            Integer intData = Integer.valueOf(data.toString());
                            declaredField.set(note, intData);
                        }else
//                            if(type.equals("list")){
//                            ParameterizedType genericType = (ParameterizedType) declaredField.getGenericType();
//                            Class<?> actualTypeArgument =(Class<?>) genericType.getActualTypeArguments()[0];
//                            Field[] declaredFields1 = actualTypeArgument.getDeclaredFields();
//                            System.out.println(declaredFields1);
//                        } else
                        {
                            declaredField.set(note, data);
                        }
                    }
                }
            }
            return note;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

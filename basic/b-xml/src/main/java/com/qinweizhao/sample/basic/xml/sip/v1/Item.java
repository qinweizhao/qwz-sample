package com.qinweizhao.sample.basic.xml.sip.v1;

import java.util.List;
import java.util.Map;

public class Item {


    public Item(String text, Map<String, Object> attrs, Object elements) {
        Text = text;
        this.attrs = attrs;
        this.elements = elements;
    }

    private String Text;

    private Map<String,Object> attrs;

    private Object elements;


    public Map<String,Object> getMap(){
        return (Map<String,Object>)elements;
    }

    public List<Map<String,Object>> getListMap(){
        return (List<Map<String,Object>>)elements;
    }


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }


    public Object getElements() {
        return elements;
    }

    public void setElements(Object elements) {
        this.elements = elements;
    }
}

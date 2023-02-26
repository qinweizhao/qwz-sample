package com.qinweizhao.basic.tool.xml;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Map;

/**
 * @author qinweizhao
 * @since 2023-02-26
 */
public class ParseXml {


    public static void main(String[] args) {
        String xml = getXml();
        JSONObject entries = JSONUtil.parseObj(xml);
        Map<String, Object> stringObjectMap = XmlUtil.xmlToMap(xml);
        JSONObject ChinaPost = entries.get("ChinaPost", JSONObject.class);
        System.out.println(entries);
    }

    private static String getXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<ChinaPost>\n" +
                "    <ChangeMessages>\n" +
                "        <ChangeMessage>\n" +
                "            <Orgcode>8613</Orgcode>\n" +
                "            <Orgname>中邮人寿保险股份有限公司河北分公司</Orgname>\n" +
                "            <Rename>哈哈</Rename>\n" +
                "            <Rephone>15611111111</Rephone>\n" +
                "            <Retell>8111111</Retell>\n" +
                "            <Sparename>11</Sparename>\n" +
                "            <Sparephone>15611111112</Sparephone>\n" +
                "            <Address>付电话费的活动符合</Address>\n" +
                "            <Postalcode>100000</Postalcode>\n" +
                "            <Changetime>2023-01-29 09:39:58</Changetime>\n" +
                "        </ChangeMessage>\n" +
                "        <ChangeMessage>\n" +
                "            <Orgcode></Orgcode>\n" +
                "            <Orgname></Orgname>\n" +
                "            <Rename></Rename>\n" +
                "            <Rephone></Rephone>\n" +
                "            <Retell></Retell>\n" +
                "            <Sparename></Sparename>\n" +
                "            <Sparephone></Sparephone>\n" +
                "            <Address></Address>\n" +
                "            <Postalcode></Postalcode>\n" +
                "            <Changetime></Changetime>\n" +
                "        </ChangeMessage>\n" +
                "    </ChangeMessages>\n" +
                "</ChinaPost>";
    }
}

package util;

import org.junit.jupiter.api.Test;

/**
 * @author qinweizhao
 * @since 2021/9/24
 */
class XmlUtilsTest {

    @Test
    void xml转json() {
        String result = "<OpInfo>\n" +
                "    <MediaShippingPlan>\n" +
                "        <PlanType>1</PlanType>\n" +
                "        <Planner>bn_admin</Planner>\n" +
                "        <DeliveryInfo>\n" +
                "            <FactoryID>YET-SH</FactoryID>\n" +
                "            <EstArrivalDate>2021/09/23</EstArrivalDate>\n" +
                "        </DeliveryInfo>\n" +
                "        <MediaList>\n" +
                "            <Media MediaID=\"JY-C001\">\n" +
                "                <Qty>20</Qty>\n" +
                "                <MediaName>交银电销封面</MediaName>\n" +
                "            </Media>\n" +
                "        </MediaList>\n" +
                "    </MediaShippingPlan>\n" +
                "</OpInfo>";
        System.out.println(XmlUtils.documentToJSONObject(result).toJSONString());
    }
}

package com.qinweizhao.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局日期格式化
 *
 * @author qinweizhao
 * @since 2021-11-20
 */
@JsonComponent
public class DateFormatConfig {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式化
     */
    public static class DateJsonSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(DATE_FORMAT.format(date));
        }
    }

    /**
     * 解析日期字符串
     */
    public static class DateJsonDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            try {
                return DATE_FORMAT.parse(jsonParser.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


///**
// * 全局日期格式化
// */
//@JsonComponent
//public class DateFormatConfig {
//
//    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z") {
//        @Override
//        public Date parse(String source) throws ParseException {
//            try {
//                if (StringUtils.isEmpty(source)) {
//                    return null;
//                }
//                return super.parse(source);
//            } catch (Exception e) {
//                return new StdDateFormat().parse(source);
//            }
//        }
//    };
//
//    private static UserController userController;//这里是指获取当前登录人的工具类
//
//    @Autowired
//    public void setUserController(UserController userController) {
//        DateFormatConfig.userController = userController;
//    }
//
//    /**
//     * 日期格式化
//     */
//    public static class DateJsonSerializer extends JsonSerializer<Date> {
//        @Override
//        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            //获取当前登录人的所属时区
//            dateFormat.setTimeZone(TimeZone.getTimeZone(userController.get().getTimezone()));
//            //格式化日期
//            jsonGenerator.writeString(dateFormat.format(date));
//        }
//    }
//
//    /**
//     * 解析日期字符串
//     */
//    public static class DateJsonDeserializer extends JsonDeserializer<Date> {
//        @Override
//        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//            try {
//                //获取当前登录人的所属时区
//                dateFormat.setTimeZone(TimeZone.getTimeZone(userController.get().getTimezone()));
//                //解析日期
//                return dateFormat.parse(jsonParser.getText());
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
//}
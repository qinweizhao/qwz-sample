package com.qinweizhao.framework.mybatisplus.other;


import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * @author qinweizhao
 * @since 2023-05-22
 */
public class Test {

    public class Entity {
        private String userName;

        public String getUserName() {
            return this.userName;
        }
    }

    public interface FieldFunction<T, R> extends Function<T, R>, Serializable {

    }

    public static <T> String getFieldName(FieldFunction<T, ?> func) {
        try {
            Method method = func.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(func);
            String getter = serializedLambda.getImplMethodName();
            return "获取到方法名称 = " + getter;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getFieldName(Entity::getUserName));
    }
}

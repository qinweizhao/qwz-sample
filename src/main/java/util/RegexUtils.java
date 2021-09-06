package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qinweizhao
 * @since 2021/9/6
 */
public class RegexUtils {

    /**
     * Utility classes, which are collections of static members,
     * are not meant to be instantiated. Even abstract utility classes,
     * which can be extended, should not have public constructors.
     */
    private RegexUtils() {

    }

    /**
     * 验证是否是URL
     *
     * @param url url
     * @return b
     */
    public static boolean verifyUrl(String url) {

        // URL验证规则
        String regEx = "[a-zA-Z]+://[^\\s]*";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        // 字符串是否与正则表达式相匹配
        return matcher.matches();
    }

}

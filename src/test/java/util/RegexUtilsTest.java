package util;

import org.junit.jupiter.api.Test;

/**
 * @author qinweizhao
 * @since 2021/9/24
 */
class RegexUtilsTest {
    @Test
    void 验证是否是URL() {
        String url = "https://www.qinweizhao.com";
        boolean b = RegexUtils.verifyUrl(url);
        System.out.println(b);
    }
}

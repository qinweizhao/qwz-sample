package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinweizhao
 * @since 2021/9/6
 */
public class UtilMain {

    private static final Logger log = LoggerFactory.getLogger(UtilMain.class);

    public static void main(String[] args) {

        // 验证是否是URL
        String url = "https://www.qinweizhao.com";
        boolean b = RegexUtils.verifyUrl(url);
        log.info("b = {}", b);
    }
}

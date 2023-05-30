package com.qinweizhao.pdf.util;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2023-05-30
 */
public class FontUtil {

    private FontUtil(){}


    public static Font getFont() throws DocumentException, IOException {
        //创建标题字体
        BaseFont title = BaseFont.createFont("/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //上面是基础的字体，代表使用哪一种字体，下面设置的是字体的字号，粗细等等属性
        //使用上面的title 字体 加粗，这个是标题字体
        return new Font(title, 22, Font.BOLD);
    }


}

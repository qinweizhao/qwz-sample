package com.qinweizhao.basic.pdf.event;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;

import java.awt.*;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */
public class PdfCustomEvent extends PdfPageEventHelper {
    private BaseFont baseFont;
    private int page=1;

    public PdfCustomEvent(BaseFont baseFont) {
        this.baseFont = baseFont;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        super.onStartPage(writer, document);
        page++;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        super.onEndPage(writer, document);

        PdfContentByte canvas = writer.getDirectContent();
        Rectangle rectangle =writer.getPageSize();
        Font headerFont = new Font(baseFont,10f, Font.NORMAL);

        ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, new Phrase("页眉。。。。。。", headerFont),
                rectangle.getRight() - 35, rectangle.getTop() - 17, 0);// 页眉

        Font watermarkFont = new Font(baseFont,130,Font.NORMAL,new Color(223,223,223,120));
        ColumnText.showTextAligned(writer.getDirectContentUnder(), Element.ALIGN_CENTER, new Phrase("SIP UAT Only", watermarkFont), rectangle.getRight()/2, rectangle.getTop()/2, 33);

        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase(""+page,headerFont),rectangle.getRight()/2 , rectangle.getBottom()+10, 0);//页脚
    }

}


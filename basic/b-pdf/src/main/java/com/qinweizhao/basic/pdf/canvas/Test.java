package com.qinweizhao.basic.pdf.canvas;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;

/**
 * @author qinweizhao
 * @since 2023-08-25
 */
public class Test {

    
    
    public static PdfPatternPainter dottedLine_40(PdfContentByte pcb) {

        float ratio=0.763f;

        float width = 1f*ratio;
        float height = 1f*ratio;

        PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);
        painter.setLineWidth(0.1f);
        painter.rectangle(0f*ratio, 1f*ratio, width, height);
        painter.rectangle(0f*ratio, 3f*ratio, width, height);
        painter.rectangle(0f*ratio, 5f*ratio, width, height);
        painter.rectangle(0f*ratio, 7f*ratio, width, height);
        painter.rectangle(1f*ratio, 0f*ratio, width, height);
        painter.rectangle(1f*ratio, 2f*ratio, width, height);
        painter.rectangle(1f*ratio, 4f*ratio, width, height);
        painter.rectangle(2f*ratio, 1f*ratio, width, height);
        painter.rectangle(2f*ratio, 3f*ratio, width, height);
        painter.rectangle(2f*ratio, 5f*ratio, width, height);
        painter.rectangle(2f*ratio, 7f*ratio, width, height);
        painter.rectangle(3f*ratio, 0f*ratio, width, height);
        painter.rectangle(3f*ratio, 2f*ratio, width, height);
        painter.rectangle(3f*ratio, 4f*ratio, width, height);
        painter.rectangle(3f*ratio, 6f*ratio, width, height);
        painter.rectangle(4f*ratio, 1f*ratio, width, height);
        painter.rectangle(4f*ratio, 3f*ratio, width, height);
        painter.rectangle(4f*ratio, 5f*ratio, width, height);
        painter.rectangle(4f*ratio, 7f*ratio, width, height);
        painter.rectangle(5f*ratio, 0f*ratio, width, height);
        painter.rectangle(5f*ratio, 4f*ratio, width, height);
        painter.rectangle(5f*ratio, 6f*ratio, width, height);
        painter.rectangle(6f*ratio, 1f*ratio, width, height);
        painter.rectangle(6f*ratio, 3f*ratio, width, height);
        painter.rectangle(6f*ratio, 5f*ratio, width, height);
        painter.rectangle(6f*ratio, 7f*ratio, width, height);
        painter.rectangle(7f*ratio, 0f*ratio, width, height);
        painter.rectangle(7f*ratio, 2f*ratio, width, height);
        painter.rectangle(7f*ratio, 4f*ratio, width, height);
        painter.rectangle(7f*ratio, 6f*ratio, width, height);


        painter.fill();
        return painter;
    }
    
    
    
}

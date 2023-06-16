package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.canvas.PatternCanvas;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 空心菱形网格
 *
 * @author qinweizhao
 * @since 2023-06-16
 */
public class DiamondGrid {
    public static void main(String[] args) {
        // Creating a PdfWriter
        String dest = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/main/resources/out/DiamondGrid.pdf";
        canvasLine(dest);
    }

    public static void canvasLine(String fileName) {
        try {
            // 文档对象 实现A4纸页面
            Document document = new Document(PageSize.A4);
            // 设置文档的页边距就是距离页面边上的距离，分别为：左边距，右边距，上边距，下边距
            document.setMargins(700, 700, 700, 700);
            // 这个是生成破pdf的位置以及名称

            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            // 打开文档
            document.open();
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte pcb = pdfWriter.getDirectContent();
            // an example of a rectangle with a diagonal in very thick lines
            pcb.setLineWidth(0f);
//            pcb.setColorStroke(Color.black);


            PdfPatternPainter painter= PatternCanvas.grid(pcb);
            pcb.setPatternFill(painter, Color.black);
            pcb.rectangle(100, 400, 400, 300);
            pcb.fillStroke();
            pcb.sanityCheck();

            document.newPage();

            PdfPatternPainter painter2= PatternCanvas.diamondGrid(pcb);
            pcb.setPatternFill(painter2, Color.black);
            pcb.rectangle(100, 400, 400, 300);
            pcb.fill();
            pcb.sanityCheck();


            document.close();
            pdfWriter.close();
            System.out.println("Object drawn on pdf successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}

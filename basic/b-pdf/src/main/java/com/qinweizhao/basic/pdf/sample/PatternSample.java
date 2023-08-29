package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Chunk;
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
public class PatternSample {
    public static void main(String[] args) {
        // Creating a PdfWriter
        String dest = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/main/resources/out/Pattern.pdf";
        canvasLine(dest);
    }

    public static void canvasLine(String fileName) {
        try {
            // 文档对象 实现A4纸页面
            Document document = new Document(PageSize.A4);
            // 设置文档的页边距就是距离页面边上的距离，分别为：左边距，右边距，上边距，下边距
            //document.setMargins(700, 700, 700, 700);
            // 这个是生成破pdf的位置以及名称

            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            // 打开文档
            document.open();
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte pcb = pdfWriter.getDirectContent();
            // an example of a rectangle with a diagonal in very thick lines
//            pcb.setLineWidth(0f);
//            pcb.setColorStroke(Color.black);
            document.newPage();


            /*
             * 5%
             */

            Chunk chunk5 = new Chunk("5%");
            chunk5.setUnderline(0.1f, -1f);
            document.add(chunk5);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painter5= PatternCanvas.dottedLine_5(pcb);
            pcb.setPatternFill(painter5, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 10%
             */
            document.newPage();
            Chunk chunk10 = new Chunk("10%");
            chunk10.setUnderline(0.1f, -1f);
            document.add(chunk10);
            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painter10= PatternCanvas.dottedLine_10(pcb);
            pcb.setPatternFill(painter10, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();

            /*
             * 20%
             */
            document.newPage();
            Chunk chunk20 = new Chunk("20%");
            chunk20.setUnderline(0.1f, -1f);
            document.add(chunk20);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painter20 = PatternCanvas.dottedLine_20(pcb);
            pcb.setPatternFill(painter20, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 25%
             */
            document.newPage();
            Chunk chunk25 = new Chunk("25%");
            chunk25.setUnderline(0.1f, -1f);
            document.add(chunk25);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painter25 = PatternCanvas.dottedLine_25(pcb);
            pcb.setPatternFill(painter25, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 30%
             */
            document.newPage();
            Chunk chunk30 = new Chunk("30%");
            chunk30.setUnderline(0.1f, -1f);
            document.add(chunk30);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter2= PatternCanvas.dottedLine_30(pcb);
            // 添加透明度
//            PdfGState gs = new PdfGState();
//            gs.setFillOpacity(0.9f);// 设置透明度为0.8
//            pcb.setGState(gs);
//            pcb.setPatternFill(painter2, Color.BLACK);
            pcb.setPatternFill(painter2, Color.BLACK);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 40%
             */
            document.newPage();
            Chunk chunk40 = new Chunk("40%");
            chunk40.setUnderline(0.1f, -1f);
            document.add(chunk40);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter40= PatternCanvas.dottedLine_40(pcb);
            pcb.setPatternFill(painter40, Color.BLACK);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
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

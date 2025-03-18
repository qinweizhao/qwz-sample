package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.canvas.PatternCanvas;
import com.qinweizhao.basic.pdf.util.FontUtil;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 空心菱形网格
 *
 * @author qinweizhao
 * @since 2023-06-16
 */
public class TmpPatternSample {
    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        // Creating a PdfWriter
//        String dest = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/main/resources/out/Pattern.pdf";
        String dest = "E:\\Code\\qwz\\qwz-sample\\basic\\b-pdf\\src\\test\\java\\com\\qinweizhao\\basic\\pdf\\out\\Pattern.pdf";
        canvasLine(dest);
    }

    public static void canvasLine(String fileName) throws FileNotFoundException, DocumentException {

        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream( "D:\\SIPMeta\\pattern.pdf"));
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        //创建底纹模版
        PdfTemplate tp = cb.createTemplate(500,20);
        //创建底纹图案
        PdfPatternPainter pat = PatternPainter.createPattern(cb, 5);
        //添加背景
        tp.setColorFill(new Color(236,236,236));
        tp.rectangle(0, 0, 500, 20);
        tp.fill();
        tp.sanityCheck();
        //添加背景至指定位置
        cb.addTemplate(tp, 50, 700);
        //添加前景及填充图案
        tp.setPatternFill(pat, Color.red, 1f);
        tp.rectangle(0, 0, 500, 20);
        tp.fill();
        tp.sanityCheck();
        //添加图案至指定位置
        cb.addTemplate(tp, 50, 700);
        cb.sanityCheck();
        //close the document
        document.close();
    }

}

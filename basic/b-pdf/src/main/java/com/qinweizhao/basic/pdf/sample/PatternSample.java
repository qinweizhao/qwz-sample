package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;
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
public class PatternSample {
    public static void main(String[] args) {
        // Creating a PdfWriter
//        String dest = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/main/resources/out/Pattern.pdf";
        String dest = "E:\\Code\\qwz\\qwz-sample\\basic\\b-pdf\\src\\test\\java\\com\\qinweizhao\\basic\\pdf\\out\\Pattern.pdf";
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
             * 12.5%
             */
            document.newPage();
            Chunk chunk12_5 = new Chunk("12.5%");
            chunk12_5.setUnderline(0.1f, -1f);
            document.add(chunk12_5);
            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painter12_5= PatternCanvas.dottedLine_12_5(pcb);
            pcb.setPatternFill(painter12_5, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();

            /*
             * 15%
             */
            document.newPage();
            Chunk chunk15 = new Chunk("15%");
            chunk15.setUnderline(0.1f, -1f);
            document.add(chunk15);
            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painter15= PatternCanvas.dottedLine_15(pcb);
            pcb.setPatternFill(painter15, Color.black);
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
             * 35%
             */
            document.newPage();
            Chunk chunk35 = new Chunk("35%");
            chunk35.setUnderline(0.1f, -1f);
            document.add(chunk35);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter35= PatternCanvas.dottedLine_35(pcb);
            pcb.setPatternFill(painter35, Color.BLACK);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 37.5%
             */
            document.newPage();
            Chunk chunk37_5 = new Chunk("37.5%");
            chunk37_5.setUnderline(0.1f, -1f);
            document.add(chunk37_5);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter37_5= PatternCanvas.dottedLine_37_5(pcb);
            pcb.setPatternFill(painter37_5, Color.BLACK);
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




            /*
             * 45%
             */
            document.newPage();
            Chunk chunk45 = new Chunk("45%");
            chunk45.setUnderline(0.1f, -1f);
            document.add(chunk45);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter45= PatternCanvas.dottedLine_45(pcb);
            pcb.setPatternFill(painter45, Color.BLACK);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 50%
             */
            document.newPage();
            Chunk chunk50 = new Chunk("50%");
            chunk50.setUnderline(0.1f, -1f);
            document.add(chunk50);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter50= PatternCanvas.dottedLine_50(pcb);
            pcb.setPatternFill(painter50, Color.BLACK);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 55%
             */
            document.newPage();
            Chunk chunk55 = new Chunk("55%");
            chunk55.setUnderline(0.1f, -1f);
            document.add(chunk55);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter55= PatternCanvas.dottedLine_55(pcb);
            pcb.setPatternFill(painter55, Color.BLACK);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 60%
             */
            document.newPage();
            Chunk chunk60 = new Chunk("60%");
            chunk60.setUnderline(0.1f, -1f);
            document.add(chunk60);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter60= PatternCanvas.dottedLine_60(pcb);
            pcb.setPatternFill(painter60, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 62.5%
             */
            document.newPage();
            Chunk chunk62_5 = new Chunk("62.5%");
            chunk62_5.setUnderline(0.1f, -1f);
            document.add(chunk62_5);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter62_5= PatternCanvas.dottedLine_62_5(pcb);
            pcb.setPatternFill(painter62_5, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 65%
             */
            document.newPage();
            Chunk chunk65 = new Chunk("65%");
            chunk65.setUnderline(0.1f, -1f);
            document.add(chunk65);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter65= PatternCanvas.dottedLine_65(pcb);
            pcb.setPatternFill(painter65, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();





            /*
             * 70%
             */
            document.newPage();
            Chunk chunk70 = new Chunk("70%");
            chunk70.setUnderline(0.1f, -1f);
            document.add(chunk70);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter70= PatternCanvas.dottedLine_70(pcb);
            pcb.setPatternFill(painter70, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();




            /*
             * 75%
             */
            document.newPage();
            Chunk chunk75 = new Chunk("75%");
            chunk75.setUnderline(0.1f, -1f);
            document.add(chunk75);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter75= PatternCanvas.dottedLine_75(pcb);
            pcb.setPatternFill(painter75, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();

            /*
             * 80%
             */
            document.newPage();
            Chunk chunk80 = new Chunk("80%");
            chunk80.setUnderline(0.1f, -1f);
            document.add(chunk80);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter80= PatternCanvas.dottedLine_80(pcb);
            pcb.setPatternFill(painter80, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();

            /*
             * 85%
             */
            document.newPage();
            Chunk chunk85 = new Chunk("85%");
            chunk85.setUnderline(0.1f, -1f);
            document.add(chunk85);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter85= PatternCanvas.dottedLine_85(pcb);
            pcb.setPatternFill(painter85, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 87.5%
             */
            document.newPage();
            Chunk chunk87_5 = new Chunk("87.5%");
            chunk87_5.setUnderline(0.1f, -1f);
            document.add(chunk87_5);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter87_5= PatternCanvas.dottedLine_87_5(pcb);
            pcb.setPatternFill(painter87_5, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();





            /*
             * 90%
             */
            document.newPage();
            Chunk chunk90 = new Chunk("90%");
            chunk90.setUnderline(0.1f, -1f);
            document.add(chunk90);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter90= PatternCanvas.dottedLine_90(pcb);
            pcb.setPatternFill(painter90, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 95%
             */
            document.newPage();
            Chunk chunk95 = new Chunk("95%");
            chunk95.setUnderline(0.1f, -1f);
            document.add(chunk95);

            pcb.setRGBColorFill(0,0,0);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();

            PdfPatternPainter painter95= PatternCanvas.dottedLine_95(pcb);
            pcb.setPatternFill(painter95, new Color(255,255,255));
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 深色横线
             */
            document.newPage();
            Font font = FontUtil.getFont();
            Chunk chunkDhl = new Chunk("深色横线",font);
            chunkDhl.setUnderline(0.1f, -1f);
            document.add(chunkDhl);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterDhl= PatternCanvas.darkHorizontalLine(pcb);
            pcb.setPatternFill(painterDhl, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 深色竖线
             */
            document.newPage();
            Chunk chunkDvl = new Chunk("深色竖线",font);
            chunkDvl.setUnderline(0.1f, -1f);
            document.add(chunkDvl);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterDvl= PatternCanvas.darkVerticalLine(pcb);
            pcb.setPatternFill(painterDvl, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();





            /*
             * 深色下斜线
             */
            document.newPage();
            Chunk chunkDd = new Chunk("深色下斜线",font);
            chunkDd.setUnderline(0.1f, -1f);
            document.add(chunkDd);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterDd= PatternCanvas.darkDownslash(pcb);
            pcb.setPatternFill(painterDd, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();





            /*
             * 深色上斜线
             */
            document.newPage();
            Chunk chunkDu = new Chunk("深色上斜线",font);
            chunkDu.setUnderline(0.1f, -1f);
            document.add(chunkDu);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterDu= PatternCanvas.     darkUpslash(pcb);
            pcb.setPatternFill(painterDu, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 深色网格
             */
            document.newPage();
            Chunk chunkDg = new Chunk("深色网格",font);
            chunkDg.setUnderline(0.1f, -1f);
            document.add(chunkDg);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterDg= PatternCanvas.darkGrid(pcb);
            pcb.setPatternFill(painterDg, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 深色棚架
             */
            document.newPage();
            Chunk chunkDs = new Chunk("深色棚架",font);
            chunkDs.setUnderline(0.1f, -1f);
            document.add(chunkDs);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterDs= PatternCanvas.darkScaffolds(pcb);
            pcb.setPatternFill(painterDs, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 浅色横线
             */
            document.newPage();
            Chunk chunkLhl = new Chunk("浅色横线",font);
            chunkLhl.setUnderline(0.1f, -1f);
            document.add(chunkLhl);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterLhl= PatternCanvas.lightHorizontalLine(pcb);
            pcb.setPatternFill(painterLhl, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 浅色竖线
             */
            document.newPage();
            Chunk chunkLvl = new Chunk("浅色竖线",font);
            chunkLvl.setUnderline(0.1f, -1f);
            document.add(chunkLvl);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterLvl= PatternCanvas.lightVerticalLine(pcb);
            pcb.setPatternFill(painterLvl, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 浅色下斜线
             */
            document.newPage();
            Chunk chunkLds = new Chunk("浅色下斜线",font);
            chunkLds.setUnderline(0.1f, -1f);
            document.add(chunkLds);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterLds= PatternCanvas.lightDownwardSlash(pcb);
            pcb.setPatternFill(painterLds, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 浅色上斜线
             */
            document.newPage();
            Chunk chunkLus = new Chunk("浅色上斜线",font);
            chunkLus.setUnderline(0.1f, -1f);
            document.add(chunkLus);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterLus= PatternCanvas.lightUpwardSlash(pcb);
            pcb.setPatternFill(painterLus, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();


            /*
             * 浅色网格
             */
            document.newPage();
            Chunk chunkLg = new Chunk("浅色网格",font);
            chunkLg.setUnderline(0.1f, -1f);
            document.add(chunkLg);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterLg= PatternCanvas.lightGrid(pcb);
            pcb.setPatternFill(painterLg, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();




            /*
             * 浅色棚架
             */
            document.newPage();
            Chunk chunkLs = new Chunk("浅色棚架",font);
            chunkLs.setUnderline(0.1f, -1f);
            document.add(chunkLs);

            pcb.setRGBColorFill(255,255,255);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.setColorStroke(Color.black);
            pcb.fillStroke();
            PdfPatternPainter painterLs= PatternCanvas.lightScaffolds(pcb);
            pcb.setPatternFill(painterLs, Color.black);
            pcb.rectangle(100, 400,378.70865F, 38.267715F );
            pcb.fillStroke();
            pcb.sanityCheck();



            /*
             * 浅色网格
             */
            document.newPage();
            Chunk chunkLine = new Chunk("线",font);
            chunkLine.setUnderline(0.1f, -1f);
            document.add(chunkLine);

            PdfPatternPainter painterLine= PatternCanvas.line2(pcb);
            pcb.setPatternFill(painterLine, Color.black);
//            pcb.rectangle(100, 400,100F, 2F );
            pcb.rectangle(100, 400,2F, 100F );
            pcb.setColorStroke(Color.white);

            pcb.fillStroke();
            pcb.sanityCheck();




            document.close();
            pdfWriter.close();
            System.out.println("Object drawn on pdf successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

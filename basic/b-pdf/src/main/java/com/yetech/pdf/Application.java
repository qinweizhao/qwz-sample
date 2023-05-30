package com.yetech.pdf;

import cn.hutool.core.date.DateUtil;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.codec.TiffImage;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class Application {

    public static void main(String[] args) {
//        Application.test();

        // text("这是要写入的文字","/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/fonts/SIMHEI.TTF");

//        image();
        try {
            test2();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 测试
     */
    public static void test() {
        PdfContentByte waterMar;
        try {
            //文档对象  实现A4纸页面
            Document document = new Document(PageSize.A4);
            //document.setMarginMirroring(true);
            //设置文档的页边距就是距离页面边上的距离，分别为：左边距，右边距，上边距，下边距
            document.setMargins(70, 70, 20, 10);
            //这个是生成破pdf的位置以及名称
            String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
            PdfWriter pdfWriter = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));
            //打开文档
            document.open();
            // 加载字体，因为我们标题和正文可能用的不是同一种字体，所以我们创建两种字体
            //有其他需求的就可以创建更多的字体
            //字体都是电脑自带的，如果你想要的电脑没有，就去网上下载
            //创建标题字体
            BaseFont title = BaseFont.createFont("/Users/weizhao/Code/tmp/yet-pdf/pdf-demo/src/test/resources/fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //创建正文字体
            BaseFont bf = BaseFont.createFont("/Users/weizhao/Code/tmp/yet-pdf/pdf-demo/src/test/resources/fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //上面是基础的字体，代表使用哪一种字体，下面设置的是字体的字号，粗细等等属性
            //使用上面的title 字体 加粗，这个是标题字体
            Font titleFont = new Font(title, 22, Font.BOLD);
            //使用字体，正文字体
            Font font = new Font(bf, 16);
            // 这个是我们动态填充的字体，Font.UNDERLINE带下划线的
            Font underlineFont = new Font(bf, 16, Font.UNDERLINE);

            // -------------------设置 二维码图片 ----------------
            // 加入水印
            waterMar = pdfWriter.getDirectContentUnder();
            // 开始设置水印图片
            waterMar.beginText();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //QrCodeUtils.createQrCodeBufferdImage这个方法就是将网址变成二维码图片
//            ImageIO.write(QrCodeUtils.createQrCodeBufferdImage("https://www.baidu.com",
//                    100, 100), "png", out);
//            byte[] b = out.toByteArray();
//            Image itextimage = Image.getInstance(b);
            // 水印图片位置 第一个参数为x轴，第二个参数为y轴
//            itextimage.setAbsolutePosition(120, 410);
            // 附件加上水印图片
//            waterMar.addImage(itextimage);
            //结束设置
            waterMar.endText();
            waterMar.stroke();

            // -------------------设置 段落 ----------------
            //这里面可以设置段落和短语（块），如果是那种固定文字的段落就可以用段落
            //如果我们需要生成的段落里有需要动态填充的就用块，一点一点的拼起来，直到达到我们的效果
            //段落
            Paragraph p = new Paragraph("这是一个标题", titleFont);
            p.setLeading(30);
            //设置对齐方式，这个是居中对齐
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            p = new Paragraph("哈哈哈哈哈哈哈", titleFont);
            p.setLeading(30);
            //设置对齐方式
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            p = new Paragraph();
            //短语
            Phrase ph = new Phrase();
            //块
            ph.add(new Chunk("哈哈哈哈哈哈哈", font));
            ph.add(new Chunk("2022" + " ", underlineFont));//年份
            ph.add(new Chunk("第", font));
            ph.add(new Chunk("100" + " ", underlineFont));// 号数
            ph.add(new Chunk("号", font));
            p.add(ph);
            //段落与段落的间距，我们一个ph就组成一个段落
            p.setSpacingBefore(20);
            //设置对齐方式，右对齐
            p.setAlignment(Element.ALIGN_RIGHT);
            p.setLeading(20);//行间距
            document.add(p);

            p = new Paragraph();
            ph = new Phrase();
            //机构名称
            ph.add(new Chunk("哈哈哈哈哈哈哈：", underlineFont));
            p.add(ph);
            //设置和上行的间隔
            p.setSpacingBefore(10);
            //p.setLeading(20);
            document.add(p);

            p = new Paragraph();
            ph = new Phrase();
            ph.add(new Chunk("    哈哈哈哈哈哈哈", font));
            ph.add(new Chunk("哈哈哈哈哈哈哈1", underlineFont));//项目名称
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈2", font));
            ph.add(new Chunk("哈哈哈哈哈哈哈3", underlineFont));//医院名称
            ph.add(new Chunk("哈哈哈哈哈哈哈4", font));
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈5", underlineFont));//建设项目名称
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈6", font));
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈7", underlineFont));//号
            ph.add(new Chunk("哈哈哈哈哈哈哈8", font));
            //ph.setMultipliedLeading(20);
            p.add(ph);
            p.setSpacingBefore(5);
            p.setLeading(30);
            document.add(p);

            p = new Paragraph();
            ph = new Phrase();
            ph.add(new Chunk("    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈9", font));
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈10", underlineFont));//项目名称
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈11", font));
            p.add(ph);
            p.setSpacingBefore(5);
            p.setLeading(30);
            document.add(p);

            p = new Paragraph();
            ph = new Phrase();
            ph.add(new Chunk("    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈12。", font));
            p.add(ph);
            p.setSpacingBefore(5);
            p.setLeading(30);
            document.add(p);


            p = new Paragraph();
            ph = new Phrase();
            ph.add(new Chunk("    此复", font));
            p.add(ph);
            p.setSpacingBefore(5);
            p.setLeading(30);
            document.add(p);


            p = new Paragraph();
            ph = new Phrase();
            ph.add(new Chunk("哈哈哈哈哈哈哈哈哈哈哈哈哈哈13", font));
            p.add(ph);
            p.setSpacingBefore(5);
            p.setAlignment(Element.ALIGN_RIGHT);//设置对齐方式
            p.setLeading(30);
            document.add(p);

            p = new Paragraph();
            ph = new Phrase();
            String date = DateUtil.now();
            ph.add(new Chunk(date.substring(0, 4) + " ", underlineFont));//年
            ph.add(new Chunk("年", font));
            ph.add(new Chunk(date.substring(5, 7) + " ", underlineFont));//月
            ph.add(new Chunk("月", font));
            ph.add(new Chunk(date.substring(8, 10) + " ", underlineFont));//日
            ph.add(new Chunk("日", font));
            p.add(ph);
            p.setSpacingBefore(5);
            p.setAlignment(Element.ALIGN_RIGHT);//设置对齐方式
            p.setLeading(30);
            document.add(p);

            document.close();
            pdfWriter.close();
            System.out.println("创建成功！");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 文本，支持自定义字体
     */
    public static void text(String text, String fontPath) {
        try {
            // 1、创建 document
            Document document = new Document();
            // 创建输出流
            String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
            OutputStream os = Files.newOutputStream(Paths.get(fileName).toFile().toPath());

            // 2、创建 PdfWriter
            PdfWriter.getInstance(document, os);


            // 3、开启 pdfDocument
            document.open();

            // 4、添加内容
            //创建字体
            BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //使用字体，正文字体
            Font font = new Font(bf, 16);

            Phrase p = new Phrase();
            Chunk chunk = new Chunk(text, font);
            chunk.setUnderline(0.2f, -3f);
            p.add(chunk);

            p.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.add(new Paragraph("xxxx"));//可以自动换行，但是无法设置间距
            paragraph.setLeading(40f);
            paragraph.setSpacingBefore(10f);
            paragraph.add(new Paragraph("xxxx"));

            document.add(p);
            document.add(paragraph);

            // 5、关闭 pdfDocument
            document.close();

            System.out.println("运行结束！");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("运行出现异常");
        }


    }

    public static void image() {
        try {
            Document document = new Document(PageSize.B5.rotate());

            String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));


            document.open();

            Image image = Image.getInstance(new URL("https://blog.qinweizhao.com/image/2022/05/avatar-2412a5066872422e860c1d9a3622c21a.jpeg"));
            image.scaleAbsolute(100, 100);
            // 水印图片位置 第一个参数为x轴，第二个参数为y轴
            image.setAbsolutePosition(100, 0);
            document.add(image);

            HeaderFooter header = new HeaderFooter(new Phrase("This is a header."), true);
            HeaderFooter footer = new HeaderFooter(new Phrase("This is page "), new Phrase("."));
            document.setHeader(header);
            document.setFooter(footer);


            document.close();

            System.out.println("image 方法运行结束");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void test2() throws IOException, DocumentException {
        //创建标题字体
        BaseFont title = BaseFont.createFont("/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/fonts/SIMHEI.TTF", BaseFont.IDENTITY_V, BaseFont.NOT_EMBEDDED);
        //上面是基础的字体，代表使用哪一种字体，下面设置的是字体的字号，粗细等等属性
        //使用上面的title 字体 加粗，这个是标题字体
        Font titleFont = new Font(title, 22, Font.BOLD);


        Image image1 = Image.getInstance(new URL("https://blog.qinweizhao.com/image/2022/05/avatar-2412a5066872422e860c1d9a3622c21a.jpeg"));
        image1.scaleAbsolute(100, 100);
        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
        image1.setAbsolutePosition(100, 0);

        Image image2 = Image.getInstance(new URL("https://blog.qinweizhao.com/image/2022/05/background-0552d42acfe044dc90946b6847456fc2.jpeg"));
        image2.scaleAbsolute(1000, 600);
        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
        image2.setAbsolutePosition(100, 110);

        Image image3 = Image.getInstance(new URL("https://blog.qinweizhao.com/image/test/ffa35d79.jpg"));
        image3.scaleAbsolute(1000, 1080);
        image3.setRotation(38f);
        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
        image3.setAbsolutePosition(100, 0);

        Image image4 = Image.getInstance(new URL("https://blog.qinweizhao.com/image/test/just-her.jpg"));
        image4.scaleAbsolute(1000, 120);
        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
        image4.setAbsolutePosition(100, 0);
        image4.setRotation(30f);


//
//        Image image5 = Image.getInstance(new URL("https://blog.qinweizhao.com/image/test/1950563026.png"));
//        image5.scaleAbsolute(100, 100);
//        image5.setRotation(90f);
//        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
//        image5.setAbsolutePosition(100, 0);

        Image image6 = Image.getInstance(new URL("https://blog.qinweizhao.com/image/test/1.jpg"));
        image6.scaleAbsolute(1000, 900);
        image6.setRotation(90f);
        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
        image6.setAbsolutePosition(100, 0);


        String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/target/test-classes/out/" + System.currentTimeMillis() + ".pdf";
        Document doc = new Document();
//        doc.setMargins(70, 70, 20, 10);

        PdfWriter writer = PdfWriter.getInstance(doc, Files.newOutputStream(Paths.get(fileName)));
//        writer.setPageEvent(new PdfCustomEvent(title));
        doc.open();

        PdfContentByte pdfContentByte = writer.getDirectContent();
        pdfContentByte.getPdfDocument().setPageSize(PageSize.A3);
        doc.newPage();
        doc.add(new Paragraph("Hello A3"));
//
//        doc.add(image1);
//        doc.add(image2);


        pdfContentByte.getPdfDocument().setPageSize(PageSize.A2);
        doc.newPage();

        doc.add(new Paragraph("Hello A2"));
//        doc.add(image3);
//        doc.add(image4);

        pdfContentByte.getPdfDocument().setPageSize(PageSize.B5.rotate());
        doc.newPage();
        Paragraph b5 = new Paragraph("B5横向页面版式", titleFont);
        doc.add(b5);

        RandomAccessFileOrArray ra = new RandomAccessFileOrArray("/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/image/out.tif");
        int pagesTif = TiffImage.getNumberOfPages(ra);
        for (int i = 1; i <= pagesTif; i++) {
            Image image = TiffImage.getTiffImage(ra, i);
            image.scaleAbsolute(PageSize.B5.getHeight(), PageSize.B5.getWidth());
            doc.setMargins(0, 0, 0, 0);
//            pdfContentByte.getPdfDocument().setPageSize(PageSize.B5.rotate());
            doc.newPage();
            doc.add(image);
        }


        pdfContentByte.getPdfDocument().setPageSize(PageSize.A4);
        doc.newPage();

        // 4、添加内容
        //创建字体
        BaseFont bf = BaseFont.createFont("/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/fonts/V100002_.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //使用字体，正文字体
        Font font = new Font(bf, 60);

        Paragraph paragraph = new Paragraph();
        doc.setMargins(600,100,100,100);
        Chunk chunk = new Chunk("*1515481884*", font);
        paragraph.setLeading(40f);
//        chunk.setUnderline(0.2f, -3f);
        paragraph.add(chunk);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        paragraph.add(Chunk.NEWLINE);

        doc.add(paragraph);

//        doc.add(image5);
//        doc.add(image6);


        pdfContentByte.getPdfDocument().setPageSize(PageSize.A4);
        doc.newPage();

        Barcode128 barcode128 = new Barcode128();
        barcode128.setCode("1213321313");

        Image imagex = Image.getInstance(barcode128.createAwtImage(Color.BLACK,Color.ORANGE),Color.BLACK,true);
        imagex.scaleAbsolute(100, 60);
        // 水印图片位置 第一个参数为x轴，第二个参数为y轴
        imagex.setAbsolutePosition(100, 600);
        imagex.setRotation(0f);

        doc.add(imagex);


        doc.newPage();


        doc.close();

        System.out.println("运行结束");
    }




}
package com.qinweizhao.basic.image.qrcode;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author qinweizhao
 * @since 2023-06-12
 */
public class Pdf417 {

    public static void main(String[] args) throws IOException, DocumentException {
        String FILE_DIR = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-image/src/main/resources/out/";
        FileOutputStream out = new FileOutputStream(FILE_DIR +UUID.randomUUID()+".pdf");
        //Step 1—Create a Document.
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.
        PdfWriter pdfWriter = PdfWriter.getInstance(document, out);
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        Paragraph helloWorld = new Paragraph("Hello World");
        document.add(helloWorld);
        PdfContentByte cb = new PdfContentByte(pdfWriter);
        generateQRcode(cb, document);
        //Step 5—Close the Document.

        document.close();
    }


    private static void generateQRcode(PdfContentByte cb, Document document) throws DocumentException, IOException {
        String myString = "https://www.baidu.com";

        // 条形码
        Barcode128 code128 = new Barcode128();
        code128.setCode(myString.trim());
        code128.setCodeType(Barcode128.CODE128);
        Image code128Image = code128.createImageWithBarcode(cb, null, null);
        code128Image.setAbsolutePosition(10, 600);
        code128Image.scalePercent(100);
        document.add(code128Image);




//        BarcodeQRCode qrcode = new BarcodeQRCode(myString.trim(), 1, 1, null);
//        Image qrcodeImage = qrcode.getImage();
//        qrcodeImage.setAbsolutePosition(10, 600);
//        qrcodeImage.scalePercent(200);
//        document.add(qrcodeImage);



        BufferedImage image = QrCodeUtil.createImage("utf-8", "www.baidu.com", 188, 188);


        Image out = Image.getInstance(image, Color.BLACK);
//
//        BarcodePDF417 barcodePDF417 = new BarcodePDF417();
//
//        barcodePDF417.setText(myString.getBytes());
//
//        java.awt.Image pdfImg = barcodePDF417.createAwtImage(Color.black, Color.white);
//
//        BufferedImage img = new BufferedImage((int) pdfImg.getWidth(null),
//                (int) pdfImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
//        Graphics g = img.getGraphics();
//
//        g.drawImage(pdfImg, 0, 0, Color.white, null);
//
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//        ImageIO.write(img, imgFileExt, os);
//
//        byte[] buffs = os.toByteArray();
//
//        os.close();


//        Image img = Image.getInstance(pdfImg, Color.BLACK);
        document.add(out);
    }

}

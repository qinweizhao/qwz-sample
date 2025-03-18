//package com.qinweizhao.basic.pdf.sample.demo;
//
////import com.itextpdf.text.Image;
////import com.itextpdf.text.Rectangle;
////import com.itextpdf.text.pdf.PdfReader;
////import com.itextpdf.text.pdf.PdfStamper;
////import com.itextpdf.text.pdf.PdfWriter;
////import com.itextpdf.text.pdf.security.CertificateInfo;
////import com.itextpdf.text.pdf.security.ExternalSignature;
////import com.itextpdf.text.pdf.security.PrivateKeySignature;
//import com.lowagie.text.Image;
//import com.lowagie.text.Rectangle;
//import com.lowagie.text.pdf.PdfReader;
//import com.lowagie.text.pdf.PdfSignatureAppearance;
//import com.lowagie.text.pdf.PdfStamper;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.security.PrivateKey;
//
//public class OpenPdfSign {
//    public static void main(String[] args) {
//        try {
//            // 加载现有的 PDF 文档
//            PdfReader pdfReader = new PdfReader("input.pdf");
//
//            // 文档签章信息
//            String signatureName = "Signature";
//            String reason = "Signing for testing";
//            String location = "Location";
//
//            // 初始化签章区域和大小
//            Rectangle rect = new Rectangle(100, 800, 200, 850);
//
//            // 输出文件
//            FileOutputStream fos = new FileOutputStream("output.pdf");
//
//            // 创建 PdfStamper 对象
//            PdfStamper ps = new PdfStamper(pdfReader, fos);
//            ps.setRotation(0, PdfWriter.ROTATE_90);
//
//            // 图像签章
//            Image image = Image.getInstance("signature.png");
//            ps.setFullCompression();
//
//            // 添加签章
//            PdfSignatureAppearance signatureAppearance = ps.getSignatureAppearance();
//            signatureAppearance.setReason(reason);
//            signatureAppearance.setLocation(location);
//            signatureAppearance.setLayer2Text(signatureName);
//            signatureAppearance.setImage(image);
//            signatureAppearance.setRectangle(rect);
//            signatureAppearance.setPageNumber(1);
//
//            // 实现 ExternalSignature 和 PrivateKeySignature 接口来提供签名
//            ExternalSignature externalSignature = new PrivateKeySignature(privateKey, "SHA-256", "BC");
//            makeSignature(signatureAppearance, externalSignature);
//
//            ps.close();
//            pdfReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void makeSignature(PdfSignatureAppearance appearance, ExternalSignature externalSignature) {
//        // 实现签章的具体逻辑
//    }
//}
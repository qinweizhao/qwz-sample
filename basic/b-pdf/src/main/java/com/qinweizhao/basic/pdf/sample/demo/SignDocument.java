package com.qinweizhao.basic.pdf.sample.demo;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static com.lowagie.text.pdf.PdfSignatureAppearance.SignatureRenderDescription;
import static com.lowagie.text.pdf.PdfSignatureAppearance.SignatureRenderGraphicAndDescription;

public class SignDocument {

    private static final int ESTIMATED_SIGNATURE_SIZE = 8192;

    private byte[] certificateChain;
    private Certificate[] certificates;
    private PrivateKey privateKey;

    public SignDocument() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        try (InputStream inputStream = new FileInputStream("D:\\Java\\jdk1.8.0_291\\bin\\qwz.p12")) {
//        try (InputStream inputStream = SignDocument.class.getResourceAsStream("D:\\Java\\jdk1.8.0_291\\bin\\qwz.p12")) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(inputStream, "123456".toCharArray());

            X509Certificate certificate = (X509Certificate) keyStore.getCertificate("serverkey");

            this.privateKey = (PrivateKey) keyStore.getKey("serverkey", "123456".toCharArray());
            this.certificateChain = certificate.getEncoded();
            this.certificates = new Certificate[]{certificate};
        }
    }

    public static void main(String[] args) throws IOException, DocumentException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        SignDocument signDocument = new SignDocument();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String path = "E:\\Code\\qwz\\qwz-sample\\basic\\b-pdf\\src\\test\\java\\com\\qinweizhao\\basic\\pdf\\out\\drawingLine.pdf";
        String outPath = "E:\\Code\\qwz\\qwz-sample\\basic\\b-pdf\\src\\test\\java\\com\\qinweizhao\\basic\\pdf\\out\\drawingLine-out.pdf";

        try (InputStream inputStream = new FileInputStream(path)) {

            signDocument.sign(IOUtils.toByteArray(inputStream), output);
        }
        File result = new File(outPath);
        FileUtils.writeByteArrayToFile(result, output.toByteArray());
    }

    public void sign(byte[] document, ByteArrayOutputStream output) throws IOException, DocumentException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        PdfReader pdfReader = new PdfReader(document);

        PdfStamper signer = PdfStamper.createSignature(pdfReader, output, '\0');

        Calendar signDate = Calendar.getInstance();
        signDate.setTime(new Date());
        int page = 1;

        PdfSignature pdfSignature = new PdfSignature(PdfName.ADOBE_PPKLITE, PdfName.ADBE_PKCS7_DETACHED);
        pdfSignature.setReason("Reason to sign");
        pdfSignature.setLocation("Location of signature");
        pdfSignature.setContact("Person Name");
        pdfSignature.setDate(new PdfDate(signDate));
        pdfSignature.setCert(certificateChain);


        // Digitally signed by
        PdfSignatureAppearance appearance = createAppearance(signer, page, pdfSignature);


        PdfPKCS7 sgn = new PdfPKCS7(null, certificates, null, "SHA-256", null, false);
        InputStream data = appearance.getRangeStream();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(IOUtils.toByteArray(data));
        byte[] appeareanceHash = digest.digest();

        byte[] hashToSign = sgn.getAuthenticatedAttributeBytes(appeareanceHash, appearance.getSignDate(), null);

        byte[] signedHash = addDigitalSignatureToHash(hashToSign);

        sgn.setExternalDigest(signedHash, null, "RSA");
        byte[] encodedPKCS7 = sgn.getEncodedPKCS7(appeareanceHash, appearance.getSignDate());

        byte[] paddedSig = new byte[ESTIMATED_SIGNATURE_SIZE];

        System.arraycopy(encodedPKCS7, 0, paddedSig, 0, encodedPKCS7.length);

        PdfDictionary dictionary = new PdfDictionary();
        dictionary.put(PdfName.CONTENTS, new PdfString(paddedSig).setHexWriting(true));
        appearance.close(dictionary);
    }

    private PdfSignatureAppearance createAppearance(PdfStamper signer, int page, PdfSignature pdfSignature) throws IOException, DocumentException {
        PdfSignatureAppearance appearance = signer.getSignatureAppearance();
        Image image = Image.getInstance("E:\\Code\\qwz\\qwz-sample\\basic\\b-pdf\\src\\test\\java\\com\\qinweizhao\\basic\\pdf\\out\\11.png");
//        appearance.setImage(image);
        appearance.setSignatureGraphic(image);
        appearance.setReason("sdafdsfsfassssddf");
        appearance.setLocation("sdafdsfsfassssddf");
//        appearance.setSignDate(null);
        appearance.setRender(SignatureRenderGraphicAndDescription);
        appearance.setAcro6Layers(true);


        int lowerLeftX = 100;
        int lowerLeftY = 400;
        int width = 200;
        int height = 200;
        appearance.setVisibleSignature(new Rectangle(lowerLeftX, lowerLeftY, width, height), page, null);
        appearance.setCryptoDictionary(pdfSignature);
        appearance.setCrypto(null, certificates, null, PdfName.FILTER);



        HashMap<Object, Object> exclusions = new HashMap<>();
        exclusions.put(PdfName.CONTENTS, ESTIMATED_SIGNATURE_SIZE * 2 + 2);
        appearance.preClose(exclusions);

        return appearance;
    }

    public byte[] addDigitalSignatureToHash(byte[] hashToSign) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(hashToSign);
        return signature.sign();
    }



}
	
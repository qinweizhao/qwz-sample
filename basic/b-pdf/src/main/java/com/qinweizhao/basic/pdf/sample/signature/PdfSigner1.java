package com.qinweizhao.basic.pdf.sample.signature;


import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfSignatureAppearance;
import com.lowagie.text.pdf.PdfStamper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

public class PdfSigner1 {
    public static void main(String[] args) throws Exception {
        // 输入的 PDF 文件
        String src = "path_to_input.pdf";
        // 输出的签名后的 PDF 文件
        String dest = "path_to_output_signed.pdf";

        // 加载 KeyStore，这通常包含你的私钥和证书
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream("path_to_your_keystore.p12"), "your_keystore_password".toCharArray());

        // 获取私钥
        String alias = ks.aliases().nextElement();
        PrivateKey pk = (PrivateKey) ks.getKey(alias, "your_private_key_password".toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);

        // 创建一个 PdfReader 和 PdfStamper 对象
        PdfReader reader = new PdfReader(src);
        FileOutputStream os = new FileOutputStream(dest);
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');

        // 创建一个签名外观
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason("Reason for signing");
        appearance.setLocation("Location");
//        appearance.setReuseAppearance(false);



//        IExternalSignature es = new PrivateKeySignature(rsaKey, "SHA-256");
//        // 创建一个签名
//        ExternalDigest digest = new BouncyCastleDigest();
//        ExternalSignature signature = new PrivateKeySignature(pk, "SHA-256", "BC");
//        MakeSignature.signDetached(appearance, digest, signature, chain, null, null, null, 0, MakeSignature.CryptoStandard.CMS);

        // 关闭资源
        os.close();
        reader.close();
    }
}
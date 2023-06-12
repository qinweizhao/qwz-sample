package com.qinweizhao.basic.image;

import com.qinweizhao.basic.image.qrcode.QrCodeUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author qinweizhao
 * @since 2023-06-12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("开始执行");

        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            BufferedImage image = QrCodeUtil.createImage("utf-8", "www.baidu.com", 188, 188);
            String uuid = UUID.randomUUID().toString();
            Image logo = ImageIO.read(new File("/Users/weizhao/Code/qwz/qwz-sample/basic/b-image/src/main/resources/logo.png"));
            QrCodeUtil.insertLogoImage(image, logo, 40, 40);
            QrCodeUtil.encode(image, "png", "/Users/weizhao/Code/qwz/qwz-sample/basic/b-image/src/main/resources/out/" + uuid + ".png");
            long end = System.currentTimeMillis() - start;
            System.out.println("执行结束，耗时" + end);
        }

    }
}
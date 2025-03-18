package com.qinweizhao.basic.ofd;

import org.ofdrw.layout.OFDDoc;
import org.ofdrw.layout.element.Paragraph;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path path = Paths.get("HelloWorld.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(path)) {
            Paragraph p = new Paragraph("你好呀，OFD Reader&Writer！");
            ofdDoc.add(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("生成文档位置: " + path.toAbsolutePath());

    }
}
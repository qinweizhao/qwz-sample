package com.qinweizhao.basic.pdf.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfSmartCopy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

/**
 * @author qinweizhao
 * @since 2023-05-31
 */
public class PdfUtils {


    private PdfUtils() {
    }

    /**
     * 抽取PDF文件
     *
     * @param sourceFile        源PDF文件路径
     * @param targetFile        目标PDF文件路径
     * @param extractedPageNums 需要抽取的页码
     */
    public static void extract(String sourceFile, String targetFile, List<Integer> extractedPageNums) {
        Objects.requireNonNull(sourceFile);
        Objects.requireNonNull(targetFile);
        PdfReader reader = null;
        Document document = null;
        FileOutputStream outputStream = null;
        try {
            // 读取源文件
            reader = new PdfReader(sourceFile);
            // 创建新的文档
            document = new Document();
            // 创建目标PDF文件
            outputStream = new FileOutputStream(targetFile);
            PdfCopy pdfCopy = new PdfSmartCopy(document, outputStream);

            // 获取源文件的页数
            int pages = reader.getNumberOfPages();
            document.open();

            // 注意此处的页码是从1开始
            for (int page = 1; page <= pages; page++) {
                // 如果是指定的页码，则进行复制
                if (extractedPageNums.contains(page)) {
                    pdfCopy.addPage(pdfCopy.getImportedPage(reader, page));
                }
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }

            if (document != null) {
                document.close();
            }

            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 抽取PDF文件
     *
     * @param sourceFile        源PDF文件路径
     * @param targetFile        目标PDF文件路径
     * @param document          目标文件
     * @param extractedPageNums 需要抽取的页码
     */
    public static void extract(String sourceFile, String targetFile, Document document, List<Integer> extractedPageNums) {
        Objects.requireNonNull(sourceFile);
        Objects.requireNonNull(document);
        PdfReader reader = null;

        FileOutputStream outputStream = null;
        try {
            // 读取源文件
            reader = new PdfReader(sourceFile);
            // 创建目标PDF文件
            PdfCopy pdfCopy = new PdfSmartCopy(document, Files.newOutputStream(Paths.get(targetFile)));

            // 获取源文件的页数
            int pages = reader.getNumberOfPages();
            document.open();
            document.newPage();
            document.setPageSize(PageSize.A4);

            // 注意此处的页码是从1开始
            for (int page = 1; page <= pages; page++) {
                // 如果是指定的页码，则进行复制
                if (extractedPageNums.contains(page)) {
                    pdfCopy.addPage(pdfCopy.getImportedPage(reader, page));
                }
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }

            if (document != null) {
                document.close();
            }

            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

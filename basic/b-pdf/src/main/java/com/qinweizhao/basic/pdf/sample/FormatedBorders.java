package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-06-29
 */

public class FormatedBorders {



    public static void main(String[] args) {

        String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/main/resources/out/"+ "FormatedBorders.pdf";
        sample(fileName);

    }


    public static void sample(String fileName) {

        try {
            Document document = new Document();
            document.setMargins(71, 70, 20, 10);
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));


            document.open();


            PdfPTable table=new PdfPTable(2);
            PdfPCell cell0 = new PdfPCell(new Phrase("cell0"));
            cell0.setBorder(3);
            cell0.setColspan(3);
            cell0.setFixedHeight(3);
            cell0.setBorderColorBottom(Color.RED);
            cell0.setBorderColorRight(Color.black);
            Color borderColor = cell0.getBorderColor();
            System.out.println(borderColor);
            cell0.setBorderColorTop(Color.yellow);
            table.addCell(cell0);
            table.completeRow();

            PdfPCell cell1 = new PdfPCell(new Phrase("cell1"));
            cell1.setBorderColorBottom(Color.RED);
            cell1.setBorderColorRight(Color.RED);
            cell1.setBorderColorTop(Color.RED);
            table.addCell(cell1);


            table.addCell(new PdfPCell(new Phrase("cell2")));


            document.add(table);
            document.close();


            System.out.println("运行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

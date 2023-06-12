package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.util.FontUtil;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class PdfTable {


	public static void main(String[] args) {

		String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
		sample(fileName);

	}


	public static void sample(String fileName) {

		try {
			Document document = new Document(PageSize.A4);
			document.setMargins(70, 70, 20, 10);
			PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));

			Font font = FontUtil.getFont();

			HeaderFooter footer = getHeaderFooter(font);
			document.setFooter(footer);

			document.open();

			Phrase ph = new Phrase();
			Table table = new Table(3);
			table.setBorderWidth(1);
			table.setBorderColor(new Color(0, 0, 255));
			table.setPadding(5);
			table.setSpacing(5);
			Cell cell = new Cell("header");
			cell.setHeader(true);
			cell.setColspan(3);
			table.addCell(cell);
			table.endHeaders();
			cell = new Cell("example cell with colspan 1 and rowspan 2");
			cell.setRowspan(2);
			cell.setBorderColor(new Color(255, 0, 0));
			table.addCell(cell);
			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("cell test1");
			cell = new Cell("big cell");
			cell.setRowspan(2);
			cell.setColspan(2);
			table.addCell(cell);
			table.addCell("cell test2");


			document.add(ph);
			document.add(table);
			document.close();


			System.out.println("运行结束");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static HeaderFooter getHeaderFooter(Font font) {
		HeaderFooter footer = new HeaderFooter(new Phrase("页码：", font), true);
		footer.setAlignment(HeaderFooter.ALIGN_CENTER);
		footer.setBorder(Rectangle.NO_BORDER);
		return footer;
	}


}

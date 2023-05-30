package com.yetech.pdf.sample;

import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class PdfTable {


	public static void main(String[] args) {

		String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
		sample(fileName);

	}


	public static void sample(String fileName) {

		try {
			Document document = new Document(PageSize.A4);
			document.setMargins(70, 70, 20, 10);
			PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));

			Font font = getFont();

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

	private static Font getFont() throws DocumentException, IOException {
		//创建标题字体
		BaseFont title = BaseFont.createFont("/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/fonts/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		//上面是基础的字体，代表使用哪一种字体，下面设置的是字体的字号，粗细等等属性
		//使用上面的title 字体 加粗，这个是标题字体
		Font font = new Font(title, 22, Font.BOLD);
		return font;
	}


}

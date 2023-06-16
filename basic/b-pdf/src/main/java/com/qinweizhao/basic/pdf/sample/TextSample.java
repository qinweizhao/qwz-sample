package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.util.FontUtil;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class TextSample {


	public static void main(String[] args) {

		String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-pdf/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
		sample(fileName);

	}


	public static void sample(String fileName) {

		try {
			Document document = new Document();
			document.setMargins(71, 70, 20, 10);
			PdfWriter writer = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));


			Font font = FontUtil.getFont();

			HeaderFooter footer = new HeaderFooter(new Phrase("页码：",font), true);
			footer.setAlignment(HeaderFooter.ALIGN_CENTER);
			footer.setBorder(Rectangle.NO_BORDER);
			document.setFooter(footer);


			document.open();

			//添加文本
			PdfContentByte cb = writer.getDirectContent();
			BaseFont bf = FontUtil.getBaseFont();

			cb.beginText();
			cb.setFontAndSize(bf, 12);
			cb.setTextMatrix(200, 500);
			cb.showText("这是要展示的文");
			cb.endText();
			cb.beginText();
			cb.setFontAndSize(bf, 12);
			cb.setTextMatrix(200, 400);
			cb.showText("字测试");
			cb.endText();

			document.close();


			System.out.println("运行结束");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

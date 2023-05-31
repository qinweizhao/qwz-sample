package com.qinweizhao.pdf.sample;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.pdf.util.FontUtil;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class PdfSampleTemplate {


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

			HeaderFooter footer = new HeaderFooter(new Phrase("页码：",font), true);
			footer.setAlignment(HeaderFooter.ALIGN_CENTER);
			footer.setBorder(Rectangle.NO_BORDER);
			document.setFooter(footer);
			document.open();


			Phrase ph = new Phrase();
			ph.add(new Chunk("你好1", font));
			document.add(ph);
			document.newPage();
			Phrase p = new Phrase();
			ph.add(new Chunk("你好2", font));
			document.add(p);

			document.close();


			System.out.println("运行结束");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

package com.yetech.pdf.sample;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class PdfSampleTemplate {


	public static void main(String[] args) {

		String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/target/test-classes/out/" + System.currentTimeMillis() + ".pdf";
		sample(fileName);

	}


	public static void sample(String fileName) {

		try {
			Document document = new Document(PageSize.A4);
			document.setMargins(70, 70, 20, 10);
			PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));
			Font font = getFont();

			HeaderFooter footer = new HeaderFooter(new Phrase("页码：",font), true);
			footer.setAlignment(HeaderFooter.ALIGN_CENTER);
			footer.setBorder(Rectangle.NO_BORDER);
			document.setFooter(footer);
			document.open();
//
//			Font arialFont = new RtfFont("黑 体");
//			Font songFont = new RtfFont("宋 体");
//			Font imitationSongFont = new RtfFont("仿宋");

//			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//			Font fontChinese = new Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);


			Phrase ph = new Phrase();
//			ph.add(new Chunk("这是黑体字体输出的文字", arialFont));
//			ph.add(new Chunk("这是宋体字体输出的文字", songFont));
//			ph.add(new Chunk("这是仿宋字体输出的文字", imitationSongFont));
			ph.add(new Chunk("你好", font));
			document.add(ph);

			document.close();


			System.out.println("运行结束");
		} catch (Exception e) {
			e.printStackTrace();
		}

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

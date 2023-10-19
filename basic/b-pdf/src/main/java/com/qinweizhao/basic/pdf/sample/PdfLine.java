package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.canvas.LineCanvas;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfLine {
	public static void main(String[] args) {
		// Creating a PdfWriter
		String dest = "E:\\Code\\qwz\\qwz-sample\\basic\\b-pdf\\src\\test\\java\\com\\qinweizhao\\basic\\pdf\\out\\drawingLine.pdf";
		canvasLine(dest);
	}

	public static void canvasLine(String fileName) {
		try {
			// 文档对象 实现A4纸页面
			Document document = new Document(PageSize.A4);
			// document.setMarginMirroring(true);
			// 设置文档的页边距就是距离页面边上的距离，分别为：左边距，右边距，上边距，下边距
			document.setMargins(70, 70, 20, 10);
			// 这个是生成破pdf的位置以及名称

			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			// 打开文档
			document.open();
			// step 4: we grab the ContentByte and do some stuff with it
			PdfContentByte pcb = pdfWriter.getDirectContent();
			// an example of a rectangle with a diagonal in very thick lines
			pcb.setLineWidth(1f);
			pcb.setColorStroke(Color.RED);
			// pcb.setLineDash(3, 3, 0);
			// add the diagonal
//			pcb.moveTo(100, 700);
//			pcb.lineTo(200, 700);
//
//			pcb.moveTo(100.5f, 700);
//			pcb.lineTo(100, 600);
//
//			pcb.moveTo(100, 600);
//			pcb.lineTo(200, 600);
//
//			pcb.moveTo(200, 700);
//			pcb.lineTo(200, 600);
//			// stroke the lines
//			pcb.stroke();
//
//			document.newPage();


			pcb.moveTo(200, 700);
			pcb.lineTo(200, 600);
			pcb.setLineWidth(3F);
			float[] array = {1,1};
			pcb.setLineDash(array,1);
//			pcb.setLineDash(array,1);
//			pcb.setLineJoin();
			// stroke the lines
			pcb.stroke();
			document.close();
			pdfWriter.close();
			System.out.println("Object drawn on pdf successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}

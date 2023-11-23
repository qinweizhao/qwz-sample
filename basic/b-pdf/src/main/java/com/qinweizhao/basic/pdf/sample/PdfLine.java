package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.canvas.LineCanvas;
import com.qinweizhao.basic.pdf.canvas.PatternCanvas;
import com.qinweizhao.basic.pdf.util.FontUtil;

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
			Document document = new Document(PageSize.A4);

			document.setMargins(70, 70, 20, 10);

			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));

			document.open();

			PdfContentByte pcb = pdfWriter.getDirectContent();

			Font font = FontUtil.getFont();

			/*
			 * 线
			 */
			document.newPage();
			Chunk chunkLine = new Chunk("线",font);
			chunkLine.setUnderline(0.1f, -1f);
			document.add(chunkLine);

			PdfPatternPainter painterLine= LineCanvas.line025(pcb);
			pcb.setPatternFill(painterLine, Color.black);

			pcb.rectangle(100, 400,20F, 100F );
//			pcb.rectangle(100, 400,200F, 3F );
			pcb.setColorStroke(Color.white);

			pcb.fillStroke();
			pcb.sanityCheck();


			document.newPage();

			// 设置线宽
			pcb.setLineWidth(1f);
			// 设置线颜色
			pcb.setColorStroke(Color.RED);
			 pcb.setLineCap(2);
			 pcb.setLineDash(3, 3, 0);
			// 设置画线起点坐标
			pcb.moveTo(200, 200);
			// 设置画线终点坐标
			pcb.lineTo(500, 500);
			// 画线
			pcb.stroke();



			document.close();
			pdfWriter.close();
			System.out.println("Object drawn on pdf successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package com.qinweizhao.basic.pdf.canvas;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;

/**
 * 线图案

 */
public class LineCanvas {



	/**
	 * 0.25
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter line0_25(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(2*ratio, 1*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.fill();

		return painter;
	}


	public static PdfPatternPainter line025(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(1*ratio, 2*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.fill();

		return painter;
	}



}

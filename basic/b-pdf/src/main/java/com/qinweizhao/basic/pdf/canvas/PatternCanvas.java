package com.qinweizhao.basic.pdf.canvas;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;

/**
 * 底纹图案
 * 
 * @ClassName: PatternCanvas
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: [Json]
 * @date: 2023年6月16日 下午1:22:35
 *
 * @Copyright: 2023 www.yetech.com.cn Inc. All rights reserved.
 *             注意：本内容仅限于元镁科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class PatternCanvas {
	/**
	 * 网格
	 * 
	 * @param pcb
	 * @return: PdfPatternPainter
	 * @since 1.0
	 */
	public static PdfPatternPainter grid(PdfContentByte pcb) {
		PdfPatternPainter painter = pcb.createPattern(8, 8, null);
		painter.setLineWidth(0.3F);

//		float[] array1 =  {0.3F,0.3F,0.3F,0.3F,0.3F,0.3F};

		painter.setLineDash(1,3,8F);
//		painter.setLineCap(LINE_CAP_PROJECTING_SQUARE);
//		painter.setLineCap(LINE_CAP_PROJECTING_SQUARE);

		// H-横线
		painter.moveTo(0, 2);
		painter.lineTo(8, 2);
		painter.stroke();

		painter.moveTo(0, 6);
		painter.lineTo(8, 6);
		painter.stroke();
		// V-竖线
		painter.moveTo(2, 0);
		painter.lineTo(2, 8);
		painter.stroke();

		painter.moveTo(6, 0);
		painter.lineTo(6, 8);
		painter.stroke();
		return painter;
	}

	/**
	 * 菱形
	 *
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter PdfPatternPainter
	 * @since 1.0
	 */
	public static PdfPatternPainter diamondGrid(PdfContentByte pcb) {
		PdfPatternPainter painter = pcb.createPattern(8, 8, null);
		painter.setLineWidth(0);


		painter.moveTo(8, 4);
		painter.lineTo(4, 8);
		painter.stroke();

		painter.moveTo(4, 8);
		painter.lineTo(0, 4);
		painter.stroke();

		painter.moveTo(0, 4);
		painter.lineTo(4, 0);
		painter.stroke();

		painter.moveTo(4, 0);
		painter.lineTo(8, 4);
		painter.stroke();

		return painter;
	}
}

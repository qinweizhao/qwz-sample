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

		painter.setLineDash(1, 3, 8F);
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


	/**
	 * 点线 5%
	 *
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter dottedLine_5_1(PdfContentByte pcb) {
		float ratio=1.55f;
//		float ratio=1.65f;
//		float ratio=3.11f;
//		float ratio=2f;
		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);
		
		// 左上角
		painter.rectangle(0, 0, 0.5f*ratio, 0.5f*ratio);
		// 右上角
		painter.rectangle(7.5f*ratio, 0, 0.5f*ratio, 0.5f*ratio);
		// 左下角
		painter.rectangle(0, 7.5f*ratio, 0.5f*ratio, 0.5f*ratio);
		// 右下角
		painter.rectangle(7.5f*ratio, 7.5f*ratio, 0.5f*ratio, 0.5f*ratio);
		// 中心
		painter.rectangle(3.5f*ratio, 3.5f*ratio, 1*ratio, 1*ratio);
		painter.fill();
		return painter;
	}



	public static PdfPatternPainter dottedLine_5_2(PdfContentByte pcb) {
		float ratio=1.65f;
//		float ratio=1.65f;
//		float ratio=3.11f;
//		float ratio=2f;
//		PdfPatternPainter painter = pcb.createPattern(16*ratio, 8*ratio, null);
		PdfPatternPainter painter = pcb.createPattern(16*ratio, 8*ratio, null);
		
		// 左上角
		painter.rectangle(5.5f*ratio, 1.5f*ratio, 1f*ratio, 1f*ratio);
		// 右上角
		painter.rectangle(13.5f*ratio, 1.5f*ratio, 1f*ratio, 1f*ratio);
		// 左下角
		painter.rectangle(1.5f*ratio, 5.5f*ratio, 1f*ratio, 1f*ratio);
		// 右下角
		painter.rectangle(9.5f*ratio, 5.5f*ratio, 1f*ratio, 1f*ratio);

		painter.fill();
		return painter;
	}


	public static PdfPatternPainter dottedLine_5(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);
		
		painter.rectangle(1.5f*ratio, 1.5f*ratio, width, height);
		painter.rectangle(5.5f*ratio, 5.5f*ratio, width, height);
		painter.fill();

		return painter;
	}





	public static PdfPatternPainter dottedLine_10(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(8*ratio, 4*ratio, null);
		
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(4f*ratio, 1f*ratio, width, height);


		painter.fill();
		return painter;
	}


	/**
	 * 浅色下对角线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter style_0(PdfContentByte pcb) {
		float base=1.4f;

		PdfPatternPainter painter = pcb.createPattern(4/base, 4/base, null);
		painter.rectangle(0f/base, 3f/base, 0.8f/base, 0.8f/base);
		painter.rectangle(1f/base, 2f/base, 0.8f/base, 0.8f/base);
		painter.rectangle(2f/base, 1/base, 0.8f/base, 0.8f/base);
		painter.rectangle(3f/base, 0f/base, 0.8f/base, 0.8f/base);

		painter.fill();
		return painter;
	}





	public static PdfPatternPainter dottedLine_20(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);
		
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);

		painter.fill();
		return painter;
	}


	public static PdfPatternPainter dottedLine_25(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 2*ratio, null);
		
		painter.rectangle(0f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);

		painter.fill();
		return painter;
	}



	public static PdfPatternPainter dottedLine_30(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);

		painter.fill();
		return painter;
	}



	public static PdfPatternPainter dottedLine_40(PdfContentByte pcb) {

		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);
//		painter.setLineWidth(ratio);
		painter.rectangle(0f*ratio, 1f*ratio, width, height);
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(0f*ratio, 5f*ratio, width, height);
		painter.rectangle(0f*ratio, 7f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(1f*ratio, 4f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 3f*ratio, width, height);
		painter.rectangle(2f*ratio, 5f*ratio, width, height);
		painter.rectangle(2f*ratio, 7f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 4f*ratio, width, height);
		painter.rectangle(3f*ratio, 6f*ratio, width, height);
		painter.rectangle(4f*ratio, 1f*ratio, width, height);
		painter.rectangle(4f*ratio, 3f*ratio, width, height);
		painter.rectangle(4f*ratio, 5f*ratio, width, height);
		painter.rectangle(4f*ratio, 7f*ratio, width, height);
		painter.rectangle(5f*ratio, 0f*ratio, width, height);
		painter.rectangle(5f*ratio, 4f*ratio, width, height);
		painter.rectangle(5f*ratio, 6f*ratio, width, height);
		painter.rectangle(6f*ratio, 1f*ratio, width, height);
		painter.rectangle(6f*ratio, 3f*ratio, width, height);
		painter.rectangle(6f*ratio, 5f*ratio, width, height);
		painter.rectangle(6f*ratio, 7f*ratio, width, height);
		painter.rectangle(7f*ratio, 0f*ratio, width, height);
		painter.rectangle(7f*ratio, 2f*ratio, width, height);
		painter.rectangle(7f*ratio, 4f*ratio, width, height);
		painter.rectangle(7f*ratio, 6f*ratio, width, height);


		painter.fill();
		return painter;
	}
}

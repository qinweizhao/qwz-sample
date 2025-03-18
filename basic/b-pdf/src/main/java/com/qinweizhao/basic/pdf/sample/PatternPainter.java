package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPatternPainter;

/**
 * 图案绘制
 * @author  Json
 * @since   1.0
 */
public class PatternPainter {

	/**
	 * 私有化构造函数
	 */
	private PatternPainter(){}


	public static PdfPatternPainter createPattern(PdfContentByte pcb,int patternType) {

		switch (patternType){
			case PatternStyle.PERCENT_5:
				return percent_5(pcb);
			case PatternStyle.PERCENT_10:
				return percent_10(pcb);
			case PatternStyle.PERCENT_12PT5:
				return percent_12pt5(pcb);
			case PatternStyle.PERCENT_15:
				return percent_15(pcb);
			case PatternStyle.PERCENT_20:
				return percent_20(pcb);
			case PatternStyle.PERCENT_25:
				return percent_25(pcb);
			case PatternStyle.PERCENT_30:
				return percent_30(pcb);
			case PatternStyle.PERCENT_35:
				return percent_35(pcb);
			case PatternStyle.PERCENT_37PT5:
				return percent_37pt5(pcb);
			case PatternStyle.PERCENT_40:
				return percent_40(pcb);
			case PatternStyle.PERCENT_45:
				return percent_45(pcb);
			case PatternStyle.PERCENT_50:
				return percent_50(pcb);
			case PatternStyle.PERCENT_55:
				return percent_55(pcb);
			case PatternStyle.PERCENT_60:
				return percent_60(pcb);
			case PatternStyle.PERCENT_62PT5:
				return percent_62pt5(pcb);
			case PatternStyle.PERCENT_65:
				return percent_65(pcb);
			case PatternStyle.PERCENT_70:
				return percent_70(pcb);
			case PatternStyle.PERCENT_75:
				return percent_75(pcb);
			case PatternStyle.PERCENT_80:
				return percent_80(pcb);
			case PatternStyle.PERCENT_85:
				return percent_85(pcb);
			case PatternStyle.PERCENT_87PT5:
				return percent_87pt5(pcb);
			case PatternStyle.PERCENT_90:
				return percent_90(pcb);
			case PatternStyle.PERCENT_95:
				return percent_95(pcb);
			case PatternStyle.SOLID:
				return solid(pcb);
			case PatternStyle.DARK_HORIZONTAL:
				return darkHorizontal(pcb);
			case PatternStyle.DARK_VERTICAL:
				return darkVertical(pcb);
			case PatternStyle.DARK_DIAGONAL_DOWN:
				return darkDiagonalDown(pcb);
			case PatternStyle.DARK_DIAGONAL_UP:
				return darkDiagonalUp(pcb);
			case PatternStyle.DARK_CROSS:
				return darkCross(pcb);
			case PatternStyle.DARK_DIAGONAL_CROSS:
				return darkDiagonalCross(pcb);
			case PatternStyle.LIGHT_VERTICAL:
				return lightVertical(pcb);
			case PatternStyle.LIGHT_HORIZONTAL:
				return lightHorizontal(pcb);
			case PatternStyle.LIGHT_DIAGONAL_DOWN:
				return lightDiagonalDown(pcb);
			case PatternStyle.LIGHT_DIAGONAL_UP:
				return lightDiagonalUp(pcb);
			case PatternStyle.LIGHT_CROSS:
				return lightCross(pcb);
			case PatternStyle.LIGHT_DIAGONAL_CROSS:
				return lightDiagonalCross(pcb);
			default:
				System.out.println("run default");
				return null;
		}
	}

	/**
	 * 纯色
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	private static PdfPatternPainter solid(PdfContentByte pcb) {
		return pcb.createPattern(8, 8, null);
	}


	/**
	 * 点线 5%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_5(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);

		painter.rectangle(1.5f*ratio, 1.5f*ratio, width, height);
		painter.rectangle(5.5f*ratio, 5.5f*ratio, width, height);
		painter.fill();

		return painter;
	}


	/**
	 * 点线 10%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_10(PdfContentByte pcb) {
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
	 * 点线 12.5%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_12pt5(PdfContentByte pcb) {
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
	 * 点线 15%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_15(PdfContentByte pcb) {
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
	 * 点线 20%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_20(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);

		painter.fill();
		return painter;
	}

	/**
	 * 点线 25%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_25(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 2*ratio, null);

		painter.rectangle(0f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);

		painter.fill();
		return painter;
	}


	/**
	 * 点线 30%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_30(PdfContentByte pcb) {
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


	/**
	 * 点线 40%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_40(PdfContentByte pcb) {

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

	/**
	 * 点线 45%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_45(PdfContentByte pcb) {

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

	/**
	 * 点线 50%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_50(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(2*ratio, 2*ratio, null);

		painter.rectangle(0f*ratio, 1f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);

		painter.fill();
		return painter;
	}

	/**
	 * 点线 55%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_55(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(2*ratio, 2*ratio, null);

		painter.rectangle(0f*ratio, 1f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);

		painter.fill();
		return painter;
	}


	/**
	 * 点线 60%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_60(PdfContentByte pcb) {
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


	/**
	 * 点线 62.5%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_62pt5(PdfContentByte pcb) {
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


	/**
	 * 点线 65%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_65(PdfContentByte pcb) {
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


	/**
	 * 点线 70%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_70(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 2*ratio, null);

		painter.rectangle(0f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);

		painter.fill();
		return painter;
	}

	/**
	 * 点线 80%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_80(PdfContentByte pcb) {
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
	 * 点线 85%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_85(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(4f*ratio, 1f*ratio, width, height);


		painter.fill();
		return painter;
	}


	/**
	 * 点线 87.5%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_87pt5(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(4f*ratio, 1f*ratio, width, height);


		painter.fill();
		return painter;
	}


	/**
	 * 点线 90%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_90(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);

		painter.rectangle(1.5f*ratio, 1.5f*ratio, width, height);
		painter.rectangle(5.5f*ratio, 5.5f*ratio, width, height);
		painter.fill();

		return painter;
	}

	/**
	 * 点线 35%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_35(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 3f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);

		painter.fill();
		return painter;

	}

	/**
	 * 点线 37.5%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_37pt5(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 3f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);

		painter.fill();
		return painter;

	}

	/**
	 * 点线 75%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_75(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);

		painter.fill();
		return painter;
	}


	/**
	 * 点线 95%
	 * @param pcb PdfContentByte
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter percent_95(PdfContentByte pcb) {
		float ratio=0.75F;

		float width = 1f*ratio;
		float height = 1f*ratio;

		PdfPatternPainter painter = pcb.createPattern(8*ratio, 8*ratio, null);

		painter.rectangle(1.5f*ratio, 1.5f*ratio, width, height);
		painter.rectangle(5.5f*ratio, 5.5f*ratio, width, height);
		painter.fill();

		return painter;
	}



	/**
	 * 浅色棚架
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter lightDiagonalCross(PdfContentByte pcb) {
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


	/**
	 * 深色下斜线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter darkDiagonalDown(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 2f*ratio, width, height);
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 1f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 3f*ratio, width, height);
		painter.fill();

		return painter;
	}
	/**
	 * 深色上斜线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter darkDiagonalUp(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 3f*ratio, width, height);
		painter.fill();

		return painter;
	}


	/**
	 * 深色网格
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter darkCross(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 2f*ratio, width, height);
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(1f*ratio, 3f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 1f*ratio, width, height);
		painter.fill();

		return painter;
	}


	/**
	 * 深色棚架
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter darkDiagonalCross(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.rectangle(0f*ratio, 2f*ratio, width, height);
		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 1f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 3f*ratio, width, height);
		painter.fill();

		return painter;
	}


	/**
	 * 浅色横线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter lightHorizontal(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(1*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);

		painter.fill();

		return painter;
	}


	/**
	 * 浅色竖线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter lightVertical(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 1*ratio, null);

		painter.rectangle(3f*ratio, 0f*ratio, width, height);

		painter.fill();

		return painter;
	}


	/**
	 * 浅色下斜线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter lightDiagonalDown(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 3f*ratio, width, height);
		painter.rectangle(1f*ratio, 2f*ratio, width, height);
		painter.rectangle(2f*ratio, 1f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);

		painter.fill();

		return painter;
	}



	/**
	 * 浅色上斜线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter lightDiagonalUp(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 1f*ratio, width, height);
		painter.rectangle(2f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 3f*ratio, width, height);

		painter.fill();

		return painter;
	}



	/**
	 * 浅色网格
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter lightCross(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.rectangle(1f*ratio, 0f*ratio, width, height);
		painter.rectangle(2f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 1f*ratio, width, height);
		painter.rectangle(3f*ratio, 2f*ratio, width, height);
		painter.rectangle(3f*ratio, 3f*ratio, width, height);

		painter.fill();

		return painter;
	}


	/**
	 * 深色横线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter darkHorizontal(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(1*ratio, 4*ratio, null);

		painter.rectangle(0f*ratio, 0f*ratio, width, height);
		painter.rectangle(0f*ratio, 1f*ratio, width, height);

		painter.fill();
		return painter;
	}

	/**
	 * 深色竖线
	 * @param pcb pcb
	 * @return PdfPatternPainter
	 */
	public static PdfPatternPainter darkVertical(PdfContentByte pcb) {
		float ratio=0.75F;
		float width = 1f*ratio;
		float height = 1f*ratio;
		PdfPatternPainter painter = pcb.createPattern(4*ratio, 1*ratio, null);

		painter.rectangle(2f*ratio, 0f*ratio, width, height);
		painter.rectangle(3f*ratio, 0f*ratio, width, height);

		painter.fill();
		return painter;
	}




}

	
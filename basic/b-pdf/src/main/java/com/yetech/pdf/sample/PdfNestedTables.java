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

public class PdfNestedTables {


	public static void main(String[] args) {

		String fileName = "/Users/weizhao/Code/qwz/qwz-solution/solution-yet/yet-pdf/pdf-demo/src/test/resources/out/" + System.currentTimeMillis() + ".pdf";
		sample(fileName);

	}


	public static void sample(String fileName) {

		try {
			Document document = new Document(PageSize.A4);
//			document.setMargins(70, 70, 20, 10);
			PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));
			Font font = getFont();

			HeaderFooter footer = new HeaderFooter(new Phrase("页码：",font), true);
			footer.setAlignment(HeaderFooter.ALIGN_CENTER);
			footer.setBorder(Rectangle.NO_BORDER);
			document.setFooter(footer);
			document.open();
			// Creating a table
//			float [] pointColumnWidths1 = {150f, 150f};
			int pointColumnWidths1 = 7;
			Table table = new Table(pointColumnWidths1);

			// Populating row 1 and adding it to the table
			Cell cell1 = new Cell();
			cell1.add(new Chunk("Name"));
			table.addCell(cell1);

			Cell cell2 = new Cell();
			cell2.add(new Chunk("Raju"));
			table.setPadding(5);
			table.setSpacing(5);
			table.addCell(cell2);

			// Populating row 2 and adding it to the table
			Cell cell3 = new Cell();
			cell3.add(new Chunk("Id"));
			table.addCell(cell3);

			Cell cell4 = new Cell();
			cell4.add(new Chunk("1001"));
			table.addCell(cell4);

			// Populating row 3 and adding it to the table
			Cell cell5 = new Cell();
			cell5.add(new Chunk("Designation"));
			table.addCell(cell5);

			Cell cell6 = new Cell();
			cell6.add(new Chunk("Programmer"));
			table.addCell(cell6);

			// Creating nested table for contact
//			float [] pointColumnWidths2 = {150f, 150f};
			int pointColumnWidths2 = 7;
			Table nestedTable = new Table(pointColumnWidths2);
			// Populating row 1 and adding it to the nested table
			Cell nested1 = new Cell();
			nested1.add(new Chunk("Phone"));
			nestedTable.setPadding(5);
			nestedTable.setSpacing(5);
			nestedTable.addCell(nested1);

			Cell nested2 = new Cell();
			nested2.add(new Chunk("9848022338"));
			nestedTable.setPadding(5);
			nestedTable.setSpacing(5);
			nestedTable.addCell(nested2);

			// Populating row 2 and adding it to the nested table
			Cell nested3 = new Cell();
			nested3.add(new Chunk("email"));
			nestedTable.setPadding(5);
			nestedTable.setSpacing(5);
			nestedTable.addCell(nested3);

			Cell nested4 = new Cell();
			nested4.add(new Chunk("Raju123@gmail.com"));
			nestedTable.addCell(nested4);

			// Populating row 3 and adding it to the nested table
			Cell nested5 = new Cell();
			nested5.add(new Chunk("Address"));
			nestedTable.setPadding(5);
			nestedTable.setSpacing(5);
			nestedTable.addCell(nested5);

			Cell nested6 = new Cell();
			nested6.add(new Chunk("Hyderabad"));
			nestedTable.setPadding(5);
			nestedTable.setSpacing(5);
			nestedTable.addCell(nested6);

			// Adding table to the cell
			Cell cell7 = new Cell();
			cell7.add(new Chunk("Contact"));
			nestedTable.setPadding(5);
			nestedTable.setSpacing(5);
			table.addCell(cell7);

			Cell cell8 = new Cell();
			cell8.add(nestedTable);
			table.addCell(cell8);

			// Adding table to the document
			document.add(table);

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

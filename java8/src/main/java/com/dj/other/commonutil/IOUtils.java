package com.dj.other.commonutil;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class IOUtils {
	@Test
	public void testIOUtils() throws Exception{
		String filePath = "D:"+File.separator+"createSamplePDF.pdf";
		// 第一步 创建文档实例
		Document document = new Document();  
		// 第二步 获取PdfWriter实例
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));  
		// 第三步 打开文档  
		document.open();  
		// 第四步 添加中文,创建了字体之后就可以写入中文
		String fontPath = "C:/WINDOWS/Fonts/SIMYOU.TTF";
		BaseFont bf = BaseFont.createFont(fontPath,BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font secFont = new Font(bf, 20, Font.NORMAL, new BaseColor(0,0,0));
		document.add(new Paragraph("写入中文", secFont));//写入内容　　　　　　
		// 第五部 操作完成后必须执行文档关闭操作。
		document.close();  
	}
}

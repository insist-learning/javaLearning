package com.dj.other.pdf;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPDF {
	
	private String filePath = "D:"+File.separator+"createSamplePDF.pdf";
	public static void main(String[] args) throws Exception {
		
		
		String filePath = "D:"+File.separator+"createSamplePDF.pdf";
		// 第一步 创建文档实例
		Document document = new Document();  
		// 第二步 获取PdfWriter实例
		PdfWriter.getInstance(document, new FileOutputStream(filePath));  
		// 第三步 打开文档  
		document.open();  
		// 第四步 添加段落内容
		document.add(new Paragraph("Hello World"));  
		// 第五部 操作完成后必须执行文档关闭操作。
		document.close();  
	}
	
	/**
	 * 自定义页面大小使用
	 * @throws Exception
	 */
	@Test
	public void customPagSize() throws Exception {
		// 自定义页面大小使用
//        Rectangle pagesize = new Rectangle(216f, 720f);
//		Rectangle pagesize = new Rectangle(14400, 14400); // 最大
//		Document document = new Document(pagesize);  
		// 第一步 创建文档实例
//		Document document = new Document(PageSize.LETTER);  //纸张大小、
		Document document = new Document(PageSize.LETTER.rotate()); //横向，也可以通过宽度，高度去变成横向
		// 第二步 获取PdfWriter实例
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));  
		// 第三步 打开文档  
		writer.setUserunit(75000f);
		document.open();  
		// 第四步 添加段落内容
		document.add(new Paragraph("Hello World"));  
		// 第五部 操作完成后必须执行文档关闭操作。
		document.close();  
		System.out.println("success");
	}
	
	/**
	 * 设置页边距，多页
	 */
	@Test
	public void testMargin() throws Exception {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        // setting page size, margins and mirrered margins
        document.setPageSize(PageSize.A5);
        document.setMargins(36, 72, 108, 180);
        document.setMarginMirroringTopBottom(true);
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph(
            "The left margin of this odd page is 36pt (0.5 inch); " +
            "the right margin 72pt (1 inch); " +
            "the top margin 108pt (1.5 inch); " +
            "the bottom margin 180pt (2.5 inch)."));
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        for (int i = 0; i < 20; i++) {
            paragraph.add("Hello World! Hello People! " +
                "Hello Sky! Hello Sun! Hello Moon! Hello Stars!");
        }
        document.add(paragraph);
        document.add(new Paragraph("The top margin 180pt (2.5 inch)."));
        document.close();
	}
	
	
	
	
	
	
	/**
	 * 使用图片模板整合文字
	 * @throws Exception 
	 */
	@Test
	public void testPDFUtil() throws Exception {
		String imagePath = "D:\\dsspplatform\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\cxh\\pc\\temp\\products\\001.jpg";
		PDFUtil pdfUtil = new PDFUtil();
		pdfUtil.openDocumnet(filePath)
				.addImage(imagePath, 0, 400)
				.addDateContent(330,462,null)
				.addContent("张三",85,655,null)
				.close();
	}
	
	/**
	 * 简单写入文字
	 */
	@Test
	public void wirteFontWithIndex() throws Exception {
		
		
		
		
		
		String filePath = "D:"+File.separator+"createSamplePDF.pdf";
		// 第一步 创建文档实例
		Document document = new Document();  
		// 第二步 获取PdfWriter实例
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));  
		// 第三步 打开文档  
		document.open();  
		// 第四步 添加段落内容
		PdfContentByte canvas = writer.getDirectContent();
		String fontPath = "C:/WINDOWS/Fonts/SIMYOU.TTF";
		//创建字段
		BaseFont bf = BaseFont.createFont(fontPath,BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font secFont = new Font(bf, 20, Font.NORMAL, new BaseColor(255,51,0));
		//设置方位
		Phrase certificateContentPhrase = new Phrase("写入中文", secFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, certificateContentPhrase, 330,462, 0);
		// 第五部 操作完成后必须执行文档关闭操作。
		document.close();  
	}
	
	
	
	@Test
	public void wirteFont() throws Exception {
		
		
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

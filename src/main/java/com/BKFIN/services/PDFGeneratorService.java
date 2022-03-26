package com.BKFIN.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Product;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lowagie.text.*;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
@Service
public class PDFGeneratorService {
	
  
	
	//private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
	//public static void generateQRCodeImage(String text, int width, int height, String filePath)
      //      throws IOException, WriterException {
        //QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

    //Path path = FileSystems.getDefault().getPath(filePath);
      //  MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
       
	//}
	 private static Logger logger = LoggerFactory.getLogger(PDFGeneratorService.class);

	  public static ByteArrayInputStream employeePDFReport
	    (List<Product> products) {
	    Document document = new Document();
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	  
	    try {

	      PdfWriter.getInstance(document, out);
	      document.open();
	    
	      // Add Text to PDF file ->
	      Font font = FontFactory.getFont(FontFactory.COURIER, 14,
	        BaseColor.BLACK);
	      Paragraph para = new Paragraph("Product Table", font);
	      para.setAlignment(Element.ALIGN_CENTER);
	      document.add(para);
	      document.add(Chunk.NEWLINE);

	      PdfPTable table = new PdfPTable(4);
	      // Add PDF Table Header ->
	      Stream.of("Id","Nom Produit", "Prix Produit", "Nom Partenaire").forEach(headerTitle ->
	      {
	        PdfPCell header = new PdfPCell();
	        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setHorizontalAlignment(Element.ALIGN_CENTER);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(headerTitle, headFont));
	        table.addCell(header);
	      });

	      for (Product p : products) {
	        PdfPCell idCell = new PdfPCell(new Phrase((String.valueOf(p.getIdProduct()))));
	        idCell.setPaddingLeft(4);
	        idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(idCell);

	        PdfPCell Name = new PdfPCell(new Phrase
	          (p.getNameProduct()));
	        Name.setPaddingLeft(4);
	        Name.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        Name.setHorizontalAlignment(Element.ALIGN_LEFT);
	        table.addCell(Name);

	        PdfPCell Prix = new PdfPCell(new Phrase
	          (String.valueOf(p.getValueProduct())));
	        Prix.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        Prix.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        Prix.setPaddingRight(4);
	        table.addCell(Prix);

	        PdfPCell Partenaire= new PdfPCell(new Phrase
	          (String.valueOf(p.getPartner_product().getNamePartner())));
	        Partenaire.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        Partenaire.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        Partenaire.setPaddingRight(4);
	        table.addCell(Partenaire);
	      }
	      document.add(table);

	      document.close();
	    } catch (DocumentException e) {
	      logger.error(e.toString());
	    } 
	    

	    return new ByteArrayInputStream(out.toByteArray());
}
}

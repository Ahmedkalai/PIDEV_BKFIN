package com.BKFIN.services;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import com.BKFIN.entities.Account;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class AccountPdfExporter {
	
	
	Account acc ; 
	public AccountPdfExporter(Account acc) {
        this.acc = acc;
    }
 
	private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Rib", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("solde", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("typeAccount", font));
	        table.addCell(cell);
	        //cell.setPhrase(new Phrase("openDate", font));
	        //table.addCell(cell);
	         
	       
	    }
	     
	    private void writeTableData(PdfPTable table) {
	    	    
	    	    table.addCell(acc.getRib());
	            table.addCell(String.valueOf(acc.getSold()));
	            table.addCell(acc.getTypeAccount().toString());
	          /*  
	            String pattern = "yyyy-MM-dd";
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	            table.addCell (simpleDateFormat.format(acc.getOpenDate())) ;
	            */
	        
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException , IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("bank account identification ", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(3);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {3f, 1.5f, 2f});
	        table.setSpacingBefore(15);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}

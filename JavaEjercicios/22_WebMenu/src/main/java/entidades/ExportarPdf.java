package entidades;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class ExportarPdf {
	
	private List<Coche> listaCoches;
	
	public ExportarPdf(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	
	public void escribirCabezera(PdfPTable pdfTable) {
		PdfPCell cell = new PdfPCell();	
		cell.setBackgroundColor(Color.darkGray);
		cell.setPadding(6);
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.white);
		
		cell.setPhrase(new Phrase("ID", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Matricula", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Marca", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Modelo", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Kilometros", font));
		pdfTable.addCell(cell);
	}
	
	public void escribirCuerpo(PdfPTable pdfTable) {
		
		for(Coche coche: this.listaCoches) {
			pdfTable.addCell(String.valueOf(coche.getId()));
			pdfTable.addCell(coche.getMatricula());
			pdfTable.addCell(coche.getMarca());
			pdfTable.addCell(coche.getModelo());
			pdfTable.addCell(String.valueOf(coche.getKilometros()));
		}
	}
		
	public void exportar(){
		try(Document document = new Document(PageSize.A4)){
			
			FileOutputStream ficheroPdf = new FileOutputStream("ListaCoches.pdf");
			PdfWriter.getInstance(document,ficheroPdf).setInitialLeading(20);
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.HELVETICA);
			font.setSize (20);
			font.setColor (Color.BLUE);
	        Paragraph paragraph = new Paragraph("Lista de Coches",font);
	        paragraph.setAlignment (Paragraph.ALIGN_CENTER);
	        document.add (paragraph);
	      
	        PdfPTable pdfPTable = new PdfPTable(5);
	        pdfPTable.setWidthPercentage(100f);
	        pdfPTable.setWidths (new float []{1.5f,2.5f,2.5f,2.5f,2.5f});  
	        pdfPTable.setSpacingBefore (10);
	        
	        escribirCabezera(pdfPTable);
	        escribirCuerpo(pdfPTable);
	        document.add(pdfPTable);
	        document.close();
	        System.out.println("Fichero PDF creado");
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
			

}

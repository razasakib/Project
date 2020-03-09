package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.WhuserType;

public class WhUserTypePdflView  extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=whuser.pdf");

		Paragraph paragraph=new Paragraph("Welcome To WhUser Data");
		document.add(paragraph);

		@SuppressWarnings("unchecked")
		List<WhuserType> list= (List<WhuserType>) model.get("list");

		//creating Table

		PdfPTable p=new PdfPTable(8);
		p.addCell("ID");
		p.addCell("User Type");
		p.addCell("Code");
		p.addCell("Use For");
		p.addCell("Email");
		p.addCell("Contact");
		p.addCell("Id Type");
		p.addCell("Id No"); 
		

		for(WhuserType wt:list) {
			p.addCell(wt.getWhuId().toString());
			p.addCell(wt.getWhuserTyp());
			p.addCell(wt.getWhuCode());
			p.addCell(wt.getWhusefor());
			p.addCell(wt.getWhuEmail());
			p.addCell(wt.getWhucont());
			p.addCell(wt.getWhuIdType());
			p.addCell(wt.getWhuIdNo());
		} 

		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}
}

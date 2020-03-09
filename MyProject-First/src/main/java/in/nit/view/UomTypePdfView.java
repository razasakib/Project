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

import in.nit.model.UomType;


public class UomTypePdfView  extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=UomType.pdf");

		Paragraph paragraph=new Paragraph("Welcome To Uom Type Data");
		document.add(paragraph);

		@SuppressWarnings("unchecked")
		List<UomType> list= (List<UomType>) model.get("list");

		//creating Table

		PdfPTable p=new PdfPTable(4);
		p.addCell("ID");
		p.addCell("TYPE");
		p.addCell("MODEL");
		p.addCell("NOTE");
		

		for(UomType st:list) {
			p.addCell(st.getUomId().toString());
			p.addCell(st.getUomType());
			p.addCell(st.getUomModel());
			p.addCell(st.getUomDesc());
		} 

		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}
}

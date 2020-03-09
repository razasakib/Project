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

import in.nit.model.ShipmentType;

public class ShipmentTypeTypePdfView  extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=ShipmentType.pdf");

		Paragraph paragraph=new Paragraph("Welcome To ShipMent Data");
		document.add(paragraph);

		@SuppressWarnings("unchecked")
		List<ShipmentType> list= (List<ShipmentType>) model.get("list");

		//creating Table

		PdfPTable p=new PdfPTable(6);
		p.addCell("ID");
		p.addCell("MODE");
		p.addCell("Code");
		p.addCell("ENABLE SHIP");
		p.addCell("GRADE");
		p.addCell("NOTE");
		

		for(ShipmentType st:list) {
			p.addCell(st.getShipId().toString());
			p.addCell(st.getShipMod());
			p.addCell(st.getShipCode());
			p.addCell(st.getEnbShip());
			p.addCell(st.getShipGrd());
			p.addCell(st.getShipDesc());
		} 

		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}
}

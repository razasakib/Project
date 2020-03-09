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

import in.nit.model.OrderMethodType;

public class OrderTypePdfView  extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=OrderType.pdf");

		Paragraph paragraph=new Paragraph("Welcome To OrderType Data");
		document.add(paragraph);

		@SuppressWarnings("unchecked")
		List<OrderMethodType> list= (List<OrderMethodType>) model.get("list");

		//creating Table

		PdfPTable p=new PdfPTable(5);
		p.addCell("ID");
		p.addCell("MODE");
		p.addCell("Code");
		p.addCell("Method");
		p.addCell("NOTE");
		//	p.addCell("GRADE");
		

		for(OrderMethodType st:list) {
			p.addCell(st.getOrderId().toString());
			p.addCell(st.getOrderMode());
			p.addCell(st.getOrderCode());
			p.addCell(st.getOrderMeth());
			//p.addCell(st.getOrderAccept());
			p.addCell(st.getOrderDesc());
		} 

		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}
}

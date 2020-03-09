package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.OrderMethodType;


public class OrderTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=OrderType.xls");


		Sheet s=workbook.createSheet("Order");

		//constructiong row
		setHeader(s);

		//read Model data

		@SuppressWarnings("unchecked")
		List<OrderMethodType> list=(List<OrderMethodType>) model.get("list");

		setBody(s,list);

	}

	private void setHeader(Sheet s) {

		Row r=s.createRow(0);

		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("Method");
	//	r.createCell(4).setCellValue("GRADE");
		r.createCell(4).setCellValue("NOTE");


	}

	private void setBody(Sheet s,List<OrderMethodType> list) {
		int count=1;

		for(OrderMethodType st:list) {
			Row r= s.createRow(count++);
			r.createCell(0).setCellValue(st.getOrderId());
			r.createCell(1).setCellValue(st.getOrderMode());
			r.createCell(2).setCellValue(st.getOrderCode());
			r.createCell(3).setCellValue(st.getOrderMeth());
			//r.createCell(3).setCellValue(st.getOrderAccept());
			r.createCell(4).setCellValue(st.getOrderDesc());
		}

	}
}

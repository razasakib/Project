package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.UomType;



public class UomTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=Uom.xls");


		Sheet s=workbook.createSheet("uom");

		//constructiong row
		setHeader(s);

		//read Model data

		@SuppressWarnings("unchecked")
		List<UomType> list=(List<UomType>) model.get("list");

		setBody(s,list);

	}

	private void setHeader(Sheet s) {

		Row r=s.createRow(0);

		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(4).setCellValue("NOTE");


	}

	private void setBody(Sheet s,List<UomType> list) {
		int count=1;

		for(UomType st:list) {
			Row r= s.createRow(count++);
			r.createCell(0).setCellValue(st.getUomId().toString());
			r.createCell(1).setCellValue(st.getUomType());
			r.createCell(2).setCellValue(st.getUomModel());
			r.createCell(3).setCellValue(st.getUomDesc());
		}

	}
}

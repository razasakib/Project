package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.WhuserType;


public class WhUserTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=WhUserType.xlsx");


		Sheet s=workbook.createSheet("WhuserType");

		//constructiong row
		setHeader(s);

		//read Model data

		@SuppressWarnings("unchecked")
		List<WhuserType> list=(List<WhuserType>) model.get("list");

		setBody(s,list);

	}

	private void setHeader(Sheet s) {

		Row r=s.createRow(0);

		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("USER TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USE FOR");
		r.createCell(4).setCellValue("EMAIL ");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("ID TYPE");
		r.createCell(7).setCellValue("ID NO");


	}

	private void setBody(Sheet s,List<WhuserType> list) {
		int count=1;

		for(WhuserType wt:list) {
			Row r= s.createRow(count++);
			r.createCell(0).setCellValue(wt.getWhuId());
			r.createCell(1).setCellValue(wt.getWhuserTyp());
			r.createCell(2).setCellValue(wt.getWhuCode());
			r.createCell(3).setCellValue(wt.getWhusefor());
			r.createCell(4).setCellValue(wt.getWhuEmail());
			r.createCell(5).setCellValue(wt.getWhucont());
			r.createCell(6).setCellValue(wt.getWhuIdType());
			r.createCell(7).setCellValue(wt.getWhuIdNo());
		}

	}
}

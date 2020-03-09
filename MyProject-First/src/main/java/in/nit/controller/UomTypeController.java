package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.UomType;
import in.nit.service.IUomTypeService;
import in.nit.util.UomTypeUtil;
import in.nit.view.UomTypeExcelView;
import in.nit.view.UomTypePdfView;

@Controller
@RequestMapping({"/uom"})
public class UomTypeController {
	@Autowired
	private IUomTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomTypeUtil util;
	@RequestMapping("/home")
	public String uomHome(Model model) {

		model.addAttribute("uomType", new UomType());
		return "UomRegister";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveUomType(@ModelAttribute UomType uomType,
			Model model) {
		int id=	service.saveUomType(uomType);
		StringBuffer msg =new StringBuffer("Data save successfully").append("	The Genereted is=:").append(id);
		model.addAttribute("message", msg);


		return "UomRegister";
	}
	@RequestMapping("/all")
	public String getAllUomType(Model model) {

		List<UomType> list=service.getAllUomType();
		model.addAttribute("data",list);

		return "UomTypeData";

	}
	@RequestMapping("/delete")
	public String deleteUomType(@RequestParam ("uid") Integer id,
			Model model) {
		service.deleteUomType(id);
		String msg= +id+" No record deleted";
		model.addAttribute("message",msg);
		List<UomType> list=service.getAllUomType();
		model.addAttribute("data",list);

		return "UomTypeData";
	}





	@RequestMapping("/edit")
	public String editUomType(@RequestParam ("uid")Integer uid,Model model) {
		UomType UomType=service.getOneUomType(uid);
		model.addAttribute("uomType",UomType);
		return "UomTypeEdit";
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateUomType(@ModelAttribute UomType uomType, Model model) {
		service.updateUomType(uomType);

		String message="Record Updated Suucesfully";
		List<UomType> list=service.getAllUomType();
		model.addAttribute("message",message);
		model.addAttribute("data",list);

		return "UomTypeData";
	}
	@RequestMapping("/view")
	public String showUomType(@RequestParam ("uid") Integer uid,Model model) {

		UomType UomType= service.getOneUomType(uid);

		model.addAttribute("uomType",UomType);
		return "UomTypeView";

	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam (value = "uid",required = false) Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new UomTypeExcelView());
		if(id==null) {

			//fetching data from db

			List<UomType> list=service.getAllUomType();
			mav.addObject("list", list);
		}
		else {

			UomType wt =service.getOneUomType(id);
			mav.addObject("list", Arrays.asList(wt));
		}
		return mav;
	}
	@RequestMapping("/pdf")
	public  ModelAndView showPdf(@RequestParam(name = "uid",required = false)Integer id) {

		ModelAndView mav=new ModelAndView();
		mav.setView(new UomTypePdfView());
		if(id==null) {


			List<UomType> list=service.getAllUomType();
			mav.addObject("list", list);
		}
		else {
			UomType wt=service.getOneUomType(id);
			mav.addObject("list", Arrays.asList(wt));
		}

		return mav;
	}
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getUomTypePackingCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBarChart(path, list);

		return "UomCharts";
	}


}

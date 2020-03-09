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

import in.nit.model.WhuserType;
import in.nit.service.IWhuserTypeService;
import in.nit.util.WhuserTypeUtil;
import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdflView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhuserTypeService service;
	@Autowired
	private WhuserTypeUtil util;
	@Autowired
	private ServletContext context;
	

	// url for Display Register Home Page
	@RequestMapping("/show")
	public String showWhUserType(Model model) {
		model.addAttribute("whuserType",new WhuserType()); 
		return "WhUserTypeRegister";
	}

	// url for Accepting Save request and save Data in Db
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute WhuserType WhuserType,Model model) { 
		Integer id=service.saveWhuserType(WhuserType);

		String message="Record is update And Genereted Id is:"+id;

		model.addAttribute("message",message);

		return "WhUserTypeRegister";
	}
	@RequestMapping("/all")
	public String showAllWhUser(Model model) {
		List<WhuserType> list=service.getAllWhuserType();
		model.addAttribute("list",list);
		return "WhuserData";
	}

	// for delete url on base of id
	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam ("wid") Integer wid,
			Model model) {
		service.deleteWhuserType(wid);
		String message="Succesfull Deleted";
		model.addAttribute("message",message);
		List<WhuserType> list=service.getAllWhuserType();
		model.addAttribute("list",list);
		return "WhuserData";
	}
	@RequestMapping("/edit")
	public String editWhUserType(@RequestParam ("wid")Integer wid,Model model) {
		WhuserType whuserType=service.getOneWhuser(wid);
		model.addAttribute("whuserType",whuserType);
		return "WhUserTypeEdit";
	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateWhUserType(@ModelAttribute WhuserType whuserType, Model model) {
		service.updateWhuserType(whuserType);

		String message="Record Updated Suucesfully";
		List<WhuserType> list=service.getAllWhuserType();
		model.addAttribute("message",message);
		model.addAttribute("list",list);

		return "WhuserData";
	}
	@RequestMapping("/view")
	public String showWhuserType(@RequestParam ("wid") Integer wid,Model model) {

		WhuserType whuserType= service.getOneWhuser(wid);

		model.addAttribute("whuserType",whuserType);
		return "WhUserTypeView";

	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam (value = "id",required = false) Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypeExcelView());
		if(id==null) {

			//fetching data from db

			List<WhuserType> list=service.getAllWhuserType();
			mav.addObject("list", list);
		}
		else {

			WhuserType wt =service.getOneWhuser(id);
			mav.addObject("list", Arrays.asList(wt));
		}
		return mav;
	}
	@RequestMapping("/pdf")
	public  ModelAndView showPdf(@RequestParam("id") Integer id) {

		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypePdflView());
		if(id==null) {


			List<WhuserType> list=service.getAllWhuserType();
			mav.addObject("list", list);
		}
		else {
			WhuserType wt=service.getOneWhuser(id);
			mav.addObject("list", Arrays.asList(wt));
		}

		return mav;
	}
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getWhuserTypeUseForCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBarChart(path, list);

		return "WhuserCharts";
	}

}
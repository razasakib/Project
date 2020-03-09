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

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypeTypePdfView;

@Controller
@RequestMapping("/ship")
public class ShipmentTypeServiceController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeUtil util;
	@Autowired
	private ServletContext context;

	@RequestMapping("/show")
	public String showShipemntType(Model model) {
		
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	
	
	@RequestMapping(value = "/saveship",method = RequestMethod.POST)
public String saveShipment(@ModelAttribute ShipmentType shipMentType,
							Model  model) {
		
		Integer id=service.saveShipemntType(shipMentType);
		model.addAttribute("id",id);
		
	return "ShipmentTypeRegister";
}
	
	
	
	
	@RequestMapping("/all")
	public String getAllShipmentType(Model model) {
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	
	
	
	
	@RequestMapping("/delete")
	public String deleteShipment(
			@RequestParam("sid") Integer id,
			Model model) {
		
		service.deleteShipmentType(id);
		String message=id+" deleted";
		model.addAttribute("message",message);
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		
		return "ShipmentTypeData";
	}
	
	
	@RequestMapping("/edit")
	public String editShipmentType(@RequestParam ("sid")Integer id,Model model) {
		ShipmentType shipmentType=service.getOneShipmentType(id);
		model.addAttribute("shipmentType", shipmentType);
		return "ShipmentTypeEdit";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		service.updateShipmentType(shipmentType);
		String message=+shipmentType.getShipId()+"is updated";
		model.addAttribute("message", message);
		
		return "ShipmentTypeEdit";
	}
	
	@RequestMapping("/viewone")
	public String viewOneShipmentType(@RequestParam ("sid")Integer id,Model model) {
		
		ShipmentType shipmentType=service.getOneShipmentType(id);
		model.addAttribute("shipmentType", shipmentType);
		
		return "ShipmentTypeView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam (value = "sid",required = false) Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new ShipmentTypeExcelView());
		if(id==null) {

			//fetching data from db

			List<ShipmentType> list=service.getAllShipmentType();
			mav.addObject("list", list);
		}
		else {

			ShipmentType st =service.getOneShipmentType(id);
			mav.addObject("list", Arrays.asList(st));
		}
		return mav;
	}
	@RequestMapping("/pdf")
	public  ModelAndView showPdf(@RequestParam(value = "sid",required = false) Integer id) {

		ModelAndView mav=new ModelAndView();
		mav.setView(new ShipmentTypeTypePdfView());
		if(id==null) {


			List<ShipmentType> list=service.getAllShipmentType();
			mav.addObject("list", list);
		}
		else {
			ShipmentType st=service.getOneShipmentType(id);
			mav.addObject("list", Arrays.asList(st));
		}

		return mav;
	}
	
	@RequestMapping("/charts")
		public String showCharts() {
	List<Object[]> list=service.getShipmentModeCount();
	String path=context.getRealPath("/");
	util.generatePie(path, list);
	util.generateBarChart(path, list);
		
		return "ShipmentCharts";
	}
	
}

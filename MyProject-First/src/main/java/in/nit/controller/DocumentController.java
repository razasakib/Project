package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private IDocumentService service;

	@RequestMapping("/show")
	public String showUploadPage() {

		return "DocumentShow";
	}
	
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)	
	public String doUplaod(@RequestParam Integer fileId,
			@RequestParam CommonsMultipartFile fileOb, Model model) {
		
		if(fileOb!=null) {
	
			Document doc=new Document();
			
			doc.setFileId(fileId);
			doc.setFname(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			service.saveDocument(doc);
			String message=fileId+" is Uplaoded";
			model.addAttribute("message", message);
		}
		return "DocumentShow";
	}



}

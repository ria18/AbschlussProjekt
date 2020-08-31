package com.tqg.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.tqg.model.Lizenz;
import com.tqg.service.LizenzService;
import com.tqg.validator.UserFormValidator;

@Controller
public class LizenzController {


	
	@Autowired
	private SessionFactory sessionFactory;

	public LizenzController() {
		System.out.println(" LizenzController()");
		
	}

	@Autowired
	private LizenzService lizenzService;
	
	 UserFormValidator userFormValidator ;
	 
	/*
	 * Call Manage License   
	 */
	@RequestMapping(value = "/adminPage")
	public ModelAndView whenUserCallAdminPage(ModelAndView model) throws IOException {
	
		List<Lizenz> listLizenz = lizenzService.getAllLizenzs();
		model.addObject("listLizenz", listLizenz);
		model.addObject("title", "Lizenz Verwalten");
		model.addObject("userClickAdminPage", true);
		model.setViewName("page");
		return model;
	}
	
	/*
	 * Call index or home 
	 */
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView whenUserCallHomeOrIndex( Lizenz lizenz) {
	
		ModelAndView model = new ModelAndView("page");
		List<Lizenz> listLizenz = lizenzService.getAllLizenzs();
		model.addObject("listLizenz", listLizenz);
		model.addObject("title", "Hauptseite");
		model.addObject("userClickHome", true);
		
		
		
		return model;
	}
	

	
	/*
	 * Create new license Just from Manage License  
	 */

	@RequestMapping(value = {"/adminPage/newLizenz"}, method = RequestMethod.GET)
	public ModelAndView addLizenz(ModelAndView model) {
		Lizenz lizenz = new Lizenz();
		model.addObject("lizenz", lizenz);
		model.setViewName("LizenzForm");
		return model;
	}
	/*
	 * Save license into Database with Validition 
	 */
	@RequestMapping(value = { "/saveLizenz", "/adminPage/saveLizenz" }, method = RequestMethod.POST)
	public ModelAndView saveLizenz(@Valid Lizenz lizenz, BindingResult result, Model model, final RedirectAttributes redirectAttributes)
	{
		userFormValidator = new UserFormValidator();
	      
	      if(result.hasErrors()){
	    	  model.addAttribute("userClickAdminPage", true);
	    	  model.addAttribute("title", "Lizenz Verwalten");
	    	  
	    	     return  new ModelAndView("page");
	    	 
	      }
	      
	       if (lizenz.getId() == 0 ) { 
	     		
	 			lizenzService.addLizenz(lizenz);
	 			
	 			if(lizenz.isNew()) {
	 			redirectAttributes.addFlashAttribute("addMsg", "new Lizenz Added successfully");
	 				
	 				return new ModelAndView("redirect:/adminPage/newLizenz");
	 			}
	 			
	         } else {
	        	  redirectAttributes.addFlashAttribute("addMsg", "Lizenz updated successfully!");
	 			lizenzService.updateLizenz(lizenz);
	 		     
	 		}
	       return new ModelAndView("redirect:/adminPage");
	     
		
	}

	/*
	 *  Delete license just called from Manage License
	 */
	
	@RequestMapping(value = {"adminPage/deleteLizenz"}, method = RequestMethod.GET)
	public ModelAndView deleteLizenz(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		int lizenzId = Integer.parseInt(request.getParameter("id"));
		
		lizenzService.deleteLizenz(lizenzId);
		
		redirectAttributes.addFlashAttribute("delMsg", "License is deleted successfully!");
		return new ModelAndView("redirect:/adminPage");
	}
	
	// This method will be called on form submission, handling GET request for
    // updating License just called from Manage License. 
	@RequestMapping(value = {"adminPage/editLizenz"}, method = RequestMethod.GET)
	public ModelAndView updateLizenz(HttpServletRequest request) {
		
		int lizenzId = Integer.parseInt(request.getParameter("id"));
		
		Lizenz lizenz = lizenzService.getLizenzById(lizenzId);
		
		ModelAndView model = new ModelAndView("LizenzForm");
		model.addObject("lizenz", lizenz);
		

		return model;
	}  
	


	
	@ResponseBody
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getDownloadData(Map<String,String> result) throws Exception {
		
	    String regData = "---- LCM License - \n\n";  
	    
	 Iterator<Entry<String, String>> it = result.entrySet().iterator();
		 
		 while (it.hasNext())
		 {
 			 Entry<String, String> cur = it.next();
			 regData += "Update lizenz SET lizenzName='"+ cur.getKey() + "'lizenzKey='"+ cur.getValue() +"'\r\n";	
		 }
	    
	    
	    byte[] output = regData.getBytes();

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("charset", "utf-8");
	    responseHeaders.setContentType(MediaType.valueOf("text/html"));
	    responseHeaders.setContentLength(output.length);
	    responseHeaders.set("Content-disposition", "attachment; filename=lizenz.sql");

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}
	
	
//	@ResponseBody
//	@RequestMapping("/result")
	
//	public String getCheckBoxValues(@RequestParam Map<String,String> reqParam) throws Exception {
//		
//
//		 String selectedCheckBox = null;
//		
//		 String name  = reqParam.get("lizenzName");
//        String key = reqParam.get("lizenzKey");
//       
//        System.out.println("Name: "+name + "\n" + "Key "+key);
//        
//       
//		selectedCheckBox = "Update lizenz SET lizenzName='"+ name + "'lizenzKey='"+ key +"'";	
//	
//		System.out.println("check: "+ selectedCheckBox );
//		
//		return selectedCheckBox;
//	}
//	
	@ResponseBody
	@RequestMapping("/result")
	public String getCheckBoxValues(@RequestParam Map<String,String> reqParam) throws Exception {
		

		 String selectedCheckBox = "-- LCM Licence\r\n";
		
		 Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
		 
		 while (it.hasNext())
		 {
 			 Entry<String, String> cur = it.next();
			 System.out.println("Key"+cur.getKey() + cur.getValue());
			 selectedCheckBox += "Update lizenz SET lizenzName='"+ cur.getKey() + "'lizenzKey='"+ cur.getValue() +"'\r\n";	
		 }
	

		 System.out.println("mapsize: " + reqParam.size());
		 
		 System.out.println("check: "+ selectedCheckBox );
		
		 return selectedCheckBox;
	}
	

	

	
}
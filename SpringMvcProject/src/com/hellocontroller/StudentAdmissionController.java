package com.hellocontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView getAdmission() {
		ModelAndView modelandview = new ModelAndView("AdmissionForm");
		//modelandview.addObject("headermsg","Service college ingenieur ");
		
		return modelandview;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		//binder.setDisallowedFields(new String[]{"studentMobile"}); das ist um studentenMobile binding zu igorieren
		SimpleDateFormat dateformat= new SimpleDateFormat("dd.MM.yyyy");
		binder.registerCustomEditor(Date.class, "studentDOB",new CustomDateEditor(dateformat, false));
		binder.registerCustomEditor(String.class, "studentName",new StudentNameEditor());
	
	}
	@ModelAttribute
	public void addingCommonObject(Model model1){
		model1.addAttribute("headermsg"," IT Service  Engineer ");
		
		
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
   public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1, BindingResult result/*@RequestParam(value="studentName", defaultValue="Anonym") String name, @RequestParam(value="studentHobbys", defaultValue="nothing") String hobbys*/){
		//!! Binding result will catch for us all the binding(convert error) und saved on variable result !!!
		
		
		/*Student student1=new Student();
		student1.setStudentName(name);
		student1.setStudentHobbys(hobbys);
		avec le modelattribute on a plus besoins de requestparametre, elle va nous recuperer toute les information de formulaire
		et l inserer dans l instance de student , et aussi !!! l ajouter a modelandview c pour ce la on a plus besoins 
		de lajouter avec addobject
		*/
		if(result.hasErrors()){
			ModelAndView modelandview = new ModelAndView("AdmissionForm");
			return modelandview;
			
		}
		ModelAndView modelandview = new ModelAndView("AdmissionSuccess");
		//modelandview.addObject("msg","Details submitted by you: "+name+", Hobby"+hobbys);
		//modelandview.addObject("headermsg","Service college ingenieur ");
		//modelandview.addObject("student1",student1);
		
		
		return modelandview;
	}
   /* @ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e){
		System.out.println("null pointer exception occured: "+e);
		return "NullPointerException";
	}*/
}

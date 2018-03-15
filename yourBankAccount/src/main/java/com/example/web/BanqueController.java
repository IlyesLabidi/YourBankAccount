package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Compte;
import com.example.entities.Operation;
import com.example.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping("/operations") 
	public String index(){
		
		return "comptes";
	}
	
	@RequestMapping("/consultercompte") 
	public String consulter(Model model , String codeCompte,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size ){
		model.addAttribute("codeCompte", codeCompte);
		try {
			Page <Operation>  pageOperations=banqueMetier.listOperation(codeCompte, page, size);
			Compte cp= banqueMetier.consulterCompte(codeCompte);
			model.addAttribute("listOperations", pageOperations.getContent());
			int [] pages= new int [pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		
		
		return "comptes";
	}
	@RequestMapping(value="/saveOperation", method=RequestMethod.POST ) 
	public String saveOperation(Model model, String typeOperation,
			String codeCompte, double montant, String codeCompte2){
		try {
			if (typeOperation.equals("Vers")){
				banqueMetier.verser(codeCompte, montant);
			}
			else if (typeOperation.equals("Retr")){
				banqueMetier.retirer(codeCompte, montant);
			}else if (typeOperation.equals("Vir")){
				banqueMetier.virement(codeCompte, codeCompte2, montant);
			}
		} catch (Exception e) {
			model.addAttribute("Error", e);
			return "redirect:/consultercompte?codeCompte="+codeCompte+"&Error="+e.getMessage();
		}
		
		return "redirect:/consultercompte?codeCompte="+codeCompte;
	}

}

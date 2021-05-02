package spf.petclinic.application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spf.petclinic.application.services.VetServices;

@Controller
public class VetController {
	
	private final VetServices vs;
	
	
	
	public VetController(VetServices vs) {
		super();
		this.vs = vs;
	}

	@RequestMapping({"vet","vet/index","vet/index.html"})
	public String vetcontrol(Model m) {
		m.addAttribute("Vets", vs.findAll());
		return "Vet/index";
	}

}

package spf.petclinic.application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spf.petclinic.application.services.ownerservices;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final ownerservices os;
	
	public OwnerController(ownerservices os) {
		super();
		this.os = os;
	}

	@RequestMapping({"owner","owner/index","owner/index.html"})
	public String ownerControl(Model md)
	{
		md.addAttribute("owners", os.findAll());
		return "owner/index";
		}
	
	@RequestMapping("/find")
	public String findowner()
	{
		return "notImplemented";
	}
}

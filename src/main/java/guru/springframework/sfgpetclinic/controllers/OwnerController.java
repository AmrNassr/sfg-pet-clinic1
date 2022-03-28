package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.Services.OwnerService;

@Controller
public class OwnerController {
	OwnerService ownerService;
	
    public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService; 
	}

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html", "/owners.html"})
    public String listOwner(Model model)
    {
    	model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/owners/find")
    public String findOwners(){
        return "notimplemented";
    }
}

package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.Services.VetService;

@Controller
public class VetController {
	VetService vetService;
	
    public VetController(VetService service) {
		this.vetService = service;
	} 

	@RequestMapping({"/vets", "/vets/index", "vets.html","/vets/index.html"})
    public String listVets(Model model )
    {
		model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}

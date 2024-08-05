package test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.dto.ComponentDTOAddUpdate;
import test.service.ComponentService;
import test.service.ProducerService;

@Controller
@RequestMapping("/components")
public class ComponentsController {

	private final ComponentService componentService;
	private final ProducerService producerService;

	public ComponentsController(ComponentService componentService, ProducerService producerService) {
		super();
		this.componentService = componentService;
		this.producerService = producerService;
	}

	@GetMapping("")
	public String getAll(ModelMap request, @RequestParam(required = false, defaultValue = "") String model,
			@RequestParam(required = false, defaultValue = "") String producerName) {
		request.addAttribute("components", componentService.get(model, producerName));
		request.addAttribute("producers", producerService.getAll());
		return "components";
	}

	@GetMapping("/add")
	public String add(ModelMap request) {
		request.addAttribute("producers", producerService.getAll());
		return "component-add";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute ComponentDTOAddUpdate componentDTO) {
		componentService.add(componentDTO);
		return "redirect:/components";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute ComponentDTOAddUpdate componentDTO) {
		componentService.update(componentDTO);
		return "redirect:/components";
	}
}

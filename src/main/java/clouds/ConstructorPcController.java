package clouds;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import clouds.Part.Type;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/constructor")
@SessionAttributes("order")
public class ConstructorPcController {
	
	@ModelAttribute
	public void addPartsModel(Model model) {
		List<Part> parts = Arrays.asList(	
		new Part(Part.Type.CPU, "i5", "intel", 50.99, 1),
		new Part(Part.Type.GPU, "rtx4060", "nvidia", 300, 2),
		new Part(Part.Type.SSD, "512", "kingston", 150, 3),
		new Part(Part.Type.RAM, "32", "kingston", 135 , 4),
		new Part(Part.Type.COOLER, "breeze", "noctua", 40, 5));
		
		Type[] types = Part.Type.values();
		for (Type type:types) {
			model.addAttribute(type.toString(), filterByType(parts, type));
		}
	}
	
	
	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}
	
	@ModelAttribute(name = "pc")
	public Pc pc() {
		return new Pc();
	}
	
	@GetMapping
	public String showConstructorForm() {
		return "constructor";
	}
	
	private Iterable<Part> filterByType(List<Part> parts, Type type){
		return parts.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}
	
	
	@PostMapping
	public String processPc(Pc pc, @ModelAttribute Order order) {
	 order.addPc(pc);
	 log.info("Processing pc: {}", pc);
	 return "redirect:/orders/current";
	}

}

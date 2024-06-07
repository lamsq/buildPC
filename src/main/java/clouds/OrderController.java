package clouds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pcOrder")
public class OrderController {
	
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}

}

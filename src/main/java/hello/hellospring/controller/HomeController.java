package hello.hellospring.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}

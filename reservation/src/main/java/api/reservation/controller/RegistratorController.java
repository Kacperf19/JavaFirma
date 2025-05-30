package api.reservation.controller;

import api.reservation.entity.User;
import api.reservation.entity.dto.UserRegistrotorDto;
import api.reservation.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistratorController {
    private final UserService userService;
    public RegistratorController(UserService userService) {
        this.userService = userService;
    }
@GetMapping("/register")
        public String registrator(Model model) {
    UserRegistrotorDto user = new UserRegistrotorDto();
    model.addAttribute("user", user);
        return "registrator";
    }
@PostMapping("/register")
    String register(UserRegistrotorDto userRegistrotorDto) {
        userService.register(userRegistrotorDto);
        return "redirect:/Confirm";
    }
@GetMapping("/Confirm")
    String confirm() {
        return "Confirm";
    }
}


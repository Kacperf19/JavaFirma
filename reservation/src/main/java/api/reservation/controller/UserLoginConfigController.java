package api.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserLoginConfigController {
@GetMapping("login-config")
    public String loginConfig() {
        return "User/UserLoginConfig";
    }

}

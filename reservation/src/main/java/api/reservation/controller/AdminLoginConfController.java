package api.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminLoginConfController {


        @GetMapping("admin-login-config")
        public String loginConfig() {
            return "Admin/AdminLoginConf";
        }



}

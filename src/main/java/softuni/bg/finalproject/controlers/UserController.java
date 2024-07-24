package softuni.bg.finalproject.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }
}

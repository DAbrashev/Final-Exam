package softuni.bg.finalproject.controlers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.bg.finalproject.models.EcontUserDetails;
import softuni.bg.finalproject.services.EcontUserDetailsService;

@Controller
public class HomeController {

    private final EcontUserDetailsService econtUserDetailsService;

    public HomeController(EcontUserDetailsService econtUserDetailsService) {
        this.econtUserDetailsService = econtUserDetailsService;
    }

    @GetMapping("/")
    public String home(  @AuthenticationPrincipal UserDetails userDetails
            ,Model model){

        if (userDetails instanceof EcontUserDetails econtUserDetails){
            model.addAttribute("welcomeMessage",econtUserDetails.getFullName());
        }
        else {
            model.addAttribute("welcomeMessage","Anonymous");
        }
        return "index";
    }

    @GetMapping("/about")
    public String viewAboutPage(Model model){

        return "about";
    }
}

package softuni.bg.finalproject.controlers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.finalproject.models.dtos.UserLoginDTO;
import softuni.bg.finalproject.models.dtos.UserRegisterDTO;
import softuni.bg.finalproject.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO createEmptyDTO(){
        return new UserRegisterDTO();
    }


    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("loginData",new UserLoginDTO());
        return "login";
    }

    @GetMapping("/register")
    public String viewRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO userRegisterDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes
                             ){
        if (bindingResult.hasErrors() || !userService.doRegister(userRegisterDTO)){
            redirectAttributes.addFlashAttribute("registerDTO",userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/register";
        }

        return "redirect:/";
    }
}

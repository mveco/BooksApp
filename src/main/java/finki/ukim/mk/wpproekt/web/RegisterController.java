package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Role;
import finki.ukim.mk.wpproekt.model.exceptions.InvalidArgumentsException;
import finki.ukim.mk.wpproekt.model.exceptions.PasswordsDoNotMatchException;
import finki.ukim.mk.wpproekt.service.AuthService;
import finki.ukim.mk.wpproekt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent","register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam(required = false) Integer age,
                           @RequestParam(required = false) String quote,
                           @RequestParam Role role) {
        try{
            this.userService.register(username, password, repeatedPassword, name, surname, age, quote, role);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}

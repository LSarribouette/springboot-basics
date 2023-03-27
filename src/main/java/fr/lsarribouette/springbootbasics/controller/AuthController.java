package fr.lsarribouette.springbootbasics.controller;

import fr.lsarribouette.springbootbasics.model.Member;
import fr.lsarribouette.springbootbasics.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password,
                        Model model, HttpSession session) {
        Optional<Member> user = authService.toLogin(email, password);
        System.out.println(user);
        if (user.isPresent()) {
            session.setAttribute("userSession", user);
            return "redirect:/";//appel du contrôleur MovieController
        } else {
            model.addAttribute("error", "Le login et le password ne sont pas corrects");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}

package br.senai.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/home")
    public String index(){
        return "index.html";

    }

    @GetMapping("/cadastrar")
    public String cadastro(){
        return "/cadastrar";
    }

    @RequestMapping("/quit")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

    @GetMapping("/perfil")
    public String userPerfil(Model model, Authentication authentication){
        model.addAttribute("user", authentication.getPrincipal());
        return "users/perfil.html";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

}
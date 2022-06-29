package br.senai.controller;

import br.senai.service.BarServiceImpl;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarController {

    @Autowired
    BarServiceImpl barService;

    @GetMapping("/bar/store")
    public String findAll(Model model){
        model.addAttribute("bebidas", barService.findAll());
        return "bar/store";
    }
}

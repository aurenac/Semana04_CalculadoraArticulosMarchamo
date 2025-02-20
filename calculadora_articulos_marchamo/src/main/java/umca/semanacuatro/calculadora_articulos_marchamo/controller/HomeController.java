package umca.semanacuatro.calculadora_articulos_marchamo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

     @GetMapping({"" , "/" , "home"})
    public String home() {
        return "home";
    }
}

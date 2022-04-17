package lv.venta.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    /**
     * uzsaucot url localhost:8080/simple browserī tiks izvadīts teksts
     * home.html lapa
     * @return
     */
    @GetMapping("/simple") //nostradas uz /simple url
    public String simpleFunc() {
        System.out.println("Url adrese izsauc šo funkciju");
        return "home"; //ielade home html lapu
    }
}

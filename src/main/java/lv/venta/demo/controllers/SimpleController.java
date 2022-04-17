package lv.venta.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/msg")
    public String msgFunc(Model model) { //aizsutit datus no backend uz frontend
        model.addAttribute("package", "Zina no JAVA Backend puses");
        System.out.println("msg kontrolieris ir izsaukts");
        return "msg-page";// ieladejam msg-page.html lapu
    }
}

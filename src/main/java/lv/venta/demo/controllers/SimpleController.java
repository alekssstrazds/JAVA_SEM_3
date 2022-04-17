package lv.venta.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.demo.model.Product;

@Controller
public class SimpleController {
    private ArrayList<Product> allProducts = new ArrayList<>(
        Arrays.asList(
            new Product("Maize", 2.13f, 3),
            new Product("Udens", 0.56f, 100),
            new Product("Banans", 0.35f, 21)));
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
    @GetMapping("/product")
    public String productFunc(Model model) {
        Product product = new Product("Abols", 0.99f, 10);
        model.addAttribute("package", product);
        System.out.println("Produktu kontrolieris izsaukts");
        return "product-page";// ieladejam product-page.html lapu ar package sutijumu
    }
    //localhost:8080/list
    //@requestParam url-> //all-product?id=1
    @GetMapping("/list")
    public String listFunc(Model model) {
        model.addAttribute("package", allProducts);
        System.out.println("Produktu kontrolieris izsaukts");
        return "all-product-page";
    }
}

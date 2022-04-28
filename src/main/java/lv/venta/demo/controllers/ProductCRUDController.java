package lv.venta.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.ICRUDProductService;

@Controller
@RequestMapping("/product") //localhost:8080/product
public class ProductCRUDController {
    
    @Autowired
    private ICRUDProductService prodService;

    @GetMapping("/all") //localhost:8080/product/all
    public String getProductAll(Model model) {
        ArrayList<Product> list = prodService.readAllProduct();
        model.addAttribute("package", list);
        return "all-product-page"; //parāda all-product-page.html lapu
    }

    @GetMapping("/one") //localhost:8080/product/one?id=0
    public String getProductOne(@RequestParam(name="id") int id, Model model){
        try {
            Product temp = prodService.readById(id);
            model.addAttribute("package", temp);
            return "product-page"; //parāda product-page.html lapu ar package
        } catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }

    @GetMapping("/all/{id}") //localhost:8080/product/all/1
    public String getProductById(@PathVariable(name="id") int id, Model model) {
        try {
            Product temp = prodService.readById(id);
            model.addAttribute("package", temp);
            return "product-page"; //parāda product-page.html lapu ar package
        } catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }

    @GetMapping("/add") //localhost:8080/product/add
    public String getProductAdd(Product temp)  {    //tukšš produkts tiek iedots
        return "add-product-page";
    }
    @PostMapping("/add") //localhost:8080/product/add
    public String postProductAdd(Product temp) {    //aizpildīts produkts tiek saņemts
        Product prod = prodService.createProduct(temp);
        //return "redirect:/product/all";
        return "redirect:/product/all/" + prod.getId();
    }
    @GetMapping("/update/{id}") //localhost:8080/product/update/1
    public String getProductUpdate(@PathVariable(name="id") int id, Model model) {
        try {
            Product prod = prodService.readById(id);
            model.addAttribute("product", prod);
            return "update-product-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; //atvērs error-page.html lapu
        }
    }
    @PostMapping("update/{id}")
    public String getProductUpdaet(@PathVariable(name="id") int id, Product product) { //rediģētais produkts 
        try {
            prodService.updateById(id, product);
            return "redirect:/product/all/" + id;
        } catch (Exception e) {
            return "redirect:/product/all";
        }
    }
    //delete kontrolieris - pēc id
    @GetMapping("/delete/{id}") //localhost:8080/product/delete/1
    public String getProductDelete(@PathVariable(name="id") int id, Model model) {
        try {
            prodService.deleteById(id);
            model.addAttribute("package", prodService.readAllProduct());
            return "all-product-page";
        } catch (Exception e) {
            e.printStackTrace();
            return "error-page"; //parādam error-page.html
        }
    }
}

package lv.venta.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.IFilterProductService;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterController {
    
    @Autowired
    private IFilterProductService filterService;

    @GetMapping("/priceLarger/{price}") //locahost:8080/product/filter/priceLarger/2
    public String getProductByPrice(@PathVariable(name="price") float price, Model model) {
        ArrayList<Product> filtredProduct = filterService.filterProdcutsByPriceLargerThan(price);
        model.addAttribute("package", filtredProduct);
        return "all-product-page";
    }
}

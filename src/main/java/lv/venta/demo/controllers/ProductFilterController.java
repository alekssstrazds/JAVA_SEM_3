package lv.venta.demo.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.hibernate.hql.internal.ast.util.ASTUtil.FilterPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.IFilterProductService;
import lv.venta.demo.services.impl.FilterProductServiceImpl;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterController {
    
    @Autowired
    private IFilterProductService filterService;

    @GetMapping("/priceLarger/{price}")
    public String getProductByPrice(@PathVariable(name="price") float price, Model model) {
        ArrayList<Product> filtredProduct = filterService.filterProdcutsByPriceLargerThan(price);
        model.addAttribute("", filtredProduct);
        return "all-product-page";
    }
}

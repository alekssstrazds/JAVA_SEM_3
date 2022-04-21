package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.ICRUDProductService;
import lv.venta.demo.services.IFilterProductService;

@Service
public class FilterProductServiceImpl implements IFilterProductService {

    @Autowired
    private ICRUDProductService prodCRUDService;

    @Override
    public ArrayList<Product> filterProdcutsByPriceLargerThan(float priceThreshold) {
        ArrayList<Product> filtredProducts = new ArrayList<Product>();
        for(Product prod: prodCRUDService.readAllProduct()) {
            if(prod.getPrice() > priceThreshold) {
                filtredProducts.add(prod);
            }
        }
        return filtredProducts;
    }

    @Override
    public ArrayList<Product> filterProductsByQuantityLessThan(int quantityThreshold) {
        ArrayList<Product> filtredProducts = new ArrayList<Product>();
        for(Product prod: prodCRUDService.readAllProduct()) {
            if(prod.getQuantity() < quantityThreshold) {
                filtredProducts.add(prod);
            }
        }
        return filtredProducts;
    }

    @Override
    public ArrayList<Product> getProductsWithDiscount(int discountThreshold) {
        ArrayList<Product> filtredProducts = new ArrayList<Product>();
        for(Product prod: prodCRUDService.readAllProduct()) {
           float discountPrice = prod.getPrice() - ((prod.getPrice() * discountThreshold) / 100);
           prod.setPrice(discountPrice);
           filtredProducts.add(prod);
        }
        return filtredProducts;
    }
}

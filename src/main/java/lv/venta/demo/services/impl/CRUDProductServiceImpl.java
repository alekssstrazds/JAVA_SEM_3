package lv.venta.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService {

    private ArrayList<Product> allProducts = new ArrayList<>(
        Arrays.asList(
            new Product("Maize", 2.13f, 3),
            new Product("Udens", 0.56f, 100),
            new Product("Banans", 0.35f, 21)));

    @Override
    public Product createProduct(Product temp) {
        for(Product prod: allProducts) {
            if(prod.getTitle().equals(temp.getTitle()) && prod.getPrice() == temp.getPrice()) {
                int newQuantity = prod.getQuantity() + temp.getQuantity();
                prod.setQuantity(newQuantity);
                return prod;
            }
        }
        Product newProduct = new Product(temp.getTitle(), temp.getPrice(), temp.getQuantity());
        allProducts.add(newProduct);
        return newProduct;
    }

    @Override
    public ArrayList<Product> readAllProduct() {
        return allProducts;
    }

    @Override
    public Product readById(int id) throws Exception {
        for(Product prod: allProducts) {
            if(prod.getId() == id) {
                return prod;
            }
        }
        throw new Exception("Id nav atrasts!!!");
    }

    @Override
    public void updateById(int id, Product temp) throws Exception {
        for(Product prod: allProducts) {
            if(prod.getId() == id) {
                if(!prod.getTitle().equals(temp.getTitle())) {
                    prod.setTitle(temp.getTitle()); 
                }
                if(prod.getQuantity() != temp.getQuantity()) {
                    prod.setQuantity(temp.getQuantity());
                }
                if(prod.getPrice() != temp.getPrice()) {
                    prod.setPrice(temp.getPrice());
                } 
            }
        }
        throw new Exception("Id nav atrasts!!!");
    }

    @Override
    public void deleteById(int id) throws Exception {
        for(Product prod: allProducts) {
            if(prod.getId() == id) {
                allProducts.remove(prod);
                return;
            }
        }
        throw new Exception("Id nav atrasts!!!");
    }
    
}

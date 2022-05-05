package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.repos.IProductRepo;
import lv.venta.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService {

    @Autowired
    private IProductRepo prodRepo;
        
    /*@Override
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
    }*/

    @Override
    public ArrayList<Product> readAllProduct() {
        return (ArrayList<Product>) prodRepo.findAll();
    }

    @Override
    public Product readById(int id) throws Exception {
        if(prodRepo.existsById(id)) {
            return prodRepo.findById(id).get();
        } throw new Exception("Id nav atrasts!!!"); 
    }

    @Override
    public void updateById(int id, Product temp) throws Exception {
        if(prodRepo.existsById(id)) 
        {
            //iegūstam produktu no DB
            Product prod = prodRepo.findById(id).get();
            //rediģējam produktu
            if(!prod.getTitle().equals(temp.getTitle())) {
                prod.setTitle(temp.getTitle()); 
            }
            if(prod.getQuantity() != temp.getQuantity()) {
                prod.setQuantity(temp.getQuantity());
            }
            if(prod.getPrice() != temp.getPrice()) {
                prod.setPrice(temp.getPrice());
            }
            //saglabājam DB
            prodRepo.save(prod);
        } throw new Exception("Id nav atrasts!!!");
    }

    @Override
    public void deleteById(int id) throws Exception {
        boolean isFound = false;
        if(prodRepo.existsById(id)) {
            prodRepo.deleteById(id);
            isFound = true;
        } 
        if(!isFound) {
            throw new Exception("Id nav atrasts!!!");
        }
    }

    @Override
    public Product createProduct(Product temp) {
        if(prodRepo.existsByTitleAndPrice(temp.getTitle(),temp.getPrice())) {
            //iegūstam produktu no DB
            Product prod = prodRepo.findByTitleAndPrice(temp.getTitle(),temp.getPrice());

            //Nomainam daudzumu
            int newQuantity = prod.getQuantity()+temp.getQuantity();
            prod.setQuantity(newQuantity);
            //saglabājam DB
            prodRepo.save(prod);
            //atgriežam
            return prod;
        } else {
            //izveidojam produktu
            Product newProduct = new Product(temp.getTitle(),temp.getPrice(),temp.getQuantity());
            //saglabājam izveidoto produktu DB
            Product productFromDB = prodRepo.save(newProduct);
            //atgriežam
            return productFromDB;
        }
    }
}

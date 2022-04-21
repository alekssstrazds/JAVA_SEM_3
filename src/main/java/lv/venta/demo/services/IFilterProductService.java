package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Product;

public interface IFilterProductService {
    //izfiltrē produktus, kuru cena ir lielāka par 5eur
    public abstract ArrayList<Product> filterProdcutsByPriceLargerThan(float priceThreshold);
    //izfiltrē produktus, kuru daudzums ir mazāks par 2
    public abstract ArrayList<Product> filterProductsByQuantityLessThan(int quantityThreshold);
    //uztaisa visiem produktiem cenu mazāku par 20%
    public abstract ArrayList<Product> getProductsWithDiscount(int discountThreshold);
    
}

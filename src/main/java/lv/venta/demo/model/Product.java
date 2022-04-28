package lv.venta.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {
    @Size(min = 3, max = 30, message = "Burtu skaits nedrīkst būt mazāks par 3 un lielāks par 30.")
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Pirmam burtam jābūt lielam un citiem maziem.")
    private String title;
    @Min(0)
    @Max(10000)
    private float price;
    @Min(0)
    @Max(10000)
    private int quantity;
    private int id;

    private static int counter = 0;

    public String getTitle() {
        return title;
    }
    public float getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setId() {
        this.id = counter;
        counter++;
    }

    public Product() {  
    }
    public Product(String title, float price, int quantity) {
        setId();
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product [price=" + price + ", quantity=" + quantity + ", title=" + title + "]";
    }  
}

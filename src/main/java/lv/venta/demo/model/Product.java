package lv.venta.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table
@Entity
public class Product {
    @Column(name = "Title")
    @Size(min = 3, max = 30, message = "Burtu skaits nedrīkst būt mazāks par 3 un lielāks par 30.")
    @Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Pirmam burtam jābūt lielam un citiem maziem.")
    private String title;
    @Column(name = "Price")
    @Min(0)
    @Max(10000)
    private float price;
    @Column(name = "Quantity")
    @Min(0)
    @Max(10000)
    private int quantity;
    @Column(name="Id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

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
    
    public Product() {  
    }
    public Product(String title, float price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product [price=" + price + ", quantity=" + quantity + ", title=" + title + "]";
    }  
}

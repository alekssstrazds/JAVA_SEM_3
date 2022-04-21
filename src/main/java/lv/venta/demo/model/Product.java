package lv.venta.demo.model;

public class Product {
    private String title;
    private float price;
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

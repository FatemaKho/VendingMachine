package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String productName;
    private BigDecimal price;
    private int itemsInStock;

    private final String DELIMITER ="::";

//overloaded constructor to initialize

//add in exceptions
    public Product(String productName, BigDecimal price, int itemsInStock) {
        this.productName = productName;
        this.price = price;
        this.itemsInStock = itemsInStock;
    }
    public Product(String productAsText){
        String[] fields= productAsText.split(DELIMITER);
        this.productName=fields[0];
        this.price=new BigDecimal(fields[1]);
        this.itemsInStock=Integer.parseInt(fields[2]);//could be null pointer

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getItemsInStock() {
        return itemsInStock;
    }

    public void setItemsInStock(int itemsInStock) {
        this.itemsInStock = itemsInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return itemsInStock == product.itemsInStock && productName.equals(product.productName)  && price.equals(product.price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", itemsInStock=" + itemsInStock +
                ", DELIMITER='" + DELIMITER + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, itemsInStock);

    }
    //check
    public String marshallProductAsText(){
        return productName+DELIMITER+price;
    }
}

import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
  private int id;
  private int shopId;
  private String name;
  private String brand;
  private Double size;
  private Double price;

  public Product(String name, String brand, Double size, Double price) {
    this.name = name;
    this.brand = brand;
    this.size = size;
    this.price = price;
  }

  public String getProductName() {
    return name;
  }

  public String getProductBrand() {
    return brand;
  }

  public Double getProductSize() {
    return size;
  }

  public Double getProductPrice() {

  }

}

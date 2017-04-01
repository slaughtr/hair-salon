import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
  private int id;
  private String name;
  private String location;

  public Shop(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public String getShopName() {
    return name;
  }

  public String getShopLocation() {
    return location;
  }

}

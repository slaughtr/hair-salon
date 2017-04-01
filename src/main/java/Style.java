import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Style {
  private int id;
  private String name;
  private Double price;
  private List<Integer> stylistsList = new List<Integer>();

  public Style(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String getStyleName() {
    return name;
  }

  public Double getStylePrice() {
    return price;
  }

  public void addStylistToStyleList(int stylistId) {
    stylistsList.add(stylistId);
  }

}

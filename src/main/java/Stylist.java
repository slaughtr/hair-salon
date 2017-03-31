import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stylist {
  private String name;
  private String specialty;

  private int id;

  public Stylist(String name, String specialty) {
    this.name = name;
    this.specialty = specialty;

  }

  public String getStylistName() {
    return name;
  }

  public String getStylistSpecialty() {
    return specialty;
  }

  public int getStylistId() {
    return id;
  }

  public List<Client> getAllStylistClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylist_id = :id";
      return con.createQuery(sql)
      .addParameter("id", this.id)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .executeAndFetch(Client.class);
    }
  }

  public static List<Stylist> allStylists() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists";
      return con.createQuery(sql)
      .executeAndFetch(Stylist.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, specialty) VALUES (:name, :specialty)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("specialty", this.specialty)
      .executeUpdate()
      .getKey();
    }
  }

  public static Stylist findStylist(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id = :id";
      Stylist stylist = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

//probably unnecessary
  public static Stylist findStylistByName(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE name = :name";
      Stylist stylist = con.createQuery(sql)
      .addParameter("name", name)
      .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void deleteStylistFromDatabase() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  @Override
  public boolean equals(Object otherStylist){
    if (!(otherStylist instanceof Stylist)){
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getStylistName().equals(newStylist.getStylistName()) && this.getStylistId() == newStylist.getStylistId();
    }
  }

}

import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
  private String name;
  private String appointment;
  private int id;
  private int stylistId;

  public Client(String name, String appointment) {
    this.name = name;
    this.appointment = appointment;

  }

  public String getClientName() {
    return name;
  }

  public String getClientAppointment() {
    return appointment;
  }

  public int getClientId() {
    return id;
  }




  public static List<Client> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients";
      return con.createQuery(sql)
      .executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, appointment) VALUES (:name, CAST(:appointment AS DATE))";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("appointment", this.appointment)
      // .addParameter("stylist_id", this.stylistId)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id";
      Client patient = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
      return patient;
    }
  }


  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)){
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getClientName().equals(newClient.getClientName()) && this.getClientId() == newClient.getClientId();
    }
  }

}

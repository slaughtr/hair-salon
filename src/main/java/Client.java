import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
  private String name;
  private String appointmentDate;
  private String appointmentTime;
  private int id;
  private int stylistId;

  public Client(String name, String appointmentDate, String appointmentTime) {
    this.name = name;
    this.appointmentDate = appointmentDate;
    this.appointmentTime = appointmentTime;

  }

  public String getClientName() {
    return name;
  }

  public String getClientAppointmentDate() {
    return appointmentDate;
  }

  public String getClientAppointmentTime() {
    return appointmentTime;
  }

  public int getClientId() {
    return id;
  }




  public static List<Client> allClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients";
      return con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, appointment_date, appointment_time) VALUES (:name, CAST(:appointmentDate AS DATE), CAST(:appointmentTime AS TIME))";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("appointmentDate", this.appointmentDate)
      .addParameter("appointmentTime", this.appointmentTime)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      // .addParameter("stylist_id", this.stylistId)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client findClient(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id";
      Client patient = con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
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

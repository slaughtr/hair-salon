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

  public Client(String name, String appointmentDate, String appointmentTime, int stylistId) {
    this.name = name;
    this.appointmentDate = appointmentDate;
    this.appointmentTime = appointmentTime;
    this.stylistId = stylistId;
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

  public int getAssignedStylistId() {
    return stylistId;
  }

  public String getAssignedStylistName() {
    Stylist stylist = Stylist.findStylist(this.stylistId);
    return stylist.getStylistName();
  }




  public static List<Client> allClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients";
      return con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, appointment_date, appointment_time, stylist_id) VALUES (:name, CAST(:appointmentDate AS DATE), CAST(:appointmentTime AS TIME), :stylistId)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("appointmentDate", this.appointmentDate)
      .addParameter("appointmentTime", this.appointmentTime)
      .addParameter("stylistId", this.stylistId)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("stylist_id", "stylistId")
      .addColumnMapping("appointment_time", "appointmentTime")
      .executeUpdate()
      .getKey();
    }
  }

  public static Client findClient(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id";
      Client client = con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
      return client;
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

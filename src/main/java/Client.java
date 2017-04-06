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
    String[] timeAsArray = appointmentTime.split("");
    String timeNotArray = "";
    String letsRemoveThatZero;
    //this is all pretty unnecessary but hilarious. could just use a helper method
    if(timeAsArray.length > 5) {
      for(String digit : timeAsArray) {
        if(timeNotArray.length() < 5) {
          timeNotArray+=digit;
          appointmentTime = timeNotArray;
        }
      }
    }
    // did the below for testing, but now I need that leading 0 for the time type input form to populate correctly, which didn't help and now I'm stuck, but actually it was helping and I just forgot other bits in my routing. jeeeeez
    // if(appointmentTime.charAt(0) == '0') {
    //   letsRemoveThatZero = appointmentTime.substring(1);
    //   appointmentTime = letsRemoveThatZero;
    // }
    return appointmentTime;
  }

  public int getClientId() {
    return id;
  }

  public int getAssignedStylistId() {
    return this.stylistId;
  }

  public String getAssignedStylistName() {
    try {
      Stylist stylist = Stylist.findStylist(this.stylistId);
      return stylist.getStylistName();
    } catch (NullPointerException exception) {
      return "No stylist assigned!";
    }
  }

  public void deleteClientFromDatabase() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id;";
      con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void updateClientStylist(int newStylistId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET stylist_id = :newStylistId WHERE id = :id";
      con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .addParameter("id", id)
      .addParameter("newStylistId", newStylistId)
      .executeUpdate();
    }
  }

  public void updateClientName(String newName) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET name = :name WHERE id = :id";
      con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .addParameter("id", id)
      .addParameter("name", newName)
      .executeUpdate();
    }
  }

  public void updateClientAppointmentDate(String newAppointmentDate) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET appointment_date = CAST(:newAppointmentDate AS DATE) WHERE id = :id";
      con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .addParameter("id", id)
      .addParameter("newAppointmentDate", newAppointmentDate)
      .executeUpdate();
    }
  }

  public void updateClientAppointmentTime(String newAptTime) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET appointment_time = CAST(:newAppointmentTime AS TIME) WHERE id = :id";
      con.createQuery(sql)
      .addColumnMapping("appointment_date", "appointmentDate")
      .addColumnMapping("appointment_time", "appointmentTime")
      .addColumnMapping("stylist_id", "stylistId")
      .addParameter("id", id)
      .addParameter("newAppointmentTime", newAptTime)
      .executeUpdate();
    }
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

import org.sql2o.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Appointment {
  private int id;
  private int clientId;
  private int stylistId;
  private String appointmentTime;
  private String appointmentDate;

  public Appointment(int clientId, int stylistId, String appointmentTime, String appointmentDate) {
    this.clientId = clientId;
    this.stylistId = stylistId;
    this.appointmentTime = appointmentTime;
    this.appointmentDate = appointmentDate;
  }

  public int getAppointmentClientId() {
    return clientId;
  }

  public int getAppointmentStylistId() {
    return stylistId;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public String getAppointDate() {
    return appointmentDate;
  }

}

import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();


  @Test
  public void client_instantiatesCorrectly_true() {
    Client testClient = new Client("Person", "1999-01-01");
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithName_true() {
    Client testClient = new Client("Person", "1999-01-01");
    assertTrue(testClient.getClientName().equals("Person"));
  }

  @Test
  public void client_instantiatesWithAppointment_true() {
    Client testClient = new Client("Person", "1999-01-01");
    assertTrue(testClient.getClientAppointment().equals("1999-01-01"));
  }

  @Test
  public void client_instantiatesWithId_true() {
    Client testClient = new Client("Person", "1999-01-01");
    testClient.save();
    assertTrue(testClient.getClientId() > 0);
  }

  @Test
  public void client_savesToDatabase_true() {
    Client testClient = new Client("Person", "1999-01-01");
    testClient.save();
    assertTrue(Client.find(testClient.getClientId()).equals(testClient));
  }




}

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
    Client testClient = new Client("Person", "1999-01-01", "3:00", 1);
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithName_true() {
    Client testClient = new Client("Person", "1999-01-01", "3:00", 1);
    assertTrue(testClient.getClientName().equals("Person"));
  }

  @Test
  public void client_instantiatesWithAppointmentDate_true() {
    Client testClient = new Client("Person", "1999-01-01", "3:00", 1);
    assertTrue(testClient.getClientAppointmentDate().equals("1999-01-01"));
  }

  @Test
  public void client_instantiatesWithAppointmentTime_true() {
    Client testClient = new Client("Person", "1999-01-01", "3:00", 1);
    assertTrue(testClient.getClientAppointmentTime().equals("3:00"));
  }

  @Test
  public void client_instantiatesWithId_true() {
    Client testClient = new Client("Person", "1999-01-01", "3:00", 1);
    testClient.save();
    assertTrue(testClient.getClientId() > 0);
  }

  @Test
  public void client_savesToDatabase_true() {
    Client testClient = new Client("Person", "1999-01-01", "3:00", 1);
    testClient.save();
    assertTrue(Client.findClient(testClient.getClientId()).equals(testClient));
  }

  @Test
  public void all_ReturnsAllInstancesOfClient_true() {
    Client testClient1 = new Client("Person", "1999-01-01", "3:00", 1);
    testClient1.save();
    Client testClient2 = new Client("Not a person", "1989-01-01", "3:00", 1);
    testClient2.save();
    assertTrue(Client.allClients().get(0).equals(testClient1));
    assertTrue(Client.allClients().get(1).equals(testClient2));
  }

  @Test
public void find_returnsClientWithSameId_secondClient() {
  Client testClient1 = new Client("Person", "1999-01-01", "3:00", 1);
  testClient1.save();
  Client testClient2 = new Client("Not a person", "1989-01-01", "3:00", 1);
  testClient2.save();
  assertEquals(Client.findClient(testClient2.getClientId()), testClient2);
}

  @Test
  public void client_savesWithStylistIdCorrectly_true() {
    Stylist testStylist = new Stylist("Purse on", "Mohawks");
    testStylist.save();
    Client testClient = new Client("Person", "1999-01-01", "5:00", testStylist.getStylistId());
    testClient.save();
    assertTrue(testClient.getAssignedStylistId() == testStylist.getStylistId());
  }

  @Test
  public void delete_deletesClientFromDatabase_true() {
    Client testClient = new Client("Person", "1999-01-01", "5:00", 1);
    testClient.save();
    int testClientId = testClient.getClientId();
    testClient.deleteClientFromDatabase();
    assertEquals(null, Client.findClient(testClientId));
  }

  @Test
  public void updateStylist_updatesClientStylist_true() {
    Client testClient = new Client("Person", "1999-01-01", "5:00", 1);
    testClient.save();
    testClient.updateClientStylist(2);
    assertEquals(2, Client.findClient(testClient.getClientId()).getAssignedStylistId());
    //thanks to Janek for the findClient method help. It's not mentioned anywhere, but the test here doesn't work if you just use testClient.getAssignedStylistId() because the object isn't properly reflecting the database entries that quickly or something. There's not even an example test for updating on learnhowtoprogram!
  }

  @Test
  public void updateName_updatesClientNameCorrectly_true() {
    Client testClient = new Client("Person", "1999-01-01", "5:00", 1);
    testClient.save();
    testClient.updateClientName("Not a Person");
    assertEquals("Not a Person", Client.findClient(testClient.getClientId()).getClientName());
  }

  @Test
  public void updateDate_updatesClientAppointmentDateCorrectly_true() {
    Client testClient = new Client("Person", "1999-01-01", "5:00", 1);
    testClient.save();
    testClient.updateClientAppointmentDate("2000-01-01");
    assertEquals("2000-01-01", Client.findClient(testClient.getClientId()).getClientAppointmentDate());
  }

  @Test
  public void updateTime_updatesClientAppointmentTimeCorrectly_true() {
    Client testClient = new Client("Person", "1999-01-01", "5:00", 1);
    testClient.save();
    testClient.updateClientAppointmentTime("4:00");
    assertEquals("4:00", Client.findClient(testClient.getClientId()).getClientAppointmentTime());
  }


}

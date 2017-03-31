import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StylistTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void client_instantiatesCorrectly_true() {
      Stylist testStylist = new Stylist("Purse On", "Mohawks");
      assertTrue(testStylist instanceof Stylist);
    }

    @Test
    public void client_instantiatesWithName_true() {
      Stylist testStylist = new Stylist("Purse On", "Mohawks");
      assertTrue(testStylist.getStylistName().equals("Purse On"));
    }

    @Test
    public void client_instantiatesWithSpecialty_true() {
      Stylist testStylist = new Stylist("Purse On", "Mohawks");
      assertTrue(testStylist.getStylistSpecialty().equals("Mohawks"));
    }

    @Test
    public void client_instantiatesWithId_true() {
      Stylist testStylist = new Stylist("Purse On", "Mohawks");
      testStylist.save();
      assertTrue(testStylist.getStylistId() > 0);
    }

    @Test
    public void client_savesToDatabase_true() {
      Stylist testStylist = new Stylist("Purse On", "Mohawks");
      testStylist.save();
      assertTrue(Stylist.findStylist(testStylist.getStylistId()).equals(testStylist));
    }

    @Test
    public void all_ReturnsAllInstancesOfStylist_true() {
      Stylist testStylist1 = new Stylist("Purse On", "Mohawks");
      testStylist1.save();
      Stylist testStylist2 = new Stylist("Not a Purse On", "Ponytails");
      testStylist2.save();
      assertTrue(Stylist.allStylists().get(0).equals(testStylist1));
      assertTrue(Stylist.allStylists().get(1).equals(testStylist2));
    }

    @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist testStylist1 = new Stylist("Purse On", "Mohawks");
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Not a Purse On", "Ponytails");
    testStylist2.save();
    assertEquals(Stylist.findStylist(testStylist2.getStylistId()), testStylist2);
  }

  @Test
  public void delete_deletesStylistFromDatabase_true() {
    Stylist testStylist = new Stylist("Purr Song", "Stereotypical white guy haircuts");
    testStylist.save();
    int testStylistId = testStylist.getStylistId();
    testStylist.deleteStylistFromDatabase();
    assertEquals(null, Stylist.findStylist(testStylistId));
  }

  @Test
  public void getClients_returnsAllClientsAssignedToStylist_true() {
    Stylist testStylist = new Stylist("Veni Vedi Vicci", "Mullets");
    testStylist.save();
    Client testClient = new Client("Person", "1999-01-01", "5:00", testStylist.getStylistId());
    testClient.save();
    Client testClient2 = new Client("Pearson", "1998-01-01", "4:00", testStylist.getStylistId());
    testClient2.save();
    Client testClient3 = new Client("Piercing", "1997-01-01", "3:00", testStylist.getStylistId());
    testClient3.save();
    Client[] clients = new Client[] {testClient, testClient2, testClient3};
    assertTrue(testStylist.getAllStylistClients().containsAll(Arrays.asList(clients)));

  }


}

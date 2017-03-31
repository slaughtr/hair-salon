import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

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


}

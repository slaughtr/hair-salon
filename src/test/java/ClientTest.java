import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();


  @Test
  public void client_instantiatesCorrectly_true() {
    Client testClient = new Client("Person", "1999-01-01");
    assertTrue(testClient instanceof Client);
  }




}

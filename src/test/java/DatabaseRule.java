import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteProductsQuery = "DELETE FROM products *;";
      String deleteShopsQuery = "DELETE FROM shops *;";
      String deleteAppointmentsQuery = "DELETE FROM appointments *;";
      con.createQuery(deleteStylistsQuery).executeUpdate();
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteproductsQuery).executeUpdate();
      con.createQuery(deleteShopsQuery).executeUpdate();
      con.createQuery(deleteAppointmentsQuery).executeUpdate();
    }
  }

}

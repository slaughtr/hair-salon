import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // Stylist testStylist1 = new Stylist("Judy", "Judgement");
    // testStylist1.save();
    // Client testClient = new Client("Joe Schmo", "2017-04-06", "1:30", testStylist1.getStylistId());
    // testClient.save();
    // Client testClient2 = new Client("Quin Tuplet", "2017-04-03", "4:50", testStylist1.getStylistId());
    // testClient.save();
    // Client testClient3 = new Client("Terry The Tank", "2017-04-16", "3:10", testStylist1.getStylistId());
    // testClient3.save();
    // Stylist testStylist2 = new Stylist("Joe Mathis", "Justics");
    // testStylist2.save();
    // Client testClient4 = new Client("Nameso Are Hardo", "2017-04-26", "6:30", testStylist2.getStylistId());
    // testClient4.save();
    // Client testClient5 = new Client("Thereaseaseasea", "2017-05-06", "5:00", testStylist2.getStylistId());
    // testClient5.save();
    // Client testClient6 = new Client("Mememe Meme", "2017-03-06", "4:30", testStylist2.getStylistId());
    // testClient6.save();

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/stylists.vtl");
      model.put("stylists", Stylist.allStylists());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/clients.vtl");
      model.put("stylists", Stylist.allStylists());
      model.put("clients", Client.allClients());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/calendar", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/calendar.vtl");
      model.put("clients", Client.allClients());
      model.put("stylists", Stylist.allStylists());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}

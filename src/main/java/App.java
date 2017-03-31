import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

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

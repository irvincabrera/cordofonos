package controllers;

import play.mvc.*;
import models.Usuario;
import models.OrdenServicio;
import views.html.statics.index;
import play.Logger;
import play.libs.Json;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Security.Authenticated(Secured.class)
public class OrdenesServicios extends Controller {

    public Result indexCreateOrden() {
        Usuario user = Usuario.getByName(request().username()); 
        return ok(views.html.app.ordenServicio.create.indexCreateOrdenServicio.render(user));
    }

    public Result list() {
    
        return ok(Json.toJson(OrdenServicio.list()));
    }

    // public Result save() {
    //     Form<OrdenServicio> ordenForm = formFactory.form(OrdenServicio.class).bindFromRequest(); 
    //     if(ordenForm.hasErrors()) {
    //         return badRequest(views.html.app.ordenServicio.create._formCreate.render(ordenForm));
    //     }
    //     OrdenServicio ordenServicio = ordenServicio.save(ordenForm.get());
    //     flash("success", "OrdenServicio " + ordenForm.get().id + " ha sido registrada");
    //     return redirect(routes.HomeController.index());
    // }
    public Result buscador() {
        return ok(views.html.app.ordenServicio.buscadorOrdenServ.indexBuscador.render());
    }
}

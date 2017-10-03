package controllers;

import play.mvc.*;
import models.Usuario;
import views.html.statics.index;
import play.Logger;

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

}

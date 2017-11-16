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
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Usuario user = Usuario.getByName(request().username()); 
        Logger.debug("===> requestUserName: ",user);
        return ok(index.render(user));
    }

}

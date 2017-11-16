package controllers;

import play.mvc.*;
import models.Usuario;
import models.OrdenServicio;
import models.Cliente;
import models.Instrumento;
import views.html.statics.index;
import play.Logger;
import play.libs.Json;
import play.data.Form;
import play.data.FormFactory;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Security.Authenticated(Secured.class)
public class OrdenesServicios extends Controller {
    @Inject    
    FormFactory formFactory;
    public Result indexCreateOrden() {
        Usuario user = Usuario.getByName(request().username()); 
        return ok(views.html.app.ordenServicio.create.indexCreateOrdenServicio.render(user));
    }

    public Result getNumOrden() {
        Logger.debug("==>getNumOrden "+Json.toJson(OrdenServicio.getNumOrden()));
        return ok(Json.toJson(OrdenServicio.getNumOrden()));
    }

    public Result save() {
        Logger.info("ordenServicio@save()");
        Logger.debug("Request: "+ request());
        Logger.debug("Body: "+ request().body());
        Logger.debug("form: "+ request().body().asFormUrlEncoded());
        Form<OrdenServicio> ordenForm = formFactory.form(OrdenServicio.class).bindFromRequest(); 
            Logger.debug("ordenForm: "+ordenForm);
        Form<Cliente> clienteForm = formFactory.form(Cliente.class).bindFromRequest(); 
            Logger.debug("clienteForm: "+clienteForm);
        Form<Instrumento> instrumentoForm = formFactory.form(Instrumento.class).bindFromRequest(); 
            Logger.debug("instrumentoForm: "+instrumentoForm );
        Usuario user = Usuario.getByName(request().username());
        if(ordenForm.hasErrors() || clienteForm.hasErrors() || instrumentoForm.hasErrors()) {
            return badRequest("error");
        } else {
            Logger.debug("Forms Sin errores!");
            Result result;
            OrdenServicio object = OrdenServicio.save(ordenForm.get(), clienteForm.get(),instrumentoForm.get(), user);

            if(object!=null){
                result = ok(Json.toJson(object));
                Logger.debug("OrdenServicio " + ordenForm.get().id + " ha sido registrada");
            }
            else{
                result = internalServerError(Json.toJson("Error al guardar el registro"));
                Logger.debug("Error al guardar el registro!");
            }
        }
        return redirect(routes.HomeController.index());
    }

    public Result buscador() {
        return ok(views.html.app.ordenServicio.buscadorOrdenServ.indexBuscador.render());
    }
}

package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.OrdenServicio;
import models.Usuario;

import play.libs.Json;
import play.Logger;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Security.Authenticated(Secured.class)
public class DetallesServicios extends Controller {

    // public Result indexCreateOrden() {
    //     Usuario user = Usuario.getByName(request().username()); 
    //     return ok(views.html.app.ordenServicio.create.indexCreateOrdenServicio.render(user));
    // }

    // public Result list() {
    //     Logger.debug("=====JSON: "+Json.toJson(OrdenServicio.list()));
    //     return ok(Json.toJson(OrdenServicio.list()));
    // }

    // // public Result save() {
    // //     Logger.info("ordenServicio@save()");
    // //     Form<OrdenServicio> ordenForm = formFactory.ordenForm(OrdenServicio.class).bindFromRequest(); 
    // //     Form<Cliente> clienteForm = formFactory.clienteForm(OrdenServicio.class).bindFromRequest(); 
    // //     Form<Instrumento> instrumentoForm = formFactory.instrumentoForm(OrdenServicio.class).bindFromRequest(); 
    // //     Usuario user = Usuario.getByName(request().username());
    // //     if(ordenForm.hasErrors()) {
    // //         return badRequest("error");
    // //     } else {
    // //         OrdenServicio object = OrdenServicio.save(ordenForm.get(), user);

    // //         if(object!=null){
    // //             result = created(Json.toJson(object));
    // //             flash("success", "OrdenServicio " + ordenForm.get().id + " ha sido registrada");
    // //         }
    // //         else{
    // //             result = internalServerError(Json.toJson("Error al guardar el registro"));
    // //         }
    // //     }
    // //     return redirect(routes.HomeController.index());
    // // }

    // public Result buscador() {
    //     return ok(views.html.app.ordenServicio.buscadorOrdenServ.indexBuscador.render());
    // }
}

package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.OrdenServicio;
import models.Usuario;
import models.Servicio;

import play.libs.Json;
import play.Logger;
import play.mvc.*;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Security.Authenticated(Secured.class)
public class Servicios extends Controller {

    public Result tokenServicios(){
        ObjectNode jsono = Json.newObject();
        ArrayNode arr = jsono.arrayNode();
        arr = Servicio.tokenServicios();
        return ok(Json.toJson(arr));
    } 
   
}

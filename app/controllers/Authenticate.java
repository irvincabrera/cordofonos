package controllers;

import models.Usuario;

import play.mvc.*;
import play.data.FormFactory;
import play.data.Form;

import java.util.Date;

import javax.inject.*;

import views.html.statics.login;

//@Security.Authenticated(Secured.class)
public class Authenticate extends Controller {

    @Inject
    public FormFactory formFactory;
    public Authenticate(){

    }

	public static class Login{
		public String userName;
        public String password;
  
        public String validate() {
            if (Usuario.authenticate(userName, password) == null) {
                return "Usuario o contraseña inválida";
            }
            return null;
        }
	}

    public Result login() {
        Form<Login> formLogin = formFactory.form(Login.class);
        return ok(
            login.render(formLogin));
    }



    public Result authenticate() {
    Form<Authenticate.Login> loginForm = formFactory.form(Authenticate.Login.class).bindFromRequest();
    play.Logger.debug("Form: "+ loginForm);

    if (loginForm.hasErrors()) {
        play.Logger.error("Form con errores"); //logger
        return badRequest(login.render(loginForm));
    } else {
        play.Logger.debug("Form valido");
        session().clear();
        session("userName", loginForm.get().userName);
        // String tickString = Long.toString(new Date().getTime());  
        // session().put("userTime", tickString);
        play.Logger.debug("REDIRECCIONANDO");
        return redirect(routes.HomeController.index());
        }
    }
    public Result logout() {
      session().clear();
      flash("success", "Sesión cerrada satisfactoriamente");
      return redirect(routes.Authenticate.login());
    }

}

package controllers;

import play.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;

import models.*;

public class Secured extends Security.Authenticator {
	@Override
    public String getUsername(Context ctx) {
        return ctx.session().get("userName");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Authenticate.login());
    }
	
}

package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

import javax.persistence.*;

import java.sql.Timestamp;

import play.Logger;
import play.data.validation.*;
import play.data.Form;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends Model{

//Atributos de la clase
	@Id
	public Long id;

	@Column(unique=true)
	public String userName;

	public String nombre;

	public String paterno;

	public String materno;

	public String password;
	
	public String email;

	public String preguntaSecreta;
	
	public String respuestaSecreta;

	public Boolean activo;


	/******************************************/
	/****************METODOS*******************/
	/******************************************/
	public static Finder<Long, Usuario> find = new Finder<Long,Usuario>(Usuario.class);

	public static Usuario getByName(String userName){
		return find.where().eq("userName",userName).findUnique();
	}

	public static Usuario authenticate(String userName, String password){
		Logger.debug("===> ENTRANDO A AUTHENTICATE");
		Logger.debug("===> usuario: "+userName+" | password: "+ password);
		Usuario usuario = Usuario.find.where().eq("userName", userName).findUnique();
		if ((usuario!=null) && (usuario.password.equals(password))) {
			return usuario;
		}else{
			return null;
		}
	}

	/******************************************/
	/******************CRUD********************/
	/******************************************/

	//@Transactional
	public static Usuario save(Form<Usuario> user){
		Logger.debug("Salvando usuario"+user.get().nombre);
		if (user.hasErrors()) {
			return null;
		}

		Transaction txt = Ebean.beginTransaction();
		try{
			if (user!=null) {
				user.get().save();
				user.get().refresh();
				txt.commit();
				
			}
		}catch(Exception e){
			Logger.error("No se pudo salvar usuario");
		}finally{
			//user.
			txt.end();
		}
		return user.get();
	}

}
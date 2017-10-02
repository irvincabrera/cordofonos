package models;

import java.util.*;
import com.avaje.ebean.*;
import javax.persistence.*;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Transactional;


@Entity
public class AccionEntonacion extends Model{

	@Id
	@GeneratedValue
	public Long id;

	public String accionPuente;

	public String accionCejuela;

	public String curvatura;

	public String entonacion;

	@ManyToOne
	public Instrumento instrumento;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, AccionEntonacion> find = new Finder<Long,AccionEntonacion>(AccionEntonacion.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public AccionEntonacion save(AccionEntonacion accion){
		Logger.debug("Salvando AccionEntonacion"+accion);
		try{
			accion.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar AccionEntonacion");
		}finally{
			//accion.
		}
		return accion;
	}

}
package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import play.Logger;
import play.data.validation.*;
import play.data.format.Formats;
import play.db.ebean.Transactional;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Entity
public class Servicio extends Model{

	//Atributos
	@Id
	public Long id;

	public String nombre;

    @ManyToOne
    public Departamento departamento;
    
    public boolean activo;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, Servicio> find = new Finder<Long,Servicio>(Servicio.class);

	public static List<Servicio> list() {
        List<Servicio> objects = Servicio.find.all();
        return objects;          
    }

	 public static ArrayNode tokenServicios(){
       List<Servicio> lista = Servicio.list();
         
        ObjectNode jsono = Json.newObject();
        ArrayNode arr = jsono.arrayNode();
        for (Servicio servicio : lista ) {
            ObjectNode o = Json.newObject();
            o.put("id", servicio.id);
            o.put("name", servicio.nombre);
            arr.add(o);
        }
        jsono = null;
        lista = null;
        return arr;
    }
	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Servicio save(Servicio servicio){
		Logger.debug("Salvando servicio"+servicio);
		try{
			servicio.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar servicio");
		}finally{
			//client.
		}
		return servicio;
	}


}
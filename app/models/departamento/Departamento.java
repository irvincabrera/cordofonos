package models;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

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
public class Departamento extends Model{

	//Atributos
	@Id
	public Long id;

	public String nombre;

	// @OneToOne
 //    public Usuario responsable;
	
    public boolean activo;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, Departamento> find = new Finder<Long,Departamento>(Departamento.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Departamento save(Departamento departamento){
		Logger.debug("Salvando Departamento"+departamento);
		try{
			departamento.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar Departamento");
		}finally{
			//client.
		}
		return departamento;
	}


}
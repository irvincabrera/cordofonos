package models;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import java.util.List;
import javax.persistence.*;
import play.Logger;
import play.data.validation.*;
import play.db.ebean.Transactional;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente extends Model{

	//Atributos
	@Id
	public Long id;

	@Constraints.Required
	public String nombreCompleto;

	// public String direccion;

	public String ciudad;

	public String email;

	public String facebook;
	
	public int whatsapp;
	
	public int telefono;

	// @OneToMany
	// public List<Instrumento> instrumentos;

	// @OneToMany
	// public List<OrdenServicio> ordenesServicio;

	@ManyToOne
	public Usuario registeredBy;

	@WhenCreated
	public Timestamp created;

    @JsonIgnore
    @WhenModified
    public Timestamp updated;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, Cliente> find = new Finder<Long,Cliente>(Cliente.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Cliente save(Cliente client){
		Logger.debug("Salvando usuario"+client);
		try{
			client.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar usuario");
		}finally{
			//client.
		}
		return client;
	}


}
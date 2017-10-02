package models;

import java.util.*;
import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import javax.persistence.*;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Transactional;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class Instrumento extends Model{

	//ATRIBUTOS

	@Id
	@GeneratedValue
	public Long id;

	@Constraints.Required
	public String tipo;

	public String marca;

	public String modelo;

	public String numSerie;

	public String color;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date fechaInstrumento;

	@OneToMany
	public List<AccionEntonacion> accionEntonacion;

	@OneToMany
	public List<CondicionesAjuste> condicionesAjuste;

	@OneToMany
	public List<Electronica> electronica;

	@OneToMany
	public List<Herrajes> herrajes;

	@OneToMany
	public List<PlasticosTapasPlacas> plasticosTapasPlacas;

	@ManyToOne
	public Cliente cliente;
	
	@OneToMany
	public List<OrdenServicio> ordenServicio;

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

	public static Finder<Long, Instrumento> find = new Finder<Long,Instrumento>(Instrumento.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Instrumento save(Instrumento instrumento){
		Logger.debug("Salvando Instrumento"+instrumento);
		try{
			instrumento.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar Instrumento");
		}finally{
			//instrumento.
		}
		return instrumento;
	}

}
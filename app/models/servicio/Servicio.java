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
public class Servicio extends Model{

	//Atributos
	@Id
	public Long id;

	public String servicio;

	public String estatus;
    
    @ManyToOne
    public Usuario tecnicoResponsable;

	public boolean lauderia;

	public boolean servicioTecnico;

	public boolean pintura;

	public boolean servicioElectronica;

	@Column(precision = 7, scale = 2)
    public BigDecimal costo;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fechaTermino;

	@ManyToOne
	public Usuario createdBy;


	@ManyToOne
	public OrdenServicio ordenServicio;

	@WhenCreated
	public Timestamp created;

    @JsonIgnore
    @WhenModified
    public Timestamp updated;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, Servicio> find = new Finder<Long,Servicio>(Servicio.class);


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
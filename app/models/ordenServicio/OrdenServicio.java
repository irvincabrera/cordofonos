package models;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import play.Logger;

import play.data.validation.*;
import play.data.format.Formats;
import play.db.ebean.Transactional;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import java.sql.Timestamp;

@Entity
public class OrdenServicio extends Model{

	//Atributos
	@Id
	public Long id;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fechaRecepcion;
	
	@ManyToOne
	public Cliente cliente;
	
	@OneToOne
	public Instrumento instrumento;

	public String contenedor;
	
	public String contenedorDescripcion;

	public String almacen;

	public String indicacionesAccion;
	
	public String indicacionesAfinacion;

	public String indicacionesEncordar;

	public String condiciones;

	@Column(precision = 7, scale = 2)
    public BigDecimal total;

	@Column(precision = 7, scale = 2)
    public BigDecimal abono;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fechaEntrega;

	@ManyToOne
	public Usuario createdBy;

	@ManyToOne
	public Usuario deliveredBy;

	@OneToMany
	public List<Servicio> servicios;

	@OneToMany
	public List<Accesorio> accesorios;


	@WhenCreated
	public Timestamp created;

    @JsonIgnore
    @WhenModified
    public Timestamp updated;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, OrdenServicio> find = new Finder<Long,OrdenServicio>(OrdenServicio.class);

	public Long obtenNumOrden(){
		Long noOrden = 0L;

		return noOrden;
	}

	public static List<OrdenServicio> list(){
		List<OrdenServicio> orden = OrdenServicio.find.all();
		return orden;
	}
	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public OrdenServicio save(OrdenServicio orden){
		Logger.debug("Salvando OrdenServicio"+orden);
		try{
			orden.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar OrdenServicio");
		}finally{
			//orden.
		}
		return orden;
	}


}
package models;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import play.libs.Json;
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

	@Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
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

	public String anotaciones;
	
	@Column(columnDefinition = "LONGBLOB")	
	public String condicionesFrente;
	
	@Column(columnDefinition = "LONGBLOB")
	public String condicionesReverso;

	public String firmaElectronica;

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
	public List<DetalleServicio> servicios;

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

	public static int list(){

		 int orden = OrdenServicio.find.findRowCount();
		// List<OrdenServicio> orden = OrdenServicio.find.all();
		// Logger.debug("===> Orden: "+orden);
		// if (orden.isNull()) {
		// 	Logger.debug("isNull");
		// 	JsonObject obj = Json.createObjectBuilder()
		// 		.add()
		// 		.build("numOrden","9999");
		// 	return  obj;
		// }else{
			 // JsonObject nulo = Json.createObjectBuilder().build();
			return orden;
		// }
	}
	/******************************************/
	/******************CRUD********************/
	/******************************************/

	// @Transactional
	public static OrdenServicio save(OrdenServicio orden, Cliente cliente, Instrumento instrumento, Usuario user){
		Logger.debug("Salvando OrdenServicio: "+orden);
		try{
			Logger.debug("Entering try...");
			orden.createdBy = user;
			if (cliente.id != null) {
				cliente.save();
				cliente.refresh();
			}
			if (instrumento.id != null) {
				instrumento.save();
				instrumento.refresh();
			}
			
			orden.save();
			orden.refresh();
		}catch(Exception e){
			Logger.error("No se pudo salvar OrdenServicio");
			orden = null;

		}finally{
			//orden.
		}
		return orden;
	}


}
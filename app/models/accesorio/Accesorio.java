package models;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import play.Logger;
import play.data.validation.*;
import play.data.format.Formats;
import play.db.ebean.Transactional;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Entity
public class Accesorio extends Model{

	//Atributos
	@Id
	public Long id;

	public String marca;

	public String modelo;
	
	public String descripcion;

	@Column(precision = 7, scale = 2)
	public BigDecimal precioCompra;

	@Column(precision = 7, scale = 2)	
	public BigDecimal precioVenta;

	public int existencias;
	
	public int existenciasMinimas;

	public boolean activo;

	@ManyToOne
	public OrdenServicio ordenServicio;

	@ManyToOne
	public DetalleVenta detalleVenta;

	@ManyToOne
	public Usuario createdBy;

	@WhenCreated
	public Timestamp created;

    @JsonIgnore
    @WhenModified
    public Timestamp updated;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, Accesorio> find = new Finder<Long,Accesorio>(Accesorio.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Accesorio save(Accesorio accesorio){
		Logger.debug("Salvando Accesorio"+accesorio);
		try{
			accesorio.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar Accesorio");
		}finally{
			//client.
		}
		return accesorio;
	}


}
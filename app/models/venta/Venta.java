package models;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
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
public class Venta extends Model{

	//Atributos
	@Id
	public Long id;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fechaVenta;

	public String nombre;

	public String contacto;
	
	@OneToMany
	public List<DetalleVenta> detalle;

	@Column(precision = 7, scale = 2)
    public BigDecimal Total;

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

	public static Finder<Long, Venta> find = new Finder<Long,Venta>(Venta.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Venta save(Venta venta){
		Logger.debug("Salvando Venta"+venta);
		try{
			venta.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar Venta");
		}finally{
			//client.
		}
		return venta;
	}


}
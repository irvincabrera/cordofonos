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
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.math.BigDecimal;

@Entity
public class DetalleVenta extends Model{

	//Atributos
	@Id
	Long id;

	@ManyToOne
	public Venta venta;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleVenta")
	public List<Accesorio> accesorios;

	public Long cantidad;

	@Column(precision = 7, scale = 2)
    public BigDecimal costo;

	
	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, DetalleVenta> find = new Finder<Long,DetalleVenta>(DetalleVenta.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public DetalleVenta save(DetalleVenta detalle){
		Logger.debug("Salvando DetalleVenta"+detalle);
		try{
			detalle.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar DetalleVenta");
		}finally{
			//client.
		}
		return detalle;
	}


}
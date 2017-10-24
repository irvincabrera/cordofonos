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
public class DetalleServicio extends Model{

	//Atributos
	@Id
	public Long id;

	@OneToOne
	public Servicio servicio;

	public String estatus;
    
    @OneToOne
    public Usuario tecnicoResponsable;

    @ManyToOne
    public OrdenServicio ordenServicio;

    @Column(precision = 7, scale = 2)
    public BigDecimal costo;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fechaTermino;

	@OneToOne
	public Usuario createdBy;

	@WhenCreated
	public Timestamp created;

    @JsonIgnore
    @WhenModified
    public Timestamp updated;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, DetalleServicio> find = new Finder<Long,DetalleServicio>(DetalleServicio.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public DetalleServicio save(DetalleServicio detalleServicio){
		Logger.debug("Salvando DetalleServicio"+detalleServicio);
		try{
			detalleServicio.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar servicio");
		}finally{
			//client.
		}
		return detalleServicio;
	}


}
package models;

import java.util.*;
import com.avaje.ebean.*;
import javax.persistence.*;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Transactional;


@Entity
public class PlasticosTapasPlacas extends Model{

	//ATRIBUTOS

	@Id
	@GeneratedValue
	public Long id;

	public String mica;

	public String marcosPastillas;

	public String perillas;

	public String portajack;

	public String tapaAlma;

	public String tapaCircuitos;

	public String tapaResortes;

	public String tapaBateria;

	public String tapaRonBrazo;

	public String ferrules;

	public String tornilleria;

	@ManyToOne
	public Instrumento instrumento;

	public static Finder<Long, PlasticosTapasPlacas> find = new Finder<Long,PlasticosTapasPlacas>(PlasticosTapasPlacas.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public PlasticosTapasPlacas save(PlasticosTapasPlacas plasticosTapasPlacas){
		Logger.debug("Salvando PlasticosTapasPlacas"+plasticosTapasPlacas);
		try{
			plasticosTapasPlacas.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar PlasticosTapasPlacas");
		}finally{
			//PlasticosTapasPlacas.
		}
		return plasticosTapasPlacas;
	}

}
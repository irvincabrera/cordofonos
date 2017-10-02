package models;

import java.util.*;
import com.avaje.ebean.*;
import javax.persistence.*;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Transactional;


@Entity
public class Herrajes extends Model{

	//ATRIBUTOS

	@Id
	@GeneratedValue
	public Long id;

	public String segletas;

	public String prisioneros;

	public String bujesPostes;

	public String palancaTremolo;

	public String maquinaria;

	public String candados;

	public String guiasCuerda;

	public String resortes;

	public String pinTahali;

	public String pinCuerdas;

	@ManyToOne
	public Instrumento instrumento;

	public static Finder<Long, Herrajes> find = new Finder<Long,Herrajes>(Herrajes.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Herrajes save(Herrajes herrajes){
		Logger.debug("Salvando Herrajes"+herrajes);
		try{
			herrajes.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar Herrajes");
		}finally{
			//Herrajes.
		}
		return herrajes;
	}

}
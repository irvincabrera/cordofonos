package models;

import java.util.*;
import com.avaje.ebean.*;
import javax.persistence.*;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Transactional;


@Entity
public class CondicionesAjuste extends Model{

	@Id
	@GeneratedValue
	public Long id;

	public String puente;

	public String cejuela;

	public String trastes;

	public String ajusteAlma;

	public String tuercaAlma;

	public String diapason;

	public String brazo;
	
	public String anguloBrazo;

	@ManyToOne
	public Instrumento instrumento;

	/******************************************/
	/****************METODOS*******************/
	/******************************************/

	public static Finder<Long, CondicionesAjuste> find = new Finder<Long,CondicionesAjuste>(CondicionesAjuste.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public CondicionesAjuste save(CondicionesAjuste ajuste){
		Logger.debug("Salvando CondicionesAjuste"+ajuste);
		try{
			ajuste.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar CondicionesAjuste");
		}finally{
			//ajuste.
		}
		return ajuste;
	}

}
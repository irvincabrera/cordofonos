package models;

import java.util.*;
import com.avaje.ebean.*;
import javax.persistence.*;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Transactional;


@Entity
public class Electronica extends Model{

	//ATRIBUTOS

	@Id
	@GeneratedValue
	public Long id;

	public String pastillaPuente;

	public String pastillaCentro;
	
	public String pastillaBrazo;

	public String piezoMicro;

	public String jack;

	public String potVolumen1;

	public String potVolumen2;

	public String potTono1;

	public String potTono2;

	public String selector;

	public String interruptores;

	public String calidadConexion;

	public String tierraFisica;

	public String blindaje;

	public String preamplificador;

	public String potBlend;

	public String potEQGrav;

	public String potEQMed;

	public String potEQAgu;

	public String bateria;

	public String conexionBateria;

	@ManyToOne
	public Instrumento instrumento;

	public static Finder<Long, Electronica> find = new Finder<Long,Electronica>(Electronica.class);


	/******************************************/
	/******************CRUD********************/
	/******************************************/

	@Transactional
	public Electronica save(Electronica electronica){
		Logger.debug("Salvando Electronica"+electronica);
		try{
			electronica.save();
		}catch(Exception e){
			Logger.error("No se pudo salvar Electronica");
		}finally{
			//electronica.
		}
		return electronica;
	}

}
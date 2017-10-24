package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

import javax.persistence.*;

import java.sql.Timestamp;

import play.Logger;
import play.data.validation.*;
import play.data.Form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

@Entity
public class Usuario extends Model{

//Atributos de la clase
	@Id
	public Long id;

	@Column(unique=true)
	public String userName;

	public String nombre;

	public String paterno;

	public String materno;

	public String password;
	
	public String email;

	public String preguntaSecreta;
	
	public String respuestaSecreta;

	public Boolean activo;


	/******************************************/
	/****************METODOS*******************/
	/******************************************/
	public static Finder<Long, Usuario> find = new Finder<Long,Usuario>(Usuario.class);

	public static Usuario getByName(String userName){
		return find.where().eq("userName",userName).findUnique();
	}

	public static Usuario authenticate(String userName, String password){
		Logger.debug("===> ENTRANDO A AUTHENTICATE");
		Logger.debug("===> usuario: "+userName+" | password: "+ password);

		String pass = Encriptar(password);

		Logger.debug("password: "+ pass);

		Usuario usuario = Usuario.find.where().eq("userName", userName).findUnique();
		if ((usuario!=null) && (usuario.password.equals(pass))) {
			return usuario;
		}else{
			return null;
		}
	}

	public String obtenNombre(){
		String nombreUser = "";
		nombreUser += nombre;
		return nombreUser;
	}

	public static String Encriptar(String texto) {
 
        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        Logger.debug("password encriptado: "+ base64EncryptedString);
        Desencriptar(base64EncryptedString);
        return base64EncryptedString;
    }

	// public static String Desencriptar(String textoEncriptado) {
 
 //        String secretKey = "qualityinfosolutions"; //llave para desenciptar datos
 //        String base64EncryptedString = "";
 
 //        try {
 //            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
 //            MessageDigest md = MessageDigest.getInstance("MD5");
 //            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
 //            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 //            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
 //            Cipher decipher = Cipher.getInstance("DESede");
 //            decipher.init(Cipher.DECRYPT_MODE, key);
 
 //            byte[] plainText = decipher.doFinal(message);
 
 //            base64EncryptedString = new String(plainText, "UTF-8");
 
 //        } catch (Exception ex) {
 //        }
 //        Logger.debug("password desencriptar: "+ base64EncryptedString);
 //        return base64EncryptedString;
	// }

	/******************************************/
	/******************CRUD********************/
	/******************************************/

	//@Transactional
	public static Usuario save(Form<Usuario> user){
		Logger.debug("Salvando usuario"+user.get().nombre);
		if (user.hasErrors()) {
			return null;
		}

		Transaction txt = Ebean.beginTransaction();
		try{
			if (user!=null) {
				user.get().save();
				user.get().refresh();
				txt.commit();
				
			}
		}catch(Exception e){
			Logger.error("No se pudo salvar usuario");
		}finally{
			//user.
			txt.end();
		}
		return user.get();
	}

}
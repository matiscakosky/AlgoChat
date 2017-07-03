package Modelo;

import java.util.Hashtable;

import Excepciones.ContactoInexistenteEnAgenda;
import Excepciones.ContactoExistente;

public class AgendaDeContactos {
	private Hashtable<String,Contacto> contactos;
	
	public AgendaDeContactos(){
		contactos = new Hashtable<String,Contacto>();
	}
	
	public int cantidad(){
		return contactos.size();
	}
	
	public void agregarContacto(String nombre){
		if (yaExisteContacto(nombre)){
			throw new ContactoExistente();
		}
		Contacto nuevoContacto = new Contacto(nombre);
		contactos.put(nombre,nuevoContacto);
		
		
	}
	
	public boolean yaExisteContacto(String nombre){
		return contactos.containsKey(nombre);
	}

	public Contacto getContacto(String nombre) {
		if (!yaExisteContacto(nombre)){
			throw new ContactoInexistenteEnAgenda();
		}
		return contactos.get(nombre);
	}
}

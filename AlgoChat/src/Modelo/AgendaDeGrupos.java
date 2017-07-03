package Modelo;

import java.util.Hashtable;

import Excepciones.GrupoInexistenteEnAgenda;
import Excepciones.GrupoYaExistente;

public class AgendaDeGrupos {
	private Hashtable<String,Grupo> grupos;
	private AgendaDeContactos contactos;
	
	public AgendaDeGrupos(AgendaDeContactos contactos){
		grupos = new Hashtable<String,Grupo>();
		this.contactos = contactos;
	}
	
	public int cantidad(){
		return grupos.size();
	}

	public void crearGrupo(String nombreGrupo) {
		if (yaExisteGrupo(nombreGrupo)){
			throw new GrupoYaExistente();
		}
		Grupo grupo = new Grupo(nombreGrupo);
		grupos.put(nombreGrupo,grupo);
	}

	public boolean yaExisteGrupo(String nombreGrupo) {
		return grupos.containsKey(nombreGrupo);
	}
	
	public Grupo getGrupo(String nombre){
		if (!yaExisteGrupo(nombre)){
			throw new GrupoInexistenteEnAgenda();
		}
		return grupos.get(nombre);
	}

	public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
		Grupo grupo = getGrupo(nombreGrupo);
		Contacto contacto = contactos.getContacto(nombreContacto);
		grupo.agregarContacto(contacto);
		
	}

	public int cantidadDeMiembros(String nombreGrupo) {
		Grupo grupo = getGrupo(nombreGrupo);
		return grupo.getCantidadDeMiembros();
		
	}
}

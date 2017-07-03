package Modelo;

import java.util.ArrayList;

import Excepciones.ContactoNoEstaEnElGrupo;

public class Grupo {
	private String nombre;
	private ArrayList<Contacto> miembros;
	
	public Grupo(String nombre){
		this.nombre = nombre;
		this.miembros = new ArrayList<Contacto>();
	}
	
	public ArrayList<Contacto> getMiembros(){
		return miembros; 
	}
	
	public String getNombreGrupo() {
		return this.nombre;
	}

	public void agregarContacto(Contacto contacto) {
		miembros.add(contacto);
		
	}

	public int getCantidadDeMiembros() {
		return miembros.size() +1;
	}

	public Contacto getContacto(String nombreContacto) {
		for (Contacto contacto : miembros) {
			if (contacto.getNombreContacto() == nombreContacto){
				return contacto;
			}
		}
		throw new ContactoNoEstaEnElGrupo();
	}
}

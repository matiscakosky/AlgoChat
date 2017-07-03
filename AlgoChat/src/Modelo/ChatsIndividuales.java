package Modelo;

import java.util.ArrayList;
import java.util.Hashtable;


public class ChatsIndividuales{

	public ArrayList<Mensaje> recibidos;
	private Hashtable<Contacto,ChatIndividual> chatsIndividuales;
	private AgendaDeContactos contactos;
	
	public ChatsIndividuales(AgendaDeContactos contactos){
		chatsIndividuales = new Hashtable<Contacto,ChatIndividual>();
		this.contactos = contactos;
	}
	
	public int cantidad(){
		return chatsIndividuales.size();
	}

	public int cantidadMensajesEnviados() {
		int total = 0;
		for (ChatIndividual chatIndividual : chatsIndividuales.values()) {
			total += chatIndividual.cantidadEnviados();
		}
		return total;
	}

	public void recibirMensajeDe(String nombre, String mensaje) {
		Contacto contacto = contactos.getContacto(nombre);
		if(!hayConversacionExistente(contacto)){
			ChatIndividual chatIndividual = new ChatIndividual(contacto);
			chatsIndividuales.put(contacto,chatIndividual);
		}
		ChatIndividual chatIndividual = chatsIndividuales.get(contacto);
		chatIndividual.recibirMensaje(mensaje);
		
		
	}

	private boolean hayConversacionExistente(Contacto contacto) {
		return chatsIndividuales.containsKey(contacto);
	}

	public int cantidadMensajesRecibidos() {
		int total = 0;
		for (ChatIndividual chatIndividual : chatsIndividuales.values()) {
			total += chatIndividual.cantidadRecibidos();
		}
		return total;
	}

	public int cantidadMensajesDe(Contacto contacto) {
		ChatIndividual chatIndividual = chatsIndividuales.get(contacto);
		if(chatIndividual != null){
			return chatIndividual.cantidadRecibidos();
		}
		return 0;
	}

	public void enviarMensajeA(String nombre, String mensaje) {
		Contacto contacto = contactos.getContacto(nombre);
		if(!hayConversacionExistente(contacto)){
			ChatIndividual chatIndividual = new ChatIndividual(contacto);
			chatsIndividuales.put(contacto,chatIndividual);
		}
		ChatIndividual chatIndividual = chatsIndividuales.get(contacto);
		chatIndividual.enviarMensaje(mensaje);
		
		
	}

	public int cantidadMensajesEnviadosA(String nombre) {
		Contacto contacto = contactos.getContacto(nombre);
		ChatIndividual chatIndividual = chatsIndividuales.get(contacto);
		if(chatIndividual != null){
			return chatIndividual.cantidadEnviados();
		}
		return 0;
	}

	public Hashtable<Integer,String> obtenerConversacionCon(String nombre) {
		Contacto contacto = contactos.getContacto(nombre);
		ChatIndividual chatIndividual = chatsIndividuales.get(contacto);
		return chatIndividual.generarConversacion();

	}

	public void borrarMensajesDelContacto(String nombre) {
		Contacto contacto = contactos.getContacto(nombre);
		chatsIndividuales.remove(contacto);
		
	}


	
	

}

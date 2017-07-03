package Modelo;

import java.util.Hashtable;

public class AlgoChat {
	private Usuario usuario;
	private AgendaDeContactos contactos;
	private AgendaDeGrupos grupos;
	private ChatsIndividuales chatsIndividuales;
	private ChatsGrupales chatsGrupales;
	
	
	public AlgoChat(String nombre){
		usuario = new Usuario(nombre);
		contactos = new AgendaDeContactos();
		chatsIndividuales = new ChatsIndividuales(contactos);
		grupos = new AgendaDeGrupos(contactos);
		chatsGrupales = new ChatsGrupales(grupos);
	}


	public String nombreUsuario() {
		return usuario.getNombreUsuario();
	}


	public int cantidadDeMensajesEnviados() {
		return chatsGrupales.cantidadMensajesEnviados() + chatsIndividuales.cantidadMensajesEnviados();
	}


	public int cantidadDeGrupos() {
		return grupos.cantidad();
	}


	public int cantidadDeChatsGrupales() {
		return chatsGrupales.cantidad();
	}


	public int cantidadDeContactos() {
		return contactos.cantidad();
	}


	public int cantidadDeChatsIndividuales() {
		return chatsIndividuales.cantidad();
	}


	public void agregarContacto(String nombre) {
		contactos.agregarContacto(nombre);
		
	}


	public boolean existeContacto(String nombre) {
		return contactos.yaExisteContacto(nombre);
	}


	public void recibirMensajeDe(String nombre, String mensaje) {
		chatsIndividuales.recibirMensajeDe(nombre,mensaje);
	}


	public int cantidadTotalMensajesRecibidos() {
		return chatsIndividuales.cantidadMensajesRecibidos() + chatsGrupales.cantidadMensajesRecibidos();
	}


	public int cantidadMensajesDe(String nombre) {
		Contacto contacto = contactos.getContacto(nombre);
		return chatsIndividuales.cantidadMensajesDe(contacto) + chatsGrupales.cantidadMensajesDe(contacto);
	}


	public void enviarMensajeA(String nombre, String mensaje) {
		chatsIndividuales.enviarMensajeA(nombre,mensaje);
		
	}


	public int cantidadTotalMensajesEnviados() {
		return chatsIndividuales.cantidadMensajesEnviados() + chatsGrupales.cantidadMensajesEnviados();
	}


	public int cantidadMensajesEnviadosA(String nombre) {
		return chatsIndividuales.cantidadMensajesEnviadosA(nombre);
	}


	public Hashtable<Integer,String> obtenerConversacionCon(String nombre) {
		return chatsIndividuales.obtenerConversacionCon(nombre);
	}


	public void crearGrupo(String nombreGrupo) {
		grupos.crearGrupo(nombreGrupo);
		
	}


	public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
		grupos.agregarContactoAGrupo(nombreContacto, nombreGrupo);
	}


	public int cantidadMiembrosEnGrupo(String nombreGrupo) {
		return grupos.cantidadDeMiembros(nombreGrupo);
	}


	public boolean existeGrupo(String nombreGrupo) {
		return grupos.yaExisteGrupo(nombreGrupo);
	}


	public void recibirMensajeDeGrupo(String nombreGrupo, String nombreContacto, String mensaje) {
		chatsGrupales.recibirMensajeDeGrupo(nombreGrupo,nombreContacto,mensaje);
		
	}


	public void enviarMensajeAGrupo(String nombreGrupo, String mensaje) {
		chatsGrupales.enviarMensajeAGrupo(nombreGrupo,mensaje);
	}


	public int cantidadMensajesRecibidosDelGrupo(String nombreGrupo) {
		return chatsGrupales.cantidadMensajesRecibidosDelGrupo(nombreGrupo);
	}


	public int cantidadMensajesEnviadosAlGrupo(String nombreGrupo) {
		return chatsGrupales.cantidadMensajesEnviadosAlGrupo(nombreGrupo);
	}


	public Hashtable<Integer, String> obtenerConversacionConGrupo(String nombreGrupo) {
		return chatsGrupales.obtenerConversacionCon(nombreGrupo);
	}


	public void borrarMensajesDelContacto(String nombre) {
		chatsIndividuales.borrarMensajesDelContacto(nombre);
		
	}


	public void borrarMensajesDelGrupo(String nombreGrupo) {
		chatsGrupales.borrarMensajesDelGrupo(nombreGrupo);
		
	}

}

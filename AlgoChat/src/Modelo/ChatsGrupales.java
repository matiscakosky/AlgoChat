package Modelo;
import java.util.Hashtable;


public class ChatsGrupales{
	private Hashtable<Grupo,ChatGrupal> chatsGrupales;
	private AgendaDeGrupos grupos;
	
	public ChatsGrupales(AgendaDeGrupos grupos){
		this.grupos = grupos;
		chatsGrupales = new Hashtable<Grupo,ChatGrupal>();
	}
	
	public int cantidad(){
		return chatsGrupales.size();
	}

	public int cantidadMensajesEnviados() {
		int total = 0;
		for (ChatGrupal chatGrupal : chatsGrupales.values()) {
			total += chatGrupal.cantidadEnviados();
		}
		return total;
	}

	public int cantidadMensajesRecibidos() {
		int total = 0;
		for (ChatGrupal chatGrupal : chatsGrupales.values()) {
			total += chatGrupal.cantidadRecibidos();
		}
		return total;
	}

	public void recibirMensajeDeGrupo(String nombre, String nombreContacto, String mensaje) {
		Grupo grupo = grupos.getGrupo(nombre);
		Contacto contacto = grupo.getContacto(nombreContacto);
		if(!hayConversacionExistente(grupo)){
			ChatGrupal chatGrupal = new ChatGrupal(grupo);
			chatsGrupales.put(grupo,chatGrupal);
		}
		ChatGrupal chatGrupal = chatsGrupales.get(grupo);
		
		chatGrupal.recibirMensaje(contacto,mensaje);
		
	}
	


	private boolean hayConversacionExistente(Grupo grupo) {
		return chatsGrupales.containsKey(grupo);
	}

	public void enviarMensajeAGrupo(String nombreGrupo, String mensaje) {
		Grupo grupo = grupos.getGrupo(nombreGrupo);
		if(!hayConversacionExistente(grupo)){
			ChatGrupal chatGrupal = new ChatGrupal(grupo);
			chatsGrupales.put(grupo,chatGrupal);
		}
		ChatGrupal chatGrupal = chatsGrupales.get(grupo);
		
		chatGrupal.enviarMensaje(mensaje);
		
	}

	public int cantidadMensajesRecibidosDelGrupo(String nombreGrupo) {
		Grupo grupo = grupos.getGrupo(nombreGrupo);
		ChatGrupal chatGrupal = chatsGrupales.get(grupo);
		if(chatGrupal != null){
			return chatGrupal.cantidadRecibidos();
		}
		return 0;
	}

	public int cantidadMensajesEnviadosAlGrupo(String nombreGrupo) {
		Grupo grupo = grupos.getGrupo(nombreGrupo);
		ChatGrupal chatGrupal = chatsGrupales.get(grupo);
		if(chatGrupal != null){
			return chatGrupal.cantidadEnviados();
		}
		return 0;
	}

	public Hashtable<Integer, String> obtenerConversacionCon(String nombreGrupo) {
		Grupo grupo = grupos.getGrupo(nombreGrupo);
		ChatGrupal chatGrupal = chatsGrupales.get(grupo);
		return chatGrupal.generarConversacion();
	}

	public int cantidadMensajesDe(Contacto contacto) {
		int total = 0;
		for (ChatGrupal chatGrupo : chatsGrupales.values()) {
			total += chatGrupo.getMensajesRecibidosDe(contacto).size();
		}
		return total;
	}

	public void borrarMensajesDelGrupo(String nombreGrupo) {
		Grupo grupo = grupos.getGrupo(nombreGrupo);
		chatsGrupales.remove(grupo);
		
	}
	
	

	

}

package Modelo;

import java.util.ArrayList;
import java.util.Hashtable;

public class ChatGrupal extends Chat {
	
	Grupo grupo;
	Hashtable<Contacto,ArrayList<Mensaje>> recibidos;
	
	public ChatGrupal(Grupo grupo) {
		this.grupo = grupo;
		enviados= new ArrayList<Mensaje>();
		recibidos = new Hashtable<Contacto,ArrayList<Mensaje>>();
		actual = 1;
	}
	public void recibirMensaje(Contacto contacto, String mensaje) {
		Mensaje mensajeRecibido = new Mensaje(mensaje, contacto.getNombreContacto(),actual);
		ArrayList<Mensaje> mensajesDe = recibidos.getOrDefault(contacto, new ArrayList<Mensaje>());
		mensajesDe.add(mensajeRecibido);
		recibidos.put(contacto,mensajesDe);
		actual ++;
	}
	
	public ArrayList<Mensaje> obtenerRecibidos(){
		ArrayList<Mensaje> mensajes =  new ArrayList<Mensaje>();
		for (ArrayList<Mensaje> lista : recibidos.values()) {
			for (Mensaje mensaje : lista) {
				mensajes.add(mensaje);
			}
		}
		return mensajes;
	}
	
	public ArrayList<Mensaje> getMensajesRecibidosDe(Contacto contacto){
		return recibidos.getOrDefault(contacto,new ArrayList<Mensaje>());
	}


	
}


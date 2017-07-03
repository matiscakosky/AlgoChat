package Modelo;

import java.util.ArrayList;

public class ChatIndividual extends Chat {
	Contacto contacto;
	ArrayList<Mensaje> recibidos;
	
	public ChatIndividual(Contacto contacto) {
		this.contacto = contacto;
		enviados= new ArrayList<Mensaje>();
		recibidos = new ArrayList<Mensaje>();
		actual = 1;
	}


	public void recibirMensaje(String mensaje) {
		Mensaje mensajeRecibido = new Mensaje(mensaje, this.contacto.getNombreContacto(),actual);
		//ArrayList<Mensaje> mensajes = recibidos.get(contacto);
		//mensajes.add(mensajeRecibido);
		recibidos.add(mensajeRecibido);
		actual ++;
		
	}
	


	public ArrayList<Mensaje> obtenerRecibidos(){
		return this.recibidos; 
	}


}

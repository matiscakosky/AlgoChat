package Modelo;

import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Chat {
	protected int actual;
	protected ArrayList<Mensaje> enviados;
	public abstract ArrayList<Mensaje> obtenerRecibidos();
	
	
	
	
	public int cantidadEnviados(){
		return enviados.size();
	}
	
	public int cantidadRecibidos(){
		ArrayList<Mensaje> recibidos = this.obtenerRecibidos();
		return recibidos.size();
	}
	
	public Hashtable<Integer,String> generarConversacion(){
		Hashtable<Integer,String> conversacion = new Hashtable<Integer,String>();
		for (Mensaje mensaje : enviados) {
			conversacion.put(Math.abs(mensaje.getPosicion()-actual), mensaje.contenido);
		}
		
		ArrayList<Mensaje> recibidos = this.obtenerRecibidos();
		for (Mensaje mensaje : recibidos) {
			conversacion.put(Math.abs(mensaje.getPosicion()-actual), mensaje.contenido);
		}
		return conversacion;
	}
	

	public void enviarMensaje(String mensaje) {
		Mensaje mensajeEnviado = new Mensaje(mensaje,"Yo",actual);
		actual ++;
		enviados.add(mensajeEnviado);	
		
	}
	

	
}

package Modelo;

public class Mensaje {
	String contenido;
	int posicion;
	public Mensaje(String contenido, String remitente, int posicion){
		this.posicion = posicion;
		this.contenido = remitente +": "+ contenido;
	}
	public int getPosicion(){
		return this.posicion;
	}
	public String getContenido(){
		return this.contenido;
	}

}

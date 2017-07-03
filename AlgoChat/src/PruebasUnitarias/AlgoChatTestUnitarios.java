package PruebasUnitarias;

import Modelo.AlgoChat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.ContactoInexistenteEnAgenda;
import Excepciones.GrupoInexistenteEnAgenda;

public class AlgoChatTestUnitarios {
	//@Test(expected= AtaqueInvalido.class)
	
	@Test
	public void test01CrearAlgoChatConNombre(){
		AlgoChat algoChat = new AlgoChat("Mati");
		assertEquals(algoChat.nombreUsuario(),"Mati");
	}
	@Test
	
	public void test02CrearAlgoChatConListaDeContactosVacia(){
	    AlgoChat algoChat = new AlgoChat("Matias");
        assertEquals(0, algoChat.cantidadDeContactos());

	}
	@Test
	public void test03CrearAlgoChatConUnContacto (){
	    AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Fer");
        assertEquals(1, algoChat.cantidadDeContactos());

		
	}
	@Test
	public void test04CrearAlgoChatCon4Contactos(){
	    AlgoChat algoChat = new AlgoChat("Matias");

        algoChat.agregarContacto("Fer");
        algoChat.agregarContacto("Agustina");
        algoChat.agregarContacto("Facu");
        algoChat.agregarContacto("Agus");

        assertEquals(4, algoChat.cantidadDeContactos());
        assertTrue(algoChat.existeContacto("Agustina"));
	}
	@Test
	public void test04CrearAlgoChatAgregarContactoYVerificaQueExiste(){
	    AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Fer");
        assertTrue(algoChat.existeContacto("Fer"));
	}
	
	@Test
	public void test05AlgoChatExisteMasDeUnContacto(){
        AlgoChat algoChat = new AlgoChat("Matias");

        algoChat.agregarContacto("Fer");
        algoChat.agregarContacto("Agustina");
        algoChat.agregarContacto("Facu");
        algoChat.agregarContacto("Agus");

        assertTrue(algoChat.existeContacto("Agustina"));
        assertTrue(algoChat.existeContacto("Agus"));
        
	}
	
	@Test
	public void test05bisAlgoChatNoExisteUnContactoDeberiaFallar(){
        AlgoChat algoChat = new AlgoChat("Matias");
        assertTrue(!algoChat.existeContacto("Agus"));
	}
	
	
	
	@Test
	public void test06AlgoChatRecibirUnMensaje(){
		 AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     assertEquals(1, algoChat.cantidadTotalMensajesRecibidos());
		
	}
	@Test
	public void test07AlgoChatRecibirDiezMensajesDeUnaMismaPersona(){
		 AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     assertEquals(10, algoChat.cantidadTotalMensajesRecibidos());
	}
	
	@Test
	public void test08AlgoChatRecibirDiezMensajesDeVariasPersonas(){
		AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.agregarContacto("Agus");
	     algoChat.agregarContacto("Neta");
	     algoChat.agregarContacto("Fer.");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Agus", "Che alguien hizo commit");
	     algoChat.recibirMensajeDe("Neta", "Yo no");
	     algoChat.recibirMensajeDe("Fer", "Yo si");
	     algoChat.recibirMensajeDe("Neta", "Hago uno a la noche");
	     algoChat.recibirMensajeDe("Fer", "Bueno");
	     algoChat.recibirMensajeDe("Fer.", "ponganse las pilas");
	     algoChat.recibirMensajeDe("Fer", "Hola!!.");
	     algoChat.recibirMensajeDe("Neta", "Yo no");
	     algoChat.recibirMensajeDe("Fer", "Yo si");
	     assertEquals(10, algoChat.cantidadTotalMensajesRecibidos());
	}
	@Test
	public void test09AlgoChatContarMensajesDeUnContacto(){
		AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.agregarContacto("Agus");
	     algoChat.agregarContacto("Neta");
	     algoChat.agregarContacto("Fer.");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Agus", "Che alguien hizo commit");
	     algoChat.recibirMensajeDe("Neta", "Yo no");
	     algoChat.recibirMensajeDe("Fer", "Yo si");
	     algoChat.recibirMensajeDe("Neta", "Hago uno a la noche");
	     algoChat.recibirMensajeDe("Fer", "Bueno");
	     algoChat.recibirMensajeDe("Fer.", "ponganse las pilas");
	     algoChat.recibirMensajeDe("Fer", "Hola!!.");
	     algoChat.recibirMensajeDe("Neta", "Yo no");
	     algoChat.recibirMensajeDe("Fer", "Yo si");
	     assertEquals(1, algoChat.cantidadMensajesDe("Fer."));
	}
	@Test
	public void test10AlgoChatContarMensajesDeVariasPersonas(){
		AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.agregarContacto("Agus");
	     algoChat.agregarContacto("Neta");
	     algoChat.agregarContacto("Fer.");
	     algoChat.recibirMensajeDe("Fer", "Estara aprobado el TP2");
	     algoChat.recibirMensajeDe("Agus", "Che alguien hizo commit");
	     algoChat.recibirMensajeDe("Neta", "Yo no");
	     algoChat.recibirMensajeDe("Fer", "Yo si");
	     algoChat.recibirMensajeDe("Neta", "Hago uno a la noche");
	     algoChat.recibirMensajeDe("Fer", "Bueno");
	     algoChat.recibirMensajeDe("Fer.", "ponganse las pilas");
	     algoChat.recibirMensajeDe("Fer", "Hola!!.");
	     algoChat.recibirMensajeDe("Neta", "Yo no");
	     algoChat.recibirMensajeDe("Fer", "Yo si");
	     assertEquals(1, algoChat.cantidadMensajesDe("Fer."));
	     assertEquals(5, algoChat.cantidadMensajesDe("Fer"));
	     assertEquals(3, algoChat.cantidadMensajesDe("Neta"));
	     assertEquals(1, algoChat.cantidadMensajesDe("Agus"));
	}
	
	@Test
	public void test11AlgoChatEnviarUnMensaje(){

        AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Diego");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        assertEquals(1, algoChat.cantidadTotalMensajesEnviados());
	
	}
	
	@Test
	public void test12AlgoChatEnviarDiezMensajesAUnaMismaPersona(){
        AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Diego");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        algoChat.enviarMensajeA("Diego", "Hola!!");
        assertEquals(10, algoChat.cantidadTotalMensajesEnviados());
	}
	@Test
	public void test13AlgoChatEnviarDiezMensajesAVariasPersonas(){
		AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.agregarContacto("Agus");
	     algoChat.agregarContacto("Neta");
	     algoChat.agregarContacto("Tomi");
	     
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Agus", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Agus", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Neta", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Tomi", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Tomi", "Hola!!");

	     assertEquals(10, algoChat.cantidadTotalMensajesEnviados());
	}
	
	
	
	@Test
	public void test14AlgoChatContarMensajesDeCadaContactoEnviado(){
		AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.agregarContacto("Agus");
	     algoChat.agregarContacto("Neta");
	     algoChat.agregarContacto("Tomi");
	     
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Agus", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Agus", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Neta", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Tomi", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Tomi", "Hola!!");

	     assertEquals(2, algoChat.cantidadMensajesEnviadosA("Tomi"));

	}
	@Test
	public void test15AlgoChatContarDiezMensajesAVariasPersonas(){
		AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.agregarContacto("Fer");
	     algoChat.agregarContacto("Agus");
	     algoChat.agregarContacto("Neta");
	     algoChat.agregarContacto("Tomi");
	     
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Agus", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Agus", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Neta", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Tomi", "Hola!!");
	     algoChat.enviarMensajeA("Fer", "Hola!!");
	     algoChat.enviarMensajeA("Tomi", "Hola!!");

	     assertEquals(2, algoChat.cantidadMensajesEnviadosA("Tomi"));
	     assertEquals(1, algoChat.cantidadMensajesEnviadosA("Neta"));
	     assertEquals(2, algoChat.cantidadMensajesEnviadosA("Agus"));
	     assertEquals(5, algoChat.cantidadMensajesEnviadosA("Fer"));
	}
	@Test
	public void test16AlgoChatCrearGrupoConUnMiembro(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.crearGrupo("AlgoritmosIII");
        assertEquals(1, algoChat.cantidadMiembrosEnGrupo("AlgoritmosIII"));
	}
	
	@Test(expected = GrupoInexistenteEnAgenda.class)
	public void test17AlgoChatCantidadDeMiembrosEnGrupoInvalido(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.crearGrupo("AlgoritmosIII");
        assertEquals(1, algoChat.cantidadMiembrosEnGrupo("Amigos"));
	}
	
	@Test
	public void test18AlgoChatCrearGrupoConVariosMiembros(){
		 AlgoChat algoChat = new AlgoChat("Matias");

	        algoChat.agregarContacto("Fer");
	        algoChat.agregarContacto("Diego");
	        algoChat.agregarContacto("Facu");
	        algoChat.agregarContacto("Agus");

	        algoChat.crearGrupo("AlgoritmosIII");
	        algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
	        algoChat.agregarContactoAGrupo("Facu", "AlgoritmosIII");

	        assertEquals(3, algoChat.cantidadMiembrosEnGrupo("AlgoritmosIII"));
	        assertTrue(algoChat.existeGrupo("AlgoritmosIII"));
	}
	
	@Test(expected = ContactoInexistenteEnAgenda.class)
	public void test19AlgoChatCrearGrupoConContactoQueNoTengoDeberiaFallar(){
		 AlgoChat algoChat = new AlgoChat("Matias");
	     algoChat.crearGrupo("AlgoritmosIII");
	     algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
	}
	
	@Test(expected = GrupoInexistenteEnAgenda.class)
	public void test20AlgoChatAgregarContactoAGrupoInexistente(){
		AlgoChat algoChat = new AlgoChat("Matias");

        algoChat.agregarContacto("Fer");
        algoChat.agregarContacto("Diego");
        algoChat.agregarContacto("Facu");
        algoChat.agregarContacto("Agus");

        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Fer", "Amigos");
        algoChat.agregarContactoAGrupo("Facu", "Amigos");

	}
	
	
	@Test
	public void test21AlgoChatRecibirUnMensajeDeGrupo(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Fer");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        assertEquals(1, algoChat.cantidadTotalMensajesRecibidos());
		
		
		
	}
	@Test
	public void test22AlgoChatRecibirVariosMensajesDeUnaPersonaDeGrupo(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Fer");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        assertEquals(5, algoChat.cantidadTotalMensajesRecibidos());
	}
	@Test
	public void test23AlgoChatEnviarUnMensajesAGrupo(){

        AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        assertEquals(1, algoChat.cantidadTotalMensajesEnviados());
		
		
	}
	@Test
	public void test24AlgoChatEnviarVariosMensajesAGrupo(){
        AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        assertEquals(5, algoChat.cantidadTotalMensajesEnviados());
		
		
	}
	@Test(expected = GrupoInexistenteEnAgenda.class)
	public void test25AlgoChatEnviarMensajesAGrupoNoValido(){

        AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        assertEquals(1, algoChat.cantidadTotalMensajesEnviados());
	}
	
	
	
	@Test
	public void test26AlgoChatEnviarYRecibirVariosMensajesDeUnaPersonaDeGrupo(){

        AlgoChat algoChat = new AlgoChat("Matias");

        algoChat.agregarContacto("Agus");;
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Agus", "AlgoritmosIII");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Agus", "Nos juntamos el lunes?");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Agus", "holaa");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "...");

        assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("AlgoritmosIII"));

	}
	@Test
	public void test27AlgoChatEnviarYRecibirVariosMensajesDeVariasPersonaDeGrupo(){
        AlgoChat algoChat = new AlgoChat("Matias");

        algoChat.agregarContacto("Fer");
        algoChat.agregarContacto("Diego");
        algoChat.agregarContacto("Facu");
        algoChat.agregarContacto("Agus");

        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Facu", "AlgoritmosIII");

        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Facu", "Me too");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "bien, yo llevo las el tp...");

        assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
        assertEquals(1, algoChat.cantidadMensajesDe("Fer"));
        assertEquals(2, algoChat.cantidadMensajesRecibidosDelGrupo("AlgoritmosIII"));
        assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
        assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("AlgoritmosIII"));


	}
	@Test
	public void test28AlgoChatEnviarYRecibirUnMensajesDeDosGruposDistintosEIntegrantes(){       
	AlgoChat algoChat = new AlgoChat("Matias");

    algoChat.agregarContacto("Fer");
    algoChat.agregarContacto("Diego");
    algoChat.agregarContacto("Facu");
    algoChat.agregarContacto("Agus");

    algoChat.crearGrupo("AlgoritmosIII");
    algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
    algoChat.agregarContactoAGrupo("Facu", "AlgoritmosIII");

    algoChat.crearGrupo("Los pibes");
    algoChat.agregarContactoAGrupo("Fer", "Los pibes");
    algoChat.agregarContactoAGrupo("Facu", "Los pibes");
    algoChat.agregarContactoAGrupo("Diego", "Los pibes");
    algoChat.agregarContactoAGrupo("Agus", "Los pibes");

    algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
    algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
    algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Facu", "Me too");
    algoChat.enviarMensajeAGrupo("AlgoritmosIII", "bien, yo llevo las el tp...");

    assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
    assertEquals(1, algoChat.cantidadMensajesDe("Fer"));
    assertEquals(2, algoChat.cantidadMensajesRecibidosDelGrupo("AlgoritmosIII"));
    assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
    assertEquals(2, algoChat.cantidadMensajesEnviadosAlGrupo("AlgoritmosIII"));
    assertEquals(0, algoChat.cantidadMensajesRecibidosDelGrupo("Los pibes"));
    assertEquals(2, algoChat.cantidadTotalMensajesEnviados());
    assertEquals(0, algoChat.cantidadMensajesEnviadosAlGrupo("Los pibes"));
	}
	
	
	@Test
	public void test31AlgoChatRecibirVariosMensajesDeUnaPersonaYBorrarlos(){
        AlgoChat algoChat = new AlgoChat("Carlos");

        algoChat.agregarContacto("Marcio");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.borrarMensajesDelContacto("Marcio");
        assertEquals(0, algoChat.cantidadMensajesDe("Marcio"));
	}
	
	
	@Test
	public void test32AlgoChatRecibirMensajesDeVariasPersonasYBorrarAlgunos(){
        AlgoChat algoChat = new AlgoChat("Carlos");

        algoChat.agregarContacto("Marcio");
        algoChat.agregarContacto("Diego");
        algoChat.recibirMensajeDe("Diego", "Paso a las 7");
        algoChat.enviarMensajeA("Diego", "OK");
        algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");
        algoChat.enviarMensajeA("Diego", "Te dije que si...");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
        algoChat.borrarMensajesDelContacto("Diego");
        assertEquals(0, algoChat.cantidadMensajesDe("Diego"));
	}
	
	@Test
	public void test33AlgoChatRecibirUnMensajeDeGrupoYBorrarlo(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.agregarContacto("Fer");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.borrarMensajesDelGrupo("AlgoritmosIII");
        assertEquals(0, algoChat.cantidadMensajesRecibidosDelGrupo("AlgoritmosIII"));
	}
	
	
	@Test
	public void test34AlgoChatEnviarVariosMensajesAGrupoYBorrarlosTodos(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.borrarMensajesDelGrupo("AlgoritmosIII");
        assertEquals(0, algoChat.cantidadMensajesEnviadosAlGrupo("AlgoritmosIII"));
	}
	
	public void test35AAlgoChatEnviarVariosMensajesAGrupoYBorrarlosYEnviarUnoMas(){
		AlgoChat algoChat = new AlgoChat("Matias");
        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.borrarMensajesDelGrupo("AlgoritmosIII");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        assertEquals(1, algoChat.cantidadMensajesEnviadosAlGrupo("AlgoritmosIII"));
	}
	
	
	
	@Test
	public void test35AlgoChatEnviarYRecibirVariosMensajesDeVariasPersonaDeGrupoYBorrarlos(){
        AlgoChat algoChat = new AlgoChat("Matias");

        algoChat.agregarContacto("Fer");
        algoChat.agregarContacto("Diego");
        algoChat.agregarContacto("Facu");
        algoChat.agregarContacto("Agus");

        algoChat.crearGrupo("AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
        algoChat.agregarContactoAGrupo("Facu", "AlgoritmosIII");

        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
        algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Facu", "Me too");
        algoChat.enviarMensajeAGrupo("AlgoritmosIII", "bien, yo llevo las el tp...");
        

        algoChat.borrarMensajesDelGrupo("AlgoritmosIII");
        assertEquals(0, algoChat.cantidadMensajesRecibidosDelGrupo("AlgoritmosIII"));

    }
	@Test
	public void test36AlgoChatEnviarYRecibirUnMensajesDeDosGruposDistintosYBorrarAlgunos(){
		AlgoChat algoChat = new AlgoChat("Matias");

	    algoChat.agregarContacto("Fer");
	    algoChat.agregarContacto("Diego");
	    algoChat.agregarContacto("Facu");
	    algoChat.agregarContacto("Agus");

	    algoChat.crearGrupo("AlgoritmosIII");
	    algoChat.agregarContactoAGrupo("Fer", "AlgoritmosIII");
	    algoChat.agregarContactoAGrupo("Facu", "AlgoritmosIII");

	    algoChat.crearGrupo("Los pibes");
	    algoChat.agregarContactoAGrupo("Fer", "Los pibes");
	    algoChat.agregarContactoAGrupo("Facu", "Los pibes");
	    algoChat.agregarContactoAGrupo("Diego", "Los pibes");
	    algoChat.agregarContactoAGrupo("Agus", "Los pibes");
	    
	    

	    algoChat.recibirMensajeDeGrupo("Los pibes", "Fer", "Nos juntamos el lunes?");
	    algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Fer", "Nos juntamos el lunes?");
	    algoChat.enviarMensajeAGrupo("AlgoritmosIII", "Yo puedo");
	    algoChat.recibirMensajeDeGrupo("AlgoritmosIII", "Facu", "Me too");
	    algoChat.enviarMensajeAGrupo("AlgoritmosIII", "bien, yo llevo las el tp...");

        algoChat.borrarMensajesDelGrupo("AlgoritmosIII");
        assertEquals(0, algoChat.cantidadMensajesRecibidosDelGrupo("AlgoritmosIII"));
        assertEquals(1, algoChat.cantidadMensajesRecibidosDelGrupo("Los pibes"));


	}
	@Test
	public void test37AlgoChatObtenerConversacionSolo(){
        AlgoChat algoChat = new AlgoChat("Carlos");

        algoChat.agregarContacto("Marcio");
        algoChat.enviarMensajeA("Marcio", "Hoy no.");
        algoChat.enviarMensajeA("Marcio", "OK");
        algoChat.enviarMensajeA("Marcio", "Te dije que si...");



        assertEquals("Yo: Te dije que si...", algoChat.obtenerConversacionCon("Marcio").get(1));
        assertEquals("Yo: OK", algoChat.obtenerConversacionCon("Marcio").get(2));
        assertEquals("Yo: Hoy no.", algoChat.obtenerConversacionCon("Marcio").get(3));
	}
	
	@Test
	public void test38AlgoChatObtenerConversacionConUnaPersona(){
		AlgoChat algoChat = new AlgoChat("Carlos");
		
		algoChat.agregarContacto("Diego");
        algoChat.recibirMensajeDe("Diego", "Paso a las 7");
        algoChat.enviarMensajeA("Diego", "OK");
        algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");
        algoChat.enviarMensajeA("Diego", "Te dije que si...");


        assertEquals("Yo: Te dije que si...", algoChat.obtenerConversacionCon("Diego").get(1));
        assertEquals("Diego: Avisame si vas a estar", algoChat.obtenerConversacionCon("Diego").get(2));
        assertEquals("Yo: OK", algoChat.obtenerConversacionCon("Diego").get(3));
    
	}
	
	@Test
	public void test39AlgoChatObtenerConversacionConVariasPersonas(){
	     AlgoChat algoChat = new AlgoChat("Carlos");

	        algoChat.agregarContacto("Marcio");
	        algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
	        algoChat.enviarMensajeA("Marcio", "Hoy no.");

	        assertEquals(1, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(1, algoChat.cantidadMensajesDe("Marcio"));
	        assertEquals(1, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(1, algoChat.cantidadMensajesEnviadosA("Marcio"));

	        algoChat.agregarContacto("Diego");
	        algoChat.recibirMensajeDe("Diego", "Paso a las 7");
	        algoChat.enviarMensajeA("Diego", "OK");
	        algoChat.recibirMensajeDe("Diego", "Avisame si vas a estar");
	        algoChat.enviarMensajeA("Diego", "Te dije que si...");

	        assertEquals(3, algoChat.cantidadTotalMensajesRecibidos());
	        assertEquals(2, algoChat.cantidadMensajesDe("Diego"));
	        assertEquals(3, algoChat.cantidadTotalMensajesEnviados());
	        assertEquals(2, algoChat.cantidadMensajesEnviadosA("Diego"));

	        assertEquals("Yo: Te dije que si...", algoChat.obtenerConversacionCon("Diego").get(1));
	        assertEquals("Yo: Hoy no.", algoChat.obtenerConversacionCon("Marcio").get(1));
	        assertEquals("Diego: Avisame si vas a estar", algoChat.obtenerConversacionCon("Diego").get(2));
	        assertEquals("Yo: OK", algoChat.obtenerConversacionCon("Diego").get(3));
	    
	}
	
	@Test
	public void test40AlgoChatObtenerConversacionSoloNoExisteMensaje(){}

	

	

}

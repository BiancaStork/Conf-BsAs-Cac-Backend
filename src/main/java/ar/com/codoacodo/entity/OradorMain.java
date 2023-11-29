package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class OradorMain {

	public static void main(String[] args) {
		// simular que creamos un objeto de la clase Orador
		//para grabar en la bd
		
		//instancio un objeto de la clase Orador
		//crear un orador a partir de la clase Orador
		
		Orador nuevoOrador = new Orador("Carlos", "Lopez", "email@email.com", "java", LocalDate.now());
		
		//ver por consola
		System.out.println(nuevoOrador);
		nuevoOrador.mostrarId();
	
		//instancia de la clase orador "simulando" que viene de la BD
		Orador nuevoFromDB = new Orador(1L,"Pepe", "Lopez", "email@email.com", "java", LocalDate.now());
	    
		
		nuevoOrador.setNombre("Pepe");
	}
	
}

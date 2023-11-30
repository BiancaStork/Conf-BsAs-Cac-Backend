package ar.com.codoacodo.repository;

//import java.time.LocalDate;
//import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {

	public static void main(String[] args) {
		//interface i  = new ClaseQueImplementa()..
		
		OradorRepository repository = new MySQLOradorRepository();
		Orador orador = repository.getById(1L);
		//Orador nuevo = new Orador("marcelo", "lopez", "emailc@email.com", "c#", LocalDate.now());
		//repository.save(nuevo);
		
		//List<Orador> oradores = repository.findAll();
		
		System.out.println(orador);
	}
}
package ar.com.codoacodo.repository;

import java.util.List;

import ar.com.codoacodo.entity.Orador;

//import java.time.LocalDate;
//import java.util.List;


public class MainOradorRepository {

	public static void main(String[] args) {
		//interface i  = new ClaseQueImplementa()..
		// para probar buscar por id
		OradorRepository repository = new MySQLOradorRepository();
		//Orador orador = repository.getById(1L);
	//para probar save()
		//le cambio algo al id que traje en la linea de arriba
		//orador.setId(null);
		//orador.setMail("otroemail@email.com");
		//orador.setTema("JAVA");
		//repository.save(orador);
		
		//para probar delete()
		//repository.delete(11L);
		
		//para probar update()
		//Orador o = repository.getById(1L);
		//o.setTema("HTML5");
		
		//repository.update(o);
		//System.out.println("Se ha actualizado correctamente el Orador");
		//o=repository.getById(1L);
		//System.out.println(o);
		
		
		
		//System.out.println(orador);
		//System.out.println("Se ha eliminado el Orador");
		
		//para probar findAll()
		List<Orador> oradores = repository.findAll();
		System.out.println(oradores);
		
	}
}
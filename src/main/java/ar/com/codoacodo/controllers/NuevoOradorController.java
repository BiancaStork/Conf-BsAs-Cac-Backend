package ar.com.codoacodo.controllers;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.controllers.OradorRequest;
import ar.com.codoacodo.repository.MySQLOradorRepository;
import ar.com.codoacodo.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/orador/nuevo")

public class NuevoOradorController extends HttpServlet{
   
	//private OradorRepository repository = new MySQLOradorRepository();		
	
	//enviar por POST todos los datos desde el formulario en el front
	
	protected void doPost(
			HttpServletRequest request,//aca viene todos lo del front 
			HttpServletResponse response)  //aca va hacia el front
					throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String tema = request.getParameter("tema");
		
		//obtengo el json desde el frontend
				String json = request.getReader()
						.lines()
						.collect(Collectors.joining(System.lineSeparator()));//spring
				
				//convierto de json String a Objecto java usando libreria de jackson2
				ObjectMapper mapper = new ObjectMapper();
				mapper.registerModule(new JavaTimeModule());
				mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
				OradorRequest oradorRequest = mapper.readValue(json, OradorRequest.class);
				
		//validaciones
		//if(nombre==null || apellido==null || mail==null || tema==null) {
			// response json de error
	//	}
		
		 OradorRepository repository = new MySQLOradorRepository();
		 Orador orador = new Orador (oradorRequest.getNombre(), 
				 oradorRequest.getApellido(), 
				 oradorRequest.getMail(), 
				 oradorRequest.getTema(), 
				 LocalDate.now());
		 repository.save(orador);
		 
		//convierto el Objeto java a String
		 // envio al frontend atraves del response
		 response.getWriter().print(mapper.writeValueAsString(orador));		 
		
	}
	

}

package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class Orador {
/*atributos*/
	//le agrego private para encapsular los atributos ("proteger su visibilidad")
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private String tema;
	private LocalDate fechaAlta;
	
/*constructor*/
	/*alt+shift+s ---> generate constructor using Fields*/
//usar para enviar un orador a la BD

/*POLIMOFIRMO SOBRECARGA: dos metodos que se llaman iguales */
	
public Orador(String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.mail = mail;
	this.tema = tema;
	this.fechaAlta = fechaAlta;
}

// usar para traer un orador desde  la BD
public Orador(Long id, String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
	this.id = id;
	this.nombre = nombre;
	this.apellido = apellido;
	this.mail = mail;
	this.tema = tema;
	this.fechaAlta = fechaAlta;
}



//agregamos getters /setters
//setter es un metodo que permite modificar el contenido de "UN" solo atributo
//setter siempre pide parametro
public void setNombre(String nombre) {
	if (nombre != null) {
		this.nombre = nombre;
	} else {
		this.nombre="N/D";
	}
	
}


//getter Nunca pide parametro
public String getNombre() {
	return this.nombre;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getTema() {
	return tema;
}

public void setTema(String tema) {
	this.tema = tema;
}

public LocalDate getFechaAlta() {
	return fechaAlta;
}

public void setFechaAlta(LocalDate fechaAlta) {
	this.fechaAlta = fechaAlta;
}

/*polimorfismo SOBREESCRITURA*/

@Override
public String toString() {
	return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema=" + tema
			+ ", fechaAlta=" + fechaAlta + "]";
}

public void mostrarId() {
	System.out.println("id Orador=" +id);
}
 


	
	
}

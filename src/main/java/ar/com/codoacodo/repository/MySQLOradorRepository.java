package ar.com.codoacodo.repository;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MySQLOradorRepository implements OradorRepository{
	//implementar todos los metodos de la interface

	public void save(Orador orador) {
		String sql = "insert into orador(nombre, apellido, mail, tema, fecha_alta) values(?,?,?,?,?)";
		
		try (Connection conn = AdministradorDeConexiones.getConnection()){ 
		PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		//cargar los ? con los valores correspondientes
		statement.setString(1, orador.getNombre());
		statement.setString(2, orador.getApellido());
		statement.setString(3, orador.getMail());
		statement.setString(4, orador.getTema());
		statement.setDate(5, new java.sql.Date(System.currentTimeMillis())); 
		
		statement.executeUpdate(); //INSERT,UPDATE, DELETE
		ResultSet res = statement.getGeneratedKeys();
		if(res.next()) {
			Long id = res.getLong(1);
			orador.setId(id);
		}
		}catch(Exception e) {
			throw new IllegalArgumentException("No se pudo crear el Orador", e); //manejo de errores
		}
		
	}


	public Orador getById(Long id) {
		String sql = "select id, nombre, apellido, mail, tema, fecha_alta from orador where id = ?";
		Orador orador = null;
		
		try(Connection conn = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
		
			ResultSet res = statement.executeQuery();//SELECT
			
			//hay datos?
			if(res.next()) {
				//obtengo los datos desde el ResultSet
				Long _id = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String mail = res.getString(4);
				String tema = res.getString(5);
				Date fechaAlta = res.getDate(6);
				
				orador = new Orador(id,nombre, apellido, mail, tema, LocalDate.now());/*tph fechaAlta de java.sql.Date a LocalDate*/
			}
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener el orador", e);
		}
		return orador;
	}


	public void update(Orador orador) {
		String sql = "update orador "
				+ "set nombre=?, apellido=?, mail=?, tema=?"
				+ "where id = ?";
		
		try(Connection conn = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getMail());
			statement.setString(4, orador.getTema());
			statement.setLong(5, orador.getId());
			
			statement.executeUpdate();
		}catch(Exception e) {
			throw new IllegalArgumentException("No se pudo actualizar el orador", e);
		}
		
	}

	
	public void delete(Long id) {
		String sql = "delete from orador where id = ?";
		
		try(Connection conn = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		}catch(Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar el orador", e);
		}
		
	}


	public List<Orador> findAll() {
		String sql = "select id, nombre, apellido, mail, tema, fecha_alta from orador";
		List<Orador> oradores = new ArrayList<>();
		
		try(Connection conn = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();//SELECT
			//mientras haya oradores extraigo los datos, agrego a la lista
			while(res.next()) {
				Long _id = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String mail = res.getString(4);
				String tema = res.getString(5);
				Date fechaAlta = res.getDate(6);
				
				Orador orador = new Orador(_id,nombre, apellido,  mail, tema, LocalDate.now());/*tph fechaAlta de java.sql.Date a LocalDate*/
				oradores.add(orador);
			}
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener los oradores", e);
		}
		return oradores;
	}
	

}

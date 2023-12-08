package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	
	public static Connection getConnection() {
		
		String host = "localhost";
		String username = "root";
		String password = "ivan1705";
		String port = "3306";
		String dbName = "integrador_cac";
		
		String dbUrl = "jdbc:mysql://"+host+":"+port+"/"+dbName + "?serverTimeZone=UTC&useSSL=false";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection con = null;
		
		
		try { //se ve en el avanzado!! 
			Class.forName(driver);
			con= DriverManager.getConnection(dbUrl, username, password);
			
			
			
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener conexion: " + dbUrl + " - " + driver);
		}
		System.out.println("BD CONECTADA");
		return con;
	} 
}


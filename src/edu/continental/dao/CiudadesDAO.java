package edu.continental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONArray;

import edu.continental.util.ToJSON;
import edu.continental.util.Conexion1;

public class CiudadesDAO {

	
	public JSONArray listaciudades(){
		
		//obtener la conexion a la BD
		
		Conexion1 cn = new Conexion1();
		Connection con = cn.getConnection();
		
		//Sentencia SQL
		
		String sql = "SELECT id, nombre, altitud, estado from ciudades where estado = 'A' ";
		
		Statement st = null;
		ResultSet rs = null;
		
		ToJSON convertidor = new ToJSON();
		JSONArray arreglo = new JSONArray();
		
		
		try {
			//Creo la sentencia 
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			arreglo = convertidor.toJSONArray(rs);
			st.close();
			
		} catch (Exception ex) {
			System.out.println("error: " + ex.getMessage());
			ex.printStackTrace();
			return null; 
		}
		return arreglo;
	}
}

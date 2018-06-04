package com.upb.team4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConn {
	 private static DBConn dbconn;
	    private Connection conn;

	    
	    private String dbName = "Monitoreo";
	    private String userName = "root";
	    private String password = "12345";
	    private String url = "com.mysql.jdbc.Driver";
	   
	    
	    public DBConn() throws ClassNotFoundException{
	        try {
	            Class.forName(url);    
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, password);
	            System.out.println("Conectado");
	        } 
	        catch (SQLException ex) {
	            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public static DBConn getDB() throws ClassNotFoundException{
	        if(dbconn == null){
	            dbconn = new DBConn();
	        }
	        return dbconn;
	    }
	    
	    
	    public ResultSet getQuery(String _query){	
		Statement state = null;
		ResultSet resultado = null;
		try{
	            state = (Statement) conn.createStatement();
	            resultado = state.executeQuery(_query);
		}
		catch(SQLException e){
	            e.printStackTrace();
		}
	        return resultado;
	    }
		
	    public void setQuery(String _query){
	        Statement state = null;
		try{			
	            state=(Statement) conn.createStatement();
	            state.execute(_query);

	        } 
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
	    
	    public void setUpdate(String _query){
	        Statement state = null;
	        try{			
	            state =(Statement) conn.createStatement();
	            state.executeUpdate(_query);
	        } 
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
}

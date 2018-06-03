package com.upb.team4.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.upb.team4.beans.Student;
 
 
public class DBUtils {
    
    public static Boolean verificatedUser(String code, String pass) throws ClassNotFoundException{
        boolean verified = false; 
        try {
            String sql = "Select id_estudiante, contraseña from estudiante"
                    +" where id_estudiante = '"+code+"' and contraseña = '"+pass+"';";
            ResultSet rs = DBConn.getDB().getQuery(sql);
            verified = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verified;
    }
    
    public static void crearAlumno(String nombre, String apellido, int telefono, String email, String password) throws ClassNotFoundException{
        
        String sql = "insert into estudiante (nombre, apellido, telefono, email, contraseña) values('"+nombre+"' ,"
                + "'"+apellido+"', '"+telefono+"', '"+email+"', '"+password+"');";
        DBConn.getDB().setUpdate(sql);
    }
    
    public static void modificarAlumno(String nombre) {
    	
    }
    
    public static void eliminarAlumno(String code) throws ClassNotFoundException{
        
    	int ncode = Integer.parseInt(code);
        String sql = "delete from estudiante where id_estudiante = '"+ncode+"';";
        DBConn.getDB().setUpdate(sql);
    }
    
    
    public static Student findAlumno(String code) throws ClassNotFoundException {
        Student alumno = null;
        String sql = "select * from estudiante where id_estudiante = "+code+";"; 
        ResultSet st = DBConn.getDB().getQuery(sql);
        try {
            if (st.next()){
                String nombre = st.getString("nombre");
                String apellido = st.getString("apellido");
                int telefono = st.getInt("telefono");
                String email = st.getString("email");
                String pass = st.getString("contraseña");
                alumno = new Student();
                alumno.setName(nombre);
                alumno.setLastname(apellido);
                alumno.setNumber(telefono);
                alumno.setEmail(email);
                alumno.setPassword(pass);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alumno;
    }
}

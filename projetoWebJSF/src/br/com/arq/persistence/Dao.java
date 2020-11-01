package br.com.arq.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Dao {
	
	static Connection con;
	static PreparedStatement stmt;
	static ResultSet rs;

	 public static void open() throws Exception{
	     if (con==null) {
		  Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDgenesis",
	    		  "root",   "arq2020");
	      System.out.println("banco aberto");
	     } else {
	    	 System.out.println("banco ja esta aberto, nao precisa");
	     }
	 }
	 
	 public static void close() throws Exception{
		 con.close();
	    System.out.println("banco fechado");
	 }
	 
	 
	 public static void main(String[] args) {
		//Dao d = new Dao();
		 try {
			 Dao.open();
			 Dao.open();
			 Dao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 

}

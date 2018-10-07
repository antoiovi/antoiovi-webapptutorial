package com.antoiovi.a1jdbcbase;

import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.naming.Context;


  import  javax.naming.InitialContext ;


@ManagedBean(name="automob")
public class Automob   {
List<String> targhe;

	String message;


	public Automob(){
		message="Prove di connessione a databse";
	}




	/**
	* Returns value of b
	* @return
	*/
	public List<String> getTarghe() {
		targhe=new ArrayList<String>();
		Statement stmt = null;
DataSource ds =null;
		try{
		Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
  ds = (DataSource)envContext.lookup("jdbc/mysqlantoioviDB");
	} catch (javax.naming.NamingException e )
	{
		System.out.println("+++++++++++++NAMING excpetion ");

	}
		try{
				Connection con = ds.getConnection();
		    String query =	"select automobile_id,marca,modello,targa,descrizione from automobili";
        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String targa = rs.getString("targa");
		             System.out.println(targa );
								 targhe.add(targa);
		        }
		    } catch (SQLException e ) {
					System.out.println("+++++++++++++sql excpetion ");
						    }  finally {
									try{
		        if (stmt != null) { stmt.close(); }
					}catch (SQLException e ) {
							return targhe;
						}
		    }

		return targhe;
	}



	/**
	* Returns value of b
	* @return
	*/
	public String getMessage() {
		return message;
	}

	/**
	* Sets new value of b
	* @param
	*/
	public void setMessage(String b) {
		this.message = b;
	}
}

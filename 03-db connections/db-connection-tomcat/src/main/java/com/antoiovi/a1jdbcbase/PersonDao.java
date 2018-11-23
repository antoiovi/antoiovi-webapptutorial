package com.antoiovi.a1jdbcbase;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import  javax.annotation.PostConstruct;

import javax.naming.NamingException;
import javax.naming.Context;
import  javax.naming.InitialContext;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.antoiovi.a1jdbcbase.model.Person;

public class PersonDao {

private static final String CONTEXT = "java:/comp/env";
private static final String DATASOURCE = "jdbc/mysqlantoioviDB";
private static final String DATASOURCE_3 = "java:/comp/env/jdbc/mysqlantoioviDB";
private static final String DATASOURCE_2 = "mysqlantoioviDB";

void log(String s){
		System.out.println(s);
}

Connection getConnection()  {
	try {

		Context initContext = new InitialContext();
		log(String.format("initContext.lookup(CONTEXT) CONTEXT =%s",CONTEXT));
		Context envContext = (Context) initContext.lookup(CONTEXT);
		log("envContext= "+envContext.toString());
		log(String.format("envContext.lookup(DATASOURCE) DATASOURCE =%s",DATASOURCE));
		DataSource ds  = (DataSource) envContext.lookup(DATASOURCE);

	//	DataSource ds  = (DataSource) envContext.lookup(DATASOURCE_3);
//		DataSource ds  = (DataSource) new InitialContext().lookup(DATASOURCE_3);
		return ds.getConnection();
	} catch (javax.naming.NamingException e) {
		System.out.println("+++++++++++++NAMING excpetion ");
		return null;
	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
		System.out.println("+++++++++++Errore creazione datasource ");
		return null;
	}
}

public void insertPerson(Person person) {
	String SQL_INSERT =
		"INSERT INTO PERSONA (username, nome, cognome, email, password) VALUES (?, ?, ?, ?, ?)";
	PreparedStatement prepstatement= null;
	Connection connection =this.getConnection();
	if(connection==null)
		return;
	try{
		prepstatement = connection.prepareStatement(SQL_INSERT);
		prepstatement.setString(1,person.getUsername());
		prepstatement.setString(2,person.getNome());
		prepstatement.setString(3,person.getCognome());
		prepstatement.setString(4,person.getEmail());
		prepstatement.setString(5,person.getPassword());
		// call executeUpdate to execute our sql update statement
		prepstatement.executeUpdate();
		prepstatement.close();
	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(prepstatement!=null)
				connection.close();
		}catch(SQLException se) {
		}                                                                                                                // do nothing
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}                                                        //end finally try
} //insertPerson


public void deletePerson(String username) {
	Statement statement = null;
	DataSource ds = null;
	ResultSet rs = null;
	Connection con =null;
	con=this.getConnection();

	try{
		String query = "DELETE FROM PERSONE " +
		               "WHERE username = '"+username+"'";
		con = ds.getConnection();
		statement = con.createStatement();
		statement.executeUpdate(query);
	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(statement!=null)
				con.close();
		}catch(SQLException se) {
		}                                                                // do nothing
		try{
			if(con!=null)
				con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}                                                                //end finally try
	}                                                                //end try
}                // deletePerson
public void updatePerson(Person person) {
	PreparedStatement prepstatement= null;
	DataSource ds = null;
	ResultSet rs = null;
	Connection connection =this.getConnection();
	String SQL_UPDATE_PERSON="UPDATE PERSONE SET username = ?, password = ?,"+
			"nome = ?, cognome = ?,email = ?"+
			"WHERE persona_id = ?";
	if(connection==null)
		return;

	try{
		prepstatement = connection.prepareStatement(SQL_UPDATE_PERSON);
		// set the preparedstatement parameters
		prepstatement.setString(1,person.getUsername());
		prepstatement.setString(2,person.getPassword());
		prepstatement.setString(3,person.getNome());
		prepstatement.setString(4,person.getCognome());
		prepstatement.setString(5,person.getEmail());
		prepstatement.setInt(6,person.getId().intValue());

		// call executeUpdate to execute our sql update statement
		prepstatement.executeUpdate();
		prepstatement.close();
	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(prepstatement!=null)
				connection.close();
		}catch(SQLException se) {
		}                                                                // do nothing
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}                                                                //end finally try
	}                 }

public void updatePassword(String password,String username) {
	PreparedStatement prepstatement= null;
	DataSource ds = null;
	ResultSet rs = null;
	Connection connection =this.getConnection();
	if(connection==null)
		return;
	//update persone set password ='ciaos' where username='ant01';
	//UPDATE persone set password =SHA1('ciao') where username='ant01';
	//UPDATE persone set password =SHA2('ciao',256) where username='ant01';

	try{
		prepstatement = connection.prepareStatement(
			"UPDATE PERSONE SET password ? WHERE username ?");
		// set the preparedstatement parameters
		prepstatement.setString(1,password);
		prepstatement.setString(2,username);
		// call executeUpdate to execute our sql update statement
		prepstatement.executeUpdate();
		prepstatement.close();
	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(prepstatement!=null)
				connection.close();
		}catch(SQLException se) {
		}                                                                // do nothing
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}                                                                //end finally try
	}                                                         //end try
}


public List<Person> findAllPerson() {
	ArrayList persone=new ArrayList<Person>();
	Statement statement = null;
	String query="SELECT * from persone";
	ResultSet resultset=null;
	Connection connection=this.getConnection();
	if(connection==null)
		return persone;

	try {
		statement = connection.createStatement();
		resultset = statement.executeQuery(query);
		if(resultset!=null) {
			while ( resultset.next() ) {
				Person person = new Person();
				person.setId( resultset.getLong("persona_id"));
				person.setUsername( resultset.getString("username"));
				person.setNome(resultset.getString("nome"));
				person.setCognome(resultset.getString("cognome"));
				person.setEmail(resultset.getString("email"));
				person.setPassword(resultset.getString("password"));
				persone.add(person);
			}                //while
		}                //if
	} catch (SQLException e) {
		System.out.println("+++++++++++++sql excpetion ");
		e.printStackTrace();
	} finally {
		try {
			if (statement != null) {
				connection.close();
			}
		} catch (SQLException e) {
		}                //try if (statement != null)
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
		}                //try  if (connection != null)
	}                //finally
	return persone;
}

public List<Person> findByUsernameLike(String pattern) {
	String SQL_FIND_BY_USERNAME_LIKE = "SELECT * FROM PERSONE " +
									" WHERE username LIKE '%"+pattern+"%' ";
									ArrayList persone=new ArrayList<Person>();
									Statement statement = null;
									ResultSet resultset=null;
									Connection connection=this.getConnection();
									if(connection==null)
										return persone;

									try {
										statement = connection.createStatement();
										resultset = statement.executeQuery(SQL_FIND_BY_USERNAME_LIKE);
										if(resultset!=null) {
											while ( resultset.next() ) {
												Person person = new Person();
												person.setId( resultset.getLong("persona_id"));
												person.setUsername( resultset.getString("username"));
												person.setNome(resultset.getString("nome"));
												person.setCognome(resultset.getString("cognome"));
												person.setEmail(resultset.getString("email"));
												person.setPassword(resultset.getString("password"));
												persone.add(person);
											}                //while
										}                //if
									} catch (SQLException e) {
										System.out.println("+++++++++++++sql excpetion ");
									} finally {
										try {
											if (statement != null) {
												connection.close();
											}
										} catch (SQLException e) {
										}                //try if (statement != null)
										try {
											if (connection != null) {
												connection.close();
											}
										} catch (SQLException e) {
										}                //try  if (connection != null)
									}                //finally
									return persone;
}

public List<Person> findByCognomeLike(String pattern){
	String SQL_FIND_BY_COGNOME_LIKE = "SELECT * FROM PERSONE " +
									" WHERE cognome LIKE '%"+pattern+"%' ";
									ArrayList persone=new ArrayList<Person>();
									Statement statement = null;
									ResultSet resultset=null;
									Connection connection=this.getConnection();
									if(connection==null)
										return persone;

									try {
										statement = connection.createStatement();
										resultset = statement.executeQuery(SQL_FIND_BY_COGNOME_LIKE);
										if(resultset!=null) {
											while ( resultset.next() ) {
												Person person = new Person();
												person.setId( resultset.getLong("persona_id"));
												person.setUsername( resultset.getString("username"));
												person.setNome(resultset.getString("nome"));
												person.setCognome(resultset.getString("cognome"));
												person.setEmail(resultset.getString("email"));
												person.setPassword(resultset.getString("password"));
												persone.add(person);
											}                //while
										}                //if
									} catch (SQLException e) {
										System.out.println("+++++++++++++sql excpetion ");
									} finally {
										try {
											if (statement != null) {
												connection.close();
											}
										} catch (SQLException e) {
										}                //try if (statement != null)
										try {
											if (connection != null) {
												connection.close();
											}
										} catch (SQLException e) {
										}                //try  if (connection != null)
									}                //finally
									return persone;
}


public Person findByUsername(String username) {
	Person persona=new Person();
	persona.setId(null);
	String SQL_FIND_BY_USERNAME="SELECT * from PERSONE WHERE username = ?";
	PreparedStatement prepstatement= null;
	ResultSet rs= null;
	Connection connection=this.getConnection();
	if(connection==null)
		return persona;

	try{
		prepstatement = connection.prepareStatement(SQL_FIND_BY_USERNAME);
		prepstatement.setString(1,username);
		rs = prepstatement.executeQuery();
		if(rs!=null) {
			//Utilizzo rs.next()) invece di while perche username e' UNIQUE
			if (rs.next()){
				Person person = new Person();
				person.setId(rs.getLong("persona_id"));
				person.setUsername( rs.getString("username"));
				person.setNome(rs.getString("nome"));
				person.setCognome(rs.getString("cognome"));
				person.setEmail(rs.getString("email"));
				person.setPassword(rs.getString("password"));
				}                //while
		}                //if

	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(prepstatement!=null)
				connection.close();
		}catch(SQLException se) {
		}                                // do nothing
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}                                //end finally try
	}                         //end try
	return persona;

}


public Person findById(Integer id) {
	Person persona=new Person();
	persona.setId(null);
	String SQL_FIND_BY_ID="SELECT * from PERSONE WHERE persona_id = ?";
	PreparedStatement prepstatement= null;
	ResultSet rs= null;
	Connection connection=this.getConnection();
	if(connection==null)
		return persona;

	try{
		prepstatement = connection.prepareStatement(SQL_FIND_BY_ID);
		prepstatement.setInt(1,id.intValue());
		rs = prepstatement.executeQuery();
		if(rs!=null) {
			//Utilizzo rs.next()) invece di while perche username e' UNIQUE
			if (rs.next()){
				Person person = new Person();
				person.setId(rs.getLong("persona_id"));
				person.setUsername( rs.getString("username"));
				person.setNome(rs.getString("nome"));
				person.setCognome(rs.getString("cognome"));
				person.setEmail(rs.getString("email"));
				person.setPassword(rs.getString("password"));
				}                //while
		}                //if

	}catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(prepstatement!=null)
				connection.close();
		}catch(SQLException se) {
		}                                // do nothing
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}                                //end finally try
	}                         //end try
	return persona;

	}


}

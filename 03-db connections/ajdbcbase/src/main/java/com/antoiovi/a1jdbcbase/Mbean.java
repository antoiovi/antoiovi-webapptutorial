package com.antoiovi.a1jdbcbase;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="mbean")
public class Mbean   {


	String message;


	public Mbean(){
		message="Prove di connessione a databse";
	}


	public void setMessage(String message)
{
		 this.message=message;
	}

	public String getMessage(){

return message;
	}
}

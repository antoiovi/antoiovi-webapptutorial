package com.antoiovi.b1botstr;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="mbean")
public class Mbean   {


	String message;


	public Mbean(){
		message="Messaggio da MBean";
	}


	public void setMessage(String message)
{
		 this.message=message;
	}

	public String getMessage(){

return message;
	}
}

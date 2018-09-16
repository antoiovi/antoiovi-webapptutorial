package com.antoiovi.b1botstr;


public class HelloBean implements java.io.Serializable{


	String message;


	public HelloBean(){
		message="Buon giorno";
	}


	public void setMessage(String message)
{
		 this.message=message;
	}

	public String getMessage(){

return message;
	}
}

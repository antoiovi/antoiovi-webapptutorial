package com.antoiovi.a1jdbcbase;


public class HelloBean implements java.io.Serializable {


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

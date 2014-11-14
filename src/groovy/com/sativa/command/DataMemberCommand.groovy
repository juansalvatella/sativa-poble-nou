package com.sativa.command


import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.naming.*
import javax.naming.directory.*

import grails.validation.Validateable


@Validateable
class DataMemberCommand {
	String 				username
	String 				password
	String 				email 
	String  			firstname
	String 	    	    lastname
	String  			address
	String 				image 
	String  			identificationNumber
	String 				codeCard

	static constraints = {
		username  			 nullable:true
		password  			 nullable:true
		email 	  			 nullable:true, validator:emailValidator
		firstname 			 nullable:true
		lastname  			 nullable:true
		address   			 nullable:true
		image 	  			 nullable:true
		codeCard		     nullable:true
		identificationNumber nullable:true, validator:idNValidator
	}

	static final emailValidator = { String value, DataMemberCommand command ->
		if (value){
			if (!this.doLookup(value)) {
				return 'command.email.error'
			}
		}
	}


 
	static boolean doLookup( String address ) throws NamingException {
		
		//catch possition from @
		  int pos = address.indexOf( '@' );
		if ( pos == -1 ) return false;
	
		// catch the domain/machine name and get a list of mail exchangers
		String domain = address.substring( ++pos );
	
		  Hashtable env = new Hashtable();
		env.put("java.naming.factory.initial",
				"com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext( env );
	
		  try{
			  Attributes attrs = ictx.getAttributes( domain, new String("MX"));
			Attribute attr = attrs.get( "MX" );
		}
		  catch (Exception e){
			  return false
		}
		  return true
	}
	


	static final idNValidator = {
		String idValue, def instance  ->
		
		if (idValue) {
			String letters = "TRWAGMYFPDXBNJZSQVHLCKE"
			
			if (
				(idValue.toUpperCase().startsWith("K"))||
				(idValue.toUpperCase().startsWith("L"))||
				(idValue.toUpperCase().startsWith("M")))
			 idValue = idValue.substring(1)
			
			if (
				idValue.toUpperCase().startsWith("X"))
			 idValue = "0" + idValue.substring(1)
			 
			if (
				idValue.toUpperCase().startsWith("Y"))
			 idValue = "1" + idValue.substring(1)

			if (
				idValue.toUpperCase().startsWith("Z"))
			 idValue = "2" + idValue.substring(1);
			 
			Pattern nifPattern = Pattern.compile(
			"(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])")

			Matcher m = nifPattern.matcher(idValue)
			
			if (m.matches()) {
				String letter = m.group(2);
				// Extract letter from DNI/NIF
				int dni = Integer.parseInt(m.group(1));
				dni = dni % 23;
			 
				String reference = letters.substring(dni, dni + 1);
				if (!reference.equalsIgnoreCase(letter)) {
					instance.errors.rejectValue("identificationNumber","user.identificationNumber.error.validator","identification number is not correct")
				}
			}
			else {
				instance.errors.rejectValue("identificationNumber","user.identificationNumber.error.validator","identification number is not correct")
			}
		}			
	}
}
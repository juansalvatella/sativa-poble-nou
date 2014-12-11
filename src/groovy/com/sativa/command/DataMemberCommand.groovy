package com.sativa.command


import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.naming.*
import javax.naming.directory.*

import grails.validation.Validateable

import com.sativa.domain.Partner


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
	Partner				friend

	static constraints = {
		username  			 nullable:true
		password  			 nullable:true
		email 	  			 nullable:true
		lastname  			 nullable:true
		address   			 nullable:true
		image 	  			 nullable:true
		codeCard		     nullable:true
		friend				 nullable:true
		identificationNumber nullable:true
	}

	
}
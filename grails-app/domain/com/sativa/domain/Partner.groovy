package com.sativa.domain

import com.sativa.enums.PartnerStatusEnum

class Partner {

	transient springSecurityService
	Long   				id
	String 				username
	String 				password
	boolean 			enabled = true
	boolean 			accountExpired
	boolean 			accountLocked
	boolean 			passwordExpired
	Date    			dateCreated
	Date                dateRenovation = new Date()
	String 				code
	String 				email 
	String  			firstname
	String 	    	    lastname
	String  			address
	String 				image 
	String  			identificationNumber
	PartnerStatusEnum   status 


	static transients = ['springSecurityService']

	static constraints = {
		username  			 nullable:true
		password  			 nullable:true
		code 	  			 nullable:true
		email 	  			 nullable:true
		firstname 			 nullable:true
		lastname  			 nullable:true
		address   			 nullable:true
		image 	  			 nullable:true
		identificationNumber nullable:true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		PartnerRole.findAllByPartner(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}
		

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}

package com.sativa.domain

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__ENABLED

import com.sativa.enums.GeneticStatusEnum

class Event {

	Long   		id
	Date 		dateCreated
	String 		observation
	String		writer		
	

	static belongsTo 	= [member	: Partner]


	static constraints = {
		
	}
	
}

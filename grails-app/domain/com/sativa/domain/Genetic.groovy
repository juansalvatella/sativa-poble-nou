package com.sativa.domain

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__ENABLED

import com.sativa.enums.GeneticStatusEnum

class Genetic {

	Long   				id
	Date 				dateCreated
	String 				name
	BigDecimal			price
	BigDecimal			grams
	GeneticStatusEnum   status        = GENETIC_STATUS__ENABLED


	static constraints = {
		
	}
	
}

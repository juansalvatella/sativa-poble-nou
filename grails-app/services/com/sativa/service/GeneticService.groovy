package com.sativa.service

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__ENABLED
import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__DISABLED
import com.sativa.enums.GeneticStatusEnum
import grails.transaction.Transactional

import com.sativa.domain.Genetic

class GeneticService {
	
	@Transactional(readOnly = true)
	def list () {
		return Genetic.createCriteria().list {}
	}

	def active () {
		return Genetic.createCriteria().list {
			eq "status", GENETIC_STATUS__ENABLED
		}
	}

	@Transactional
	def create (String name, BigDecimal price, BigDecimal grams) {
		Genetic genetic = new Genetic()
		genetic.name    = name
		genetic.price	= price
		genetic.grams	= grams
		genetic.save(flush:true)
	}

	@Transactional
	def enabled (Genetic genetic) {
		genetic.status  = GENETIC_STATUS__ENABLED
		genetic.save(flush:true)
	}

	@Transactional
	def disabled (Genetic genetic) {
		genetic.status  = GENETIC_STATUS__DISABLED
		genetic.save(flush:true)
	}

}
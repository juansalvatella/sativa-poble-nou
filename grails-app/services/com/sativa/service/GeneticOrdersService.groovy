package com.sativa.service

import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Genetic 
import com.sativa.domain.GeneticOrders

class GeneticOrdersService {

	def eventService


	@Transactional
	def create (Long amount, Partner partner, Genetic genetic) {
		GeneticOrders go = new GeneticOrders()
		go.amount  = amount 
		go.partner = partner
		go.genetic = genetic
		go.save(flush:true)
		eventService.create("Ha retirado un total de ${amount} de Black Valley en la barra", partner)
	}

	@Transactional
	def listGenetics () {
		return GeneticOrders.createCriteria().list {
			 projections{
            	groupProperty("genetic")
        	}
		}
	}

	@Transactional
	def listPeriodicsPerDay() {
		return GeneticOrders.createCriteria().list {
			 projections{
            	groupProperty("partner")
        	}
		}
	}


	@Transactional
	def list(Date currentDay) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:2014, month: currentDay.getMonth(), day: currentDay.getDay(), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end   = start + 1

		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
		}
	}



}
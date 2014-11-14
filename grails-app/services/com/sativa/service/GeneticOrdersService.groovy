package com.sativa.service

import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__BUY
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
		eventService.create("Ha retirado un total de ${amount} de Black Valley en la barra", partner, EVENT_TYPE__BUY)
	}

	@Transactional
	def listGenetics (Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:start.getAt(Calendar.YEAR), month: start.getAt(Calendar.MONTH), date: start.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:start.getAt(Calendar.YEAR), month: start.getAt(Calendar.MONTH), date: start.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		end   = end.getTime()
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			 projections{
            	groupProperty("genetic")
        	}
		}
	}

	@Transactional
	def listPeriodicsPerDay (Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:start.getAt(Calendar.YEAR), month: start.getAt(Calendar.MONTH), date: start.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:start.getAt(Calendar.YEAR), month: start.getAt(Calendar.MONTH), date: start.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		end   = end.getTime()
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			 projections{
            	groupProperty("partner")
        	}
		}
	}


	@Transactional
	def list(Date currentDay) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:currentDay.getAt(Calendar.YEAR), month: currentDay.getAt(Calendar.MONTH), date: currentDay.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end   = start + 1
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
		}
	}



}
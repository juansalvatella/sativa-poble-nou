package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Genetic
import com.sativa.domain.Partner
import java.text.SimpleDateFormat
import java.text.DateFormat



@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class GeneticOrdersController  {
	def geneticOrdersService

	def create(Long memberId, String listGenetics, String listAmount, String signature){
		Partner partner = Partner.get(memberId)
		def genetics = listGenetics.split(',')
		def amounts = listAmount.split(',')
		
		
		genetics.eachWithIndex { gen, index ->
			def genetic 	= Genetic.get(gen)
			def amount 		= amounts[index] as Long
			geneticOrdersService.create(partner, genetic, amount, signature)	
		}
		redirect(controller: "member", action: "show", params:[memberId:memberId])
	}


	def periodic(String start, String end){
		Date auxStart = Date.fromISO(start)
		Date auxEnd   = Date.fromISO(end )
		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay(auxStart, auxEnd)
		stadisticsPerPeriod = stadisticsPerPeriod.collect { go ->
				return [ "partner": go[0],
						 "amount" : go[1] ]
		}
		render(view: "/sativaTemplate/stadistics", model: [page:"genetics",  stadisticsPerPeriod:stadisticsPerPeriod, daySelected:new Date() ,start:auxStart, end:auxEnd])
	}



	def genetics(String start, String end){
		Date auxStart = Date.fromISO(start)
		Date auxEnd   = Date.fromISO(end )
		def listGenetics 	 = geneticOrdersService.listGenetics(auxStart, auxEnd)
		listGenetics		 = listGenetics.collect {go ->
					return ["name"  : go[0],
							"amount": go[1]]
		}
		render(view: "/sativaTemplate/stadistics", model: [page:"periodic",  listGenetics:listGenetics, daySelected:new Date() ,start:auxStart, end:auxEnd])
	}

	def day(String currentDate){
		Date auxDate
		if (!currentDate){
			auxDate = new Date()
		}
		else auxDate = Date.fromISO(currentDate)
		
		def stadisticsPerDay 	 = geneticOrdersService.list(auxDate)

		render(view: "/sativaTemplate/stadistics", model: [stadisticsPerDay:stadisticsPerDay, daySelected:auxDate])
	}

	def stadistics() {
		Date auxDate    = new Date() - 30
		Date auxEndDate = new Date() 
		def stadisticsPerDay 	 = geneticOrdersService.list(auxEndDate)
		def listGenetics 	 = geneticOrdersService.listGenetics(auxDate, auxEndDate)
		listGenetics		 = listGenetics.collect {go ->
					return ["name"  : go[0],
							"amount": go[1]]
		}

		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay(auxDate, auxEndDate)
		stadisticsPerPeriod = stadisticsPerPeriod.collect { go ->
				return [ "partner": go[0],
						 "amount" : go[1] ]
		}
		
		render(view: "/sativaTemplate/stadistics", model: [stadisticsPerDay:stadisticsPerDay, daySelected:auxEndDate, listGenetics:listGenetics, stadisticsPerPeriod:stadisticsPerPeriod, start:auxDate, end:auxEndDate])
	}


}
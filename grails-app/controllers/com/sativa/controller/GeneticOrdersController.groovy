package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Genetic
import com.sativa.domain.Partner
import java.text.SimpleDateFormat
import java.text.DateFormat



@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class GeneticOrdersController  {
	def geneticOrdersService

	def create(Long memberId, Long amount, Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		Partner partner = Partner.read(memberId)
		geneticOrdersService.create(amount, partner, genetic)
		redirect(controller: "memeber", action: "show", params:[memberId:memberId])
	}


	def periodic(String start, String end){
		Date auxStart = Date.fromISO(start)
		Date auxEnd   = Date.fromISO(end )
		def listGenetics 	 = geneticOrdersService.listGenetics(auxStart, auxEnd)
		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay(auxStart, auxEnd)
		render(view: "/sativaTemplate/stadistics", model: [listGenetics:listGenetics, stadisticsPerPeriod:stadisticsPerPeriod, start:auxStart, end:auxEnd])
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
		Date auxDate    = new Date()
		Date auxEndDate = new Date() - 30 
		def stadisticsPerDay 	 = geneticOrdersService.list(auxDate)
		def listGenetics 	 = geneticOrdersService.listGenetics(auxDate, auxEndDate)
		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay(auxDate, auxEndDate)
		println "listGenetics "+listGenetics
		render(view: "/sativaTemplate/stadistics", model: [stadisticsPerDay:stadisticsPerDay, daySelected:auxDate, listGenetics:listGenetics, stadisticsPerPeriod:stadisticsPerPeriod, end:auxEndDate])
	}


}
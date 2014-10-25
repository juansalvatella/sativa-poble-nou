package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Genetic
import com.sativa.domain.Partner



@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class GeneticOrdersController  {
	def geneticOrdersService

	def create(Long memberId, Long amount, Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		Partner partner = Partner.read(memberId)
		geneticOrdersService.create(amount, partner, genetic)
		redirect(controller: "memeber", action: "show", params:[memberId:memberId])
	}


	def periodic(){
		def listGenetics 	 = geneticOrdersService.listGenetics()
		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay()
		render(view: "/sativaTemplate/stadistics", model: [listGenetics:listGenetics, stadisticsPerPeriod:stadisticsPerPeriod])
	}

	def day(Date currentDay){
		println "daaaa "+currentDay
		def stadisticsPerDay 	 = geneticOrdersService.list(currentDay)
		println "ssssss "+stadisticsPerDay
		render(view: "/sativaTemplate/stadistics", model: [stadisticsPerDay:stadisticsPerDay, daySelected:currentDay])
	}
}
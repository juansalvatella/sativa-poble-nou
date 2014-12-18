package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Genetic
import com.sativa.domain.GeneticType



@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class GeneticController  {
	def geneticService

	def list () {
		def listGenetics = geneticService.list()
		def listTypes	 = geneticService.listTypes()
		render(view: "/sativaTemplate/genetics", model: [listGenetics:listGenetics, listTypes:listTypes])
	}

	def create(String name, Long type){
		GeneticType	auxType = GeneticType.get(type)
		geneticService.create(name, auxType)
		redirect(controller: "genetic", action: "list")
	}

	def enabled(Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		geneticService.enabled(genetic)
		redirect(controller: "genetic", action: "list")
	}

	def disabled(Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		geneticService.disabled(genetic)
		redirect(controller: "genetic", action: "list")
	}

	def remove(Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		geneticService.remove(genetic)
		redirect(controller: "genetic", action: "list")
	}

}
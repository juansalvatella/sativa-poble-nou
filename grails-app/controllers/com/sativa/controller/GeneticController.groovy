package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Genetic



@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class GeneticController  {
	def geneticService

	def list () {
		def listGenetics = geneticService.list()
		render(view: "/sativaTemplate/genetics", model: [listGenetics:listGenetics])
	}

	def create(String name){
		geneticService.create(name)
		def listGenetics = geneticService.list()
		redirect(controller: "genetic", action: "list")
	}

	def enabled(Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		geneticService.enabled(genetic)
		def listGenetics = geneticService.list()
		render(view: "/sativaTemplate/genetics", model: [listGenetics:listGenetics])
	}

	def disabled(Long geneticId){
		Genetic genetic = Genetic.read(geneticId)
		geneticService.disabled(genetic)
		def listGenetics = geneticService.list()
		render(view: "/sativaTemplate/genetics", model: [listGenetics:listGenetics])
	}

}
package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Partner

import com.sativa.exception.NotFoundException




@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class PartnerController  {
	def partnerService
	def memberService

	def list() {
		def listPartners = partnerService.list()
		def listMembers  = memberService.list(null, null, null, null)
		println "partnerss "+listPartners
		render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners, listMembers:listMembers])
	}
	

	def add(String username, String password, String repeatPassword, Long partnerId) {
		
		if (password != repeatPassword) {
			def listPartners = partnerService.list()
			render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners, error:"Los passwords deben ser iguales"])		
			return
		}
		Partner partner = Partner.read(partnerId)
		partnerService.add(username, password, partner)
		def listPartners = partnerService.list()
		render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners])
	}

	def remove (Long partnerId) {
		Partner partner = Partner.read(partnerId)
		partnerService.remove(partner)
		def listPartners = partnerService.list()
		render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners])
	}

}
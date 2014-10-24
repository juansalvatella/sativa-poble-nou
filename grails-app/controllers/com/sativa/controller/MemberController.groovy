package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Partner
import com.sativa.command.CreateMemberCommand

import com.sativa.exception.NotFoundException




@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class MemberController  {
	def memberService
	def geneticService

	def search(String firstname, String lastname, String identificationNumber) {
		def listMembers = memberService.search(firstname, lastname, identificationNumber)
		println "listMembers "+listMembers

		render(view: "/sativaTemplate/searchMembers", model: [listMembers:listMembers])


	}

	def list (String firstname, String lastname, String identificationNumber, String code) {
		def listMembers = memberService.list(firstname, lastname, identificationNumber, code)
		render(view: "/sativaTemplate/managementMembers", model: [listMembers:listMembers])
	}

	def create(CreateMemberCommand cpc){
		if (!cpc.validate()) {

		}
		memberService.create(cpc)
		render(view: "/sativaTemplate/searchMembers", model: [listMembers:null])
	}

	def show(Long memberId){
		Partner member = Partner.read(memberId)
		def listGenetics = geneticService.active()
		render(view: "/sativaTemplate/showMember", model: [member:member, listGenetics:listGenetics])
	}

}
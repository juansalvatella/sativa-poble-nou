package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.utils.ImageUtils

import com.sativa.domain.Partner
import com.sativa.command.DataMemberCommand


import com.sativa.exception.NotFoundException




@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class MemberController  {
	def memberService
	def geneticService
	def eventService

	def search(String firstname, String lastname, String identificationNumber) {
		def listMembers = memberService.search(firstname, lastname, identificationNumber)
		render(view: "/sativaTemplate/searchMembers", model: [listMembers:listMembers])


	}

	def list (String firstname, String lastname, String identificationNumber, String code) {
		def listMembers = memberService.list(firstname, lastname, identificationNumber, code)
		render(view: "/sativaTemplate/managementMembers", model: [listMembers:listMembers])
	}

	def create(DataMemberCommand cpc){
		if (!cpc.validate()) {
			println "petaaaaa "+cpc.errors
			return
		}
		def member = memberService.create(cpc)
	
		redirect(controller: "member", action: "showEdit",  params:[memberId:member.id, success:"Se ha editado correctamente"])
	}

	def show(Long memberId){
		Partner member = Partner.read(memberId)
		def listGenetics = geneticService.active()
		def listEvents   = eventService.list(member)
		render(view: "/sativaTemplate/showMember", model: [member:member, listGenetics:listGenetics, listEvents:listEvents])
	}


	def showEdit (Long memberId, DataMemberCommand cpc){
		Partner member = Partner.read(memberId)
		def listEvents   = eventService.list(member)
		render(view: "/sativaTemplate/editMember", model: [member:member,  listEvents:listEvents])

	}


	def edit (Long memberId, DataMemberCommand cpc){
		Partner member = Partner.read(memberId)
		memberService.edit(member, cpc)
		redirect(controller: "member", action: "showEdit",  params:[memberId:memberId])
	}

	def remove(Long memberId, String observation) {
		Partner member = Partner.read(memberId)
		memberService.remove(member, observation)
		redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def activate(Long memberId) {
		Partner member = Partner.read(memberId)
		memberService.activate(member)
		redirect(controller: "member", action: "show",  params:[memberId:memberId])
	}

	def renovation(Long memberId) {
		Partner member = Partner.read(memberId)
		memberService.renovation(member)
		redirect(controller: "member", action: "show",  params:[memberId:memberId])
	}

}
package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.utils.ImageUtils

import com.sativa.domain.Partner
import com.sativa.command.DataMemberCommand


import com.sativa.exception.NotFoundException
import grails.validation.ValidationException




@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class MemberController  {
	def memberService
	def geneticService
	def eventService
	def cardService
	def geneticOrdersService

	def search(String firstname, String lastname, String identificationNumber, String code) {
		def listMembers = memberService.search(firstname, lastname, identificationNumber, code)
		render(view: "/sativaTemplate/searchMembers", model: [listMembers:listMembers])
	}

	def searchInvitate(String firstname, String lastname, String identificationNumber) {
		def listInvitates = memberService.searchInvitate(firstname, lastname, identificationNumber)
		render(view: "/sativaTemplate/showInvitates", model: [listInvitates:listInvitates])
	}



	def list () {
		def listMembers = memberService.list()
		render(view: "/sativaTemplate/searchMembers", model: [listMembers:listMembers])
	}

	def all (String firstname, String lastname, String identificationNumber, String code) {
		def listMembers = memberService.all(firstname, lastname, identificationNumber, code)
		render(view: "/sativaTemplate/managementMembers", model: [listMembers:listMembers])
	}

	def create(DataMemberCommand cpc, Long oldPartner){
		if (!cpc.firstname && !oldPartner){
			if (!cpc.friend) {
				redirect(controller: "card", action: "dispatcher",  params:[num_tarjeta:cpc.codeCard, error:"El nombre es un campo necesario"])
				return	
			}
			else {
				redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend.id, error:"El nombre es un campo necesario"])
				return
			}
			
		}
		def member
		def error 
		if (oldPartner){
			member = Partner.get(oldPartner)
			cardService.add(member, cpc.codeCard)
			error = member
		}
		else {
			error = memberService.create(cpc)
		}



		if (error &&  !(error instanceof Partner) && !cpc.friend) {
			def listMembers = memberService.list("firstname")
			render(view: "/sativaTemplate/createMember", model: [error:error, listMembers:listMembers, numCard:cpc.codeCard])
		}
		else if (error && !(error instanceof Partner)) redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend?.id, error: error])
		else if (error && (error instanceof Partner)) {
			if (cpc.friend ) redirect(controller: "member", action: "guests")
			else redirect(controller: "member", action: "showEdit",  params:[memberId:error.id, success:"Se ha editado correctamente"])
		}
	}

	def show(Long memberId, String error){
		Partner member = Partner.read(memberId)
		def listGenetics 	  = geneticService.active()
		def listEvents   	  = eventService.list(member)
		def listCustomEvents  = eventService.listCustom(member)
		def notification	  = eventService.notification(member)
		def card  		 	  = cardService.cardActive(member)
		def grams			  = geneticOrdersService.grams(member)
		render(view: "/sativaTemplate/showMember", model: [error:error, grams:grams, member:member, notification:notification, card:card, listGenetics:listGenetics, listEvents:listEvents, listCustomEvents:listCustomEvents])
	}


	def invite(Long memberId, String error ){
		render (view:"/sativaTemplate/createMember", model:[error:error, memberId:memberId])
	}


	def showEdit (Long memberId){
		Partner member = Partner.read(memberId)
		def listEvents   = eventService.list(member)
		def notification = eventService.notification(member)
		def card  		 = cardService.cardActive(member)
		render(view: "/sativaTemplate/editMember", model: [card:card, notification:notification, member:member,  listEvents:listEvents])

	}


	def edit (Long memberId, DataMemberCommand cpc){
		Partner member = Partner.get(memberId)
		memberService.edit(member, cpc)
		redirect(controller: "member", action: "showEdit",  params:[memberId:memberId])
	}

	def remove(Long memberId, String observation, String page) {
		Partner member = Partner.get(memberId)
		memberService.remove(member, observation)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:memberId])
		else redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def delete(Long memberId, String observation, String page) {
		Partner member = Partner.get(memberId)
		memberService.delete(member, observation)
		def listMembers = memberService.all(null, null, null, null)
		render(view: "/sativaTemplate/managementMembers", model: [listMembers:listMembers])
	}

	def activate(Long memberId, String page) {
		Partner member = Partner.get(memberId)
		memberService.activate(member)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:memberId])
		else redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def renovation(Long memberId, String page) {
		Partner member = Partner.get(memberId)
		memberService.renovation(member)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:memberId])
		else redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def photo (Long memberId, String image){
		Partner member = Partner.get(memberId)
		memberService.photo(member, image)
		redirect(controller: "member", action: "show", params:[memberId:memberId])
	}


	def guests() {
		def listInvitates = memberService.guests()
		render(view: "/sativaTemplate/showInvitates", model: [listInvitates:listInvitates])
	}
}
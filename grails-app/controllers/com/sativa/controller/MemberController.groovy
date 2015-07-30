package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.utils.ImageUtils

import com.sativa.domain.Partner
import com.sativa.command.DataMemberCommand


import com.sativa.exception.NotFoundException
import grails.validation.ValidationException

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.imageio.ImageIO;


@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class MemberController  {
	def memberService
	def geneticService
	def eventService
	def cardService
	def geneticOrdersService
	def guestHistoricService

	def search(String firstname, String lastname, String identificationNumber, String code) {
		def listMembers = memberService.search(firstname, lastname, identificationNumber, code)
		render(view: "/sativaTemplate/searchMembers", model: [listMembers:listMembers])
	}

	def searchInvitate(String firstname, String lastname, String identificationNumber) {
		def listInvitates = guestHistoricService.searchInvitate(firstname, lastname, identificationNumber)
		render(view: "/sativaTemplate/showInvitates", model: [historicGuests:listInvitates])
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
		if (!cpc.birthday) {
			if (!cpc.friend) {
				redirect(controller: "card", action: "dispatcher",  params:[num_tarjeta:cpc.codeCard, error:"La fecha de nacimiento es necesaria"])
				return	
			}
			else {
				redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend.id, error:"La fecha de nacimiento es necesaria"])
				return
			}
		}

		def stringBirthday = cpc.birthday.split('-');
		def dateBirthday = new Date(stringBirthday[0] as Integer, (stringBirthday[1] as Integer) - 1, stringBirthday[2] as Integer, 0, 0)
		dateBirthday.set(year:stringBirthday[0] as Integer)
		
		def now = new Date() - 18*365

		if (now < dateBirthday) {
			if (!cpc.friend) {
				redirect(controller: "card", action: "dispatcher",  params:[num_tarjeta:cpc.codeCard, error:"¡¡Es menor de edad!!"])
				return	
			}
			else {
				redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend.id, error:"¡¡Es menor de edad!!"])
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
		def pedro
		try {
			def imageAux		  = ImageIO.read(new File("/usr/sativaImages/partners/"+member.code+".png"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 	ImageIO.write(imageAux, "png", bos);
			byte[] imageBytes	  = bos.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
        	pedro = encoder.encode(imageBytes);
        }catch(all){}
		render(view: "/sativaTemplate/showMember", model: [error:error, imagePerson:pedro, grams:grams, member:member, notification:notification, card:card, listGenetics:listGenetics, listEvents:listEvents, listCustomEvents:listCustomEvents])
	}


	def invite(Long memberId, String error ){
		render (view:"/sativaTemplate/createMember", model:[error:error, memberId:memberId])
	}


	def showEdit (Long memberId, String error){
		Partner member 		  = Partner.read(memberId)
		def listEvents   	  = eventService.list(member)
		def notification 	  = eventService.notification(member)
		def card  		 	  = cardService.cardActive(member)
		def numberInvitations = guestHistoricService.numberInvitations(member)
		def grams			  = geneticOrdersService.grams(member)
		def pedro
		try {
			def imageAux		  = ImageIO.read(new File("/usr/sativaImages/partners/"+member.code+".png"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 	ImageIO.write(imageAux, "png", bos);
			byte[] imageBytes	  = bos.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
        	pedro = encoder.encode(imageBytes);
        }catch(all){}
		render(view: "/sativaTemplate/editMember", model: [card:card,imagePerson:pedro, grams:grams,  numberInvitations: numberInvitations, notification:notification, member:member,  listEvents:listEvents, error:error])

	}


	def edit (Long memberId, DataMemberCommand cpc){
		Partner member = Partner.get(memberId)

		def stringBirthday = cpc.birthday.split('-');
		def dateBirthday = new Date(stringBirthday[0] as Integer, (stringBirthday[1] as Integer) - 1, stringBirthday[2] as Integer, 0, 0)
		dateBirthday.set(year:stringBirthday[0] as Integer)
		
		def now = new Date() - 18*365

		if (now < dateBirthday) {
			redirect(controller: "member", action: "showEdit",  params:[memberId:memberId, error:"¡¡Es menor de edad!!"])	
			return
		}
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
		def historicGuests = guestHistoricService.historic()
		def listInvitates = memberService.guests()
		render(view: "/sativaTemplate/showInvitates", model: [historicGuests:historicGuests, listInvitates:listInvitates])
	}
}

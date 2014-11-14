package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Card
import com.sativa.domain.Partner





@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class CardController  {
	def eventService


	def dispatcher(String num_tarjeta){
		def card = Card.findByCode(num_tarjeta)
		if (!card) {
			render(view: "/sativaTemplate/createMember", model: [numCard:num_tarjeta])
		}
		else {
			redirect(controller: "member", action: "show", params:[memberId:card.member.id])	
		}	
		
	}


}
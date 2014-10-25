package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Event
import com.sativa.domain.Partner





@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class EventController  {
	def eventService


	def create(String observation, Long partnerId) {
		Partner partner = Partner.read(partnerId)
		
		eventService.create(observation, partner)
		redirect(controller: "member", action: "show", params:[memberId:partnerId])
	}


}
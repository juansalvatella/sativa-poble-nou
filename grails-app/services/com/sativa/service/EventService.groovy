package com.sativa.service

import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Event

class EventService {

	def springSecurityService
	
	@Transactional(readOnly = true)
	def list (Partner partner) {
		return Event.createCriteria().list {
			eq "member", partner
			order("dateCreated", "desc")
		}
	}


	@Transactional
	def create (String observation, Partner partner) {
		Event event 		 = new Event()
		event.writer 		 = springSecurityService.currentUser.username
		event.observation	 = observation
		event.member		 = partner 
		event.save(flush:true)
	}


}
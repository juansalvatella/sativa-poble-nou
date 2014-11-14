package com.sativa.service

import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Event

import com.sativa.enums.EventTypeEnum
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
	def create (String observation, Partner partner, EventTypeEnum type) {
		Event event 		 = new Event()
		event.writer 		 = springSecurityService.currentUser.username
		event.observation	 = observation
		event.member		 = partner 
		event.type			 = type
		event.save(flush:true)
	}


}
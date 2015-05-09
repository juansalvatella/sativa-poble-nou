package com.sativa.service

import com.sativa.domain.Partner
import com.sativa.domain.GuestHistoric

import grails.transaction.Transactional
class GuestHistoricService {
	
	@Transactional
	def add (Partner guest, Partner friend) {
		GuestHistoric gh = new GuestHistoric()
		gh.guest 	= guest
		gh.entry    = new Date()
		gh.friend   = friend
		def ghList = GuestHistoric.createCriteria().list {
			eq "guest", guest
			order("id", "asc")
		}
		gh.numberEntries = this.numberInvitations(guest)
		gh.save(flush:true)
	}

	@Transactional
	def historic (){
		def ghList = GuestHistoric.createCriteria().list {
			order("entry", "desc")
		}

	}

	@Transactional
	def numberInvitations (Partner guest ) {
		def ghList = GuestHistoric.createCriteria().list {
			eq "guest", guest
			order("id", "asc")
		}
		if (ghList && !ghList.isEmpty()){
			return ghList.last().numberEntries+1
		}
		else return 1
	}

	@Transactional
	def lastFriend(Partner guest) {
		def ghList = GuestHistoric.createCriteria().list {
			eq "guest", guest
			order("id", "asc")
		}?.last().friend
	}
}
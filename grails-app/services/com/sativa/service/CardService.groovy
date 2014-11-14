package com.sativa.service

import static com.sativa.enums.CardStatusEnum.CARD_STATUS__ACTIVED
import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Card


class CardService {


	@Transactional
	def cardActive (Partner member) {
		return Card.createCriteria().get {
			eq "status", CARD_STATUS__ACTIVED
			eq "member", member
		}
	}


}
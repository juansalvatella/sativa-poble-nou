package com.sativa.service

import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__BANNED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__ACTIVED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DISABLED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__UNKNOWN
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__INVITE
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DETOXIFIED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__REMOVED




import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__ACTIVATE
import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__DISABLED
import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__NEW_CARD
import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__NEW_USER
import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__RENOVATE





import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.PartnerRole
import com.sativa.domain.Role
import com.sativa.domain.Card
import com.sativa.enums.PartnerStatusEnum
import com.sativa.command.DataMemberCommand


import com.sativa.utils.ImageUtils

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class MemberService {

	def eventService
	def grailsApplication
	def cardService
	def guestHistoricService

	@Transactional(readOnly = true)
	def search (String firstname, String lastname, String identificationNumber, String code) {
		return Partner.createCriteria().list {
			order("code", "asc")
			and {
				or {
					if (firstname){
						ilike 'firstname', "%${firstname}%"
					}
					if (lastname){
						ilike 'lastname', "%${lastname}%"
					}
					if (identificationNumber){
						ilike 'identificationNumber', "%${identificationNumber}%"
					}
					if (code){
						ilike "code", "%${code}%" 
					}
				}
				if (!identificationNumber){
					ne "status", PARTNER_STATUS__DISABLED
					ne "status", PARTNER_STATUS__BANNED
					ne "status", PARTNER_STATUS__INVITE
				}
			}
			ne "status", PARTNER_STATUS__REMOVED
		}

	}

	@Transactional(readOnly = true)
	def searchInvitate (String firstname, String lastname, String identificationNumber) {
		return Partner.createCriteria().list {
			order("code", "asc")
			and {
				or {
					if (firstname){
						ilike 'firstname', "%${firstname}%"
					}
					if (lastname){
						ilike 'lastname', "%${lastname}%"
					}
					if (identificationNumber){
						ilike 'identificationNumber', "%${identificationNumber}%"
					}
				}
				eq "status", PARTNER_STATUS__INVITE
			}
		}
	}

	


	@Transactional(readOnly = true)
	def list (String orderParam) {
			return Partner.createCriteria().list {
				or {
					eq "status", PARTNER_STATUS__ACTIVED
					eq "status", PARTNER_STATUS__UNKNOWN
					eq "status", PARTNER_STATUS__DETOXIFIED
				}
				if (orderParam) order (orderParam, "asc")
				else order("id", "asc")
			}
	}

	@Transactional(readOnly = true)
	def list2 (String orderParam) {
			def users = PartnerRole.createCriteria().list(){
				eq "role", Role.findByAuthority(Role.ROLE_SELLER)
				projections {
					distinct "partner.id"
				}
			}
			return Partner.createCriteria().list {
				not { 'in' "id", users }
				or {
					eq "status", PARTNER_STATUS__ACTIVED
					eq "status", PARTNER_STATUS__UNKNOWN
					eq "status", PARTNER_STATUS__DETOXIFIED
				}
				if (orderParam) order (orderParam, "asc")
				else order("id", "asc")
			}
	}



	@Transactional(readOnly = true)
	def guests () {
			return Partner.createCriteria().list {
				eq "status", PARTNER_STATUS__INVITE
				order("id", "desc")
			}
	}


	@Transactional(readOnly = true)
	def all (String firstname, String lastname, String identificationNumber, String code) {
			return Partner.createCriteria().list {
				order("id", "desc")
				if (firstname){
					ilike 'firstname', "%${firstname}%"
				}
				if (lastname){
					ilike 'lastname', "%${lastname}%"
				}
				if (identificationNumber){
					ilike 'identificationNumber', "%${identificationNumber}%"
				}
				if (code){
					ilike "code", "%${code}%" 
				}
				ne "status", PARTNER_STATUS__INVITE
				ne "status", PARTNER_STATUS__REMOVED

			}
	}

	@Transactional
	def create(DataMemberCommand cpc){
		if (!cpc.identificationNumber) return "El dni es obligatorio"
		def existUser = Partner.createCriteria().list {
				eq "identificationNumber", cpc.identificationNumber
				ne "status", PARTNER_STATUS__INVITE
				ne "status", PARTNER_STATUS__REMOVED
		}
		if (existUser) {
			return "El dni ya existe"
		}

		Date now 		   = new Date()
    	String dayString   = now.getAt(Calendar.DATE)
		String monthString = now.getAt(Calendar.MONTH)+1
		String yearString  = now.getAt(Calendar.YEAR)
		yearString 		   = yearString.substring(2)

		def start = Calendar.instance
		start.set(year:now.getAt(Calendar.YEAR), month: now.getAt(Calendar.MONTH), date: now.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		Date end = start + 1
		def count = Partner.createCriteria().count {
			between "dateCreated", start, end
		}
		String countString = count as String


		Partner partner = new Partner()
		boolean addGuess = false
		if (cpc.friend) {
        	if (!cpc.image){
        		return "La foto para usuarios invitados es obligatoria"
        	}
        	def existUserInvitate = Partner.createCriteria().get {
				eq "identificationNumber", cpc.identificationNumber
				eq "status", PARTNER_STATUS__INVITE
			}
			if (existUserInvitate) partner = existUserInvitate
			else {
				partner.status = PARTNER_STATUS__INVITE
				partner.code = dayString+monthString+yearString+countString.padLeft(3,'0')
			}
        	addGuess = true
        	
    	}
    	else {
    		partner.code = dayString+monthString+yearString+countString.padLeft(3,'0')
    	}
		partner.phone 				 = cpc.phone
		partner.firstname			 = cpc.firstname
		partner.lastname 			 = cpc.lastname
		partner.address 			 = cpc.address
		partner.identificationNumber = cpc.identificationNumber
		
    	
    	
		
		

		if (cpc.image) {
		 	def applicationContext = grailsApplication.mainContext
    		String basePath = applicationContext.getResource("/").getFile().toString()
			BufferedImage newImg = ImageUtils.decodeToImage(cpc.image);
        	ImageIO.write(newImg, "png", new File("${basePath}/css/img/partners/"+partner.code+".png"))
        	partner.image = partner.code+".png"
        }


    	if (!cpc.friend && (!cpc.firstname || !cpc.image || !cpc.lastname || !cpc.address || !cpc.codeCard || !cpc.identificationNumber || !cpc.phone)) {
    		partner.status = PARTNER_STATUS__UNKNOWN
    	}
    	else if (!cpc.friend) partner.status = PARTNER_STATUS__ACTIVED
    
    	partner.save(flush:true)

    	if (addGuess){
    		guestHistoricService.add(partner, cpc.friend)
    	}


		if (cpc.codeCard) {
			cardService.add(partner, cpc.codeCard)
		}
		return partner
	}

	@Transactional
	def edit(Partner partner, DataMemberCommand cpc){
		partner.phone 				 = cpc.phone
		partner.firstname			 = cpc.firstname
		partner.lastname 			 = cpc.lastname
		partner.address 			 = cpc.address
		
		partner.identificationNumber = cpc.identificationNumber

		if (cpc.image) {
		 	def applicationContext = grailsApplication.mainContext
    		String basePath = applicationContext.getResource("/").getFile().toString()
			BufferedImage newImg = ImageUtils.decodeToImage(cpc.image);
        	ImageIO.write(newImg, "png", new File("${basePath}/css/img/partners/"+partner.code+".png"))
        	partner.image = partner.code+".png"
    	}

    	if (partner.status == PARTNER_STATUS__ACTIVED && !partner.firstname || !partner.image || !partner.lastname || !partner.address || !partner.identificationNumber || !partner.phone) {
    		partner.status = PARTNER_STATUS__UNKNOWN
    	}

    	else if (partner.status == PARTNER_STATUS__UNKNOWN && partner.firstname && partner.image && partner.lastname && partner.address && partner.identificationNumber && partner.phone) {
    		partner.status = PARTNER_STATUS__ACTIVED
    	}
    	
		
		partner.save(flush:true)
	}


	@Transactional
	def remove(Partner member, String observation) {
		member.status = PARTNER_STATUS__BANNED
		member.save()
		String textObservation = "El usuarios ha sido desactivado. "+observation
		eventService.create(textObservation, member, EVENT_TYPE__DISABLED)
	}


	@Transactional
	def delete(Partner member, String observation) {
		member.status = PARTNER_STATUS__REMOVED
		member.save()
		String textObservation = "El usuarios ha sido eliminado. "+observation
		eventService.create(textObservation, member, EVENT_TYPE__DISABLED)
	}


	@Transactional
	def activate(Partner member) {
		member.status = PARTNER_STATUS__ACTIVED
		member.save()
		String observation = "Se ha activado correctamente"
		eventService.create(observation, member, EVENT_TYPE__ACTIVATE)
	}


	@Transactional
	def renovation(Partner member) {
		member.status = PARTNER_STATUS__ACTIVED
		member.dateRenovation = new Date()
		member.save()
		String observation = "Se ha renovado correctamente"
		eventService.create(observation, member, EVENT_TYPE__RENOVATE)
	}

	@Transactional
	def photo(Partner member, String image) {
		def applicationContext = grailsApplication.mainContext
    	String basePath = applicationContext.getResource("/").getFile().toString()
		BufferedImage newImg = ImageUtils.decodeToImage(image);
        ImageIO.write(newImg, "png", new File("${basePath}/css/img/partners/"+member.code+".png"))
        member.image = member.code+".png"
        if (member.status == PARTNER_STATUS__UNKNOWN && member.firstname && member.image && member.lastname && member.address && member.identificationNumber && member.phone) {
    		member.status = PARTNER_STATUS__ACTIVED
    	}
        member.save(flush:true)
	}
}
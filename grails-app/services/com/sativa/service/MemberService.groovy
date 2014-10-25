package com.sativa.service

import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__BANNED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__ACTIVED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DISABLED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__UNKNOWN



import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.enums.PartnerStatusEnum
import com.sativa.command.DataMemberCommand


import com.sativa.utils.ImageUtils

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class MemberService {

	def eventService
	def grailsApplication

	@Transactional(readOnly = true)
	def search (String firstname, String lastname, String identificationNumber) {
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
				}
			}

	}


	@Transactional(readOnly = true)
	def list (String firstname, String lastname, String identificationNumber, String code) {
			return Partner.createCriteria().list {
				order("code", "asc")
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
					eq "code", code
				}
			}
	}

	@Transactional
	def create(DataMemberCommand cpc){
		Partner partner 			 = new Partner()
		partner.code				 = cpc.code
		partner.email 				 = cpc.email
		partner.firstname			 = cpc.firstname
		partner.lastname 			 = cpc.lastname
		partner.address 			 = cpc.address
		partner.identificationNumber = cpc.identificationNumber
		
		if (cpc.image) {
		 	println "save image "
		 	def applicationContext = grailsApplication.mainContext
    		String basePath = applicationContext.getResource("/").getFile().toString()
			BufferedImage newImg = ImageUtils.decodeToImage(cpc.image);
        	ImageIO.write(newImg, "png", new File("${basePath}/css/img/partners/prueba.png"))
        	partner.image = "prueba.png"
        	println "image"
        	partner.status = PARTNER_STATUS__ACTIVED
    	}
    	else {
    		partner.status = PARTNER_STATUS__UNKNOWN
    	}
		partner.save(flush:true)
		return partner
	}

	@Transactional
	def edit(Partner partner, DataMemberCommand cpc){
		partner.code				 = cpc.code
		partner.email 				 = cpc.email
		partner.firstname			 = cpc.firstname
		partner.lastname 			 = cpc.lastname
		partner.address 			 = cpc.address
		
		partner.identificationNumber = cpc.identificationNumber

		if (cpc.image) {
		 	println "save image "
		 	def applicationContext = grailsApplication.mainContext
    		String basePath = applicationContext.getResource("/").getFile().toString()
			BufferedImage newImg = ImageUtils.decodeToImage(cpc.image);
        	ImageIO.write(newImg, "png", new File("${basePath}/css/img/partners/prueba.png"))
        	partner.image = "prueba.png"
        	println "image"
        	partner.status = PARTNER_STATUS__ACTIVED
    	}
    	else {
			partner.status = PARTNER_STATUS__UNKNOWN
		}
		
		partner.save(flush:true)
	}


	@Transactional
	def remove(Partner member, String observation) {
		member.status = PARTNER_STATUS__BANNED
		member.save()
		String textObservation = "El usuarios ha sido desactivado. "+observation
		eventService.create(textObservation, member)
	}


	@Transactional
	def activate(Partner member) {
		member.status = PARTNER_STATUS__ACTIVED
		member.save()
		String observation = "Se ha activado correctamente"
		eventService.create(observation, member)
	}


	@Transactional
	def renovation(Partner member) {
		member.status = PARTNER_STATUS__ACTIVED
		member.save()
		String observation = "Se ha renovado correctamente"
		eventService.create(observation, member)
	}
}
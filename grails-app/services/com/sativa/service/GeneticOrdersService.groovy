package com.sativa.service

import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__BUY
import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Genetic 
import com.sativa.domain.GeneticOrders

import com.sativa.utils.ImageUtils

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class GeneticOrdersService {

	def eventService
	def grailsApplication


	@Transactional
	def create ( Partner partner, Genetic genetic, Long amount, String signature) {
		GeneticOrders go = new GeneticOrders()
		go.amount  = amount 
		go.partner = partner
		go.genetic = genetic
		go.save(flush:true)


		def applicationContext = grailsApplication.mainContext
    	String basePath = applicationContext.getResource("/").getFile().toString()
    	BufferedImage newImg = ImageUtils.decodeToImage(signature)

        ImageIO.write(newImg, "jpg", new File("${basePath}/css/img/geneticOrdersSigns/"+go.id+".png"))		
	
	}


	@Transactional
	def grams (Partner partner) {
		def auxStart = new Date()
		def start = Calendar.instance
		def end = Calendar.instance
	
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date:  0, hourOfDay:24, minute:00, second:0)
		start = start.getTime()
		end.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: 1, hourOfDay:24, minute:0, second:0)
		end.set(date:end.getActualMaximum( Calendar.DATE))
		end   = end.getTime()

		println "----"
		println start 
		println end 
		def listGenetics =  GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			eq "partner", partner
		}
		def countGrams = 0
		listGenetics.each { go->
			countGrams += go.genetic.type.grams*go.amount
		}
		return countGrams
	}

	@Transactional
	def listGenetics (Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: auxStart.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:auxEnd.getAt(Calendar.YEAR), month: auxEnd.getAt(Calendar.MONTH), date: auxEnd.getAt(Calendar.DATE), hourOfDay:24, minute:0, second:0)
		end   = end.getTime()
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			 projections{
            	groupProperty("genetic")
            	sum("amount")
        	}
		}
	}

	@Transactional
	def listPeriodicsPerDay (Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: auxStart.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:auxEnd.getAt(Calendar.YEAR), month: auxEnd.getAt(Calendar.MONTH), date: auxEnd.getAt(Calendar.DATE), hourOfDay:24, minute:0, second:0)
		end   = end.getTime()
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			 projections{
            	groupProperty("partner")
            	sum("amount")
        	}
		}
	}


	@Transactional
	def list(Date currentDay) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:currentDay.getAt(Calendar.YEAR), month: currentDay.getAt(Calendar.MONTH), date: currentDay.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end   = start + 1
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
		}
	}



}
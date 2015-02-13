package com.sativa.jobs

import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DETOXIFIED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__ACTIVED
import groovy.time.TimeCategory

import com.sativa.domain.Partner


class PartnerRenovationJob {
	
	
    	
    static triggers = {
		// Execucio cada  hora al minuto 1 al  segon 30
		cron name:'partnerRenovationJob', cronExpression: '30 1 0/1 * * ?' 
    }
	
	def execute() {
		log.info "startpartnerrenovation"
		Date maxDetoxified = new Date()
		use(TimeCategory){
			maxDetoxified = maxDetoxified - 3.month
		}
		def partners = Partner.createCriteria().list {
			eq "status", PARTNER_STATUS__ACTIVED
			le "dateRenovation", maxDetoxified
		}

		partners.each {Partner p->
			p.status = PARTNER_STATUS__DETOXIFIED
			p.save(flush:true)
		}
	}
	
	
}




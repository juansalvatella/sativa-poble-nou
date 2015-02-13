package com.sativa.jobs

import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DETOXIFIED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DISABLED
import groovy.time.TimeCategory

import com.sativa.domain.Partner

class PartnerDisabledJob {
	
	
    static triggers = {
		// Execucio cada hora al minuto 1 segundo 10
		cron name:'partnerDisabledJob', cronExpression: '10 1 0/10 * * ?' 
		
    }
	
	
	def execute() {
		log.info "startpartnerdisabled"
		Date maxDisabled = new Date()
		use(TimeCategory){
			maxDisabled = maxDisabled - 1.year
		}
		def partners = Partner.createCriteria().list {
			eq "status", PARTNER_STATUS__DETOXIFIED
			le "dateRenovation", maxDisabled
		}
		partners.each {Partner p->
			p.status = PARTNER_STATUS__DISABLED
			p.save(flush:true)
		}
	}
	
	
}

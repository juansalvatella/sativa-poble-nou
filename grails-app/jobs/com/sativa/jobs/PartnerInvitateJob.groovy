package com.sativa.jobs

import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__INVITE
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DISABLED
import groovy.time.TimeCategory

import com.sativa.domain.Partner

class PartnerInvitateJob {
	
	
    static triggers = {
		// Execucio cada 4 minuts al segon 10
		cron name:'partnerInvitateJob', cronExpression: '10 0/10 * * * ?' 
    }
	
	
	def doJobTask() {
		Date maxInvitation = new Date()
		use(TimeCategory){
			maxInvitation = maxInvitation - 24.hours
		}
		def partners = Partner.createCriteria().list {
			eq "status", PARTNER_STATUS__INVITE
			le "dateCreated", maxInvitation
		}

		partners.each {Partner p->
			p.status = PARTNER_STATUS__DISABLED
			p.save(flush:true)
		}
	}
	
	
}

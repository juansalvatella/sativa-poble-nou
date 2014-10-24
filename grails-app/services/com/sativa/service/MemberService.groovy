package com.sativa.service


import grails.transaction.Transactional

import com.sativa.domain.Partner

class MemberService {
	
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
}
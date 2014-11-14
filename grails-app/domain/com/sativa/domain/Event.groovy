package com.sativa.domain

import com.sativa.enums.EventTypeEnum

class Event {

	Long   			id
	Date 			dateCreated
	String 			observation
	String			writer		
	EventTypeEnum	type

	static belongsTo 	= [member	: Partner]


	static constraints = {
		
	}
	
}

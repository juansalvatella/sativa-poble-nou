package com.sativa.controller

import grails.plugin.springsecurity.annotation.Secured;

import javax.servlet.http.HttpServletResponse


/**
 * <p>Logout the authenticated user.</p> 
 * <p>Accessed by /j_spring_security_logout.</p>
 * 
 * 	@author 9smartpark S.L
 */
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class LogoutController {

	/**
	 * Logout success callback
	 * @return <p>200 with json translated description.</p>	
	 */
	def success() {
		render(view: "/sativaTemplate/login")
	}
}

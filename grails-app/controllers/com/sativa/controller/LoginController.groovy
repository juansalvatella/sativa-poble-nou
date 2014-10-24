package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured

import javax.servlet.http.HttpServletResponse

import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

import com.sativa.exception.SativaAuthException

import com.sativa.domain.Partner

import com.sativa.exception.NotFoundException




@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class LoginController  {
	
	/**
	 * Dependency injection for the authenticationTrustResolver.
	 */
	def authenticationTrustResolver

	/**
	 * Dependency injection for the springSecurityService.
	 */
	def springSecurityService



	/**
	 * <p>Success login</p>
	 * Entry in this function when de login is successful
	 * @return Return the next json :
	 * balance: {
	 *	 - equivalence: 
	 *	 - reserved:
	 *   - total: 
	 * }
	 * created: 
	 * id: 
	 * message: 
	 * name: 
	 * reservations: {
	 *	extendable: [{id:, name:, address:, start:, end:,…}]
	 *	pending: 
	 * }
	 * roles: [,..]
	 * status: 
	 * username: 
	 */
	def success() {
		log.info "Entry to success"
		println "successssssss"
		Partner user = springSecurityService.currentUser
		if (!user) {
			render (status:HttpServletResponse.SC_UNAUTHORIZED,
				contentType:'text/json'){
				["error":message(code:"login.denied.unauthorized")]
			}
			return
		}
		render(view: "/sativaTemplate/login", model: [username:user.username])
	}
	
	def ajaxSuccess() {
		log.info "Entry to ajax success"
		def user = springSecurityService.currentUser
		if (!user) {
			render (status:HttpServletResponse.SC_UNAUTHORIZED, contentType:'text/json'){
				["error":message(code:"login.denied.unauthorized")]
			}
			return
		}
		
		
		render (status:HttpServletResponse.SC_OK, contentType:'text/json'){ "success" }
	}
		
	/**
	 * Return denied json.
	 */
	def denied() {
		log.info "Entry to denied"
		render (status:HttpServletResponse.SC_FORBIDDEN,
			contentType:'text/json'){
			['error':message(code:"login.denied.unauthorized")]
		}
	}
	
	def ajaxDenied() {
		log.info "Entry to ajax denied"
		render (status:HttpServletResponse.SC_FORBIDDEN,
			contentType:'text/json'){
			['error':message(code:"login.denied.unauthorized")]
		}
	}

	/**
	 * Callback after a failed login. Redirects to the auth page with a warning message.
	 */
	def authfail() {
		println "authfaillllllllllllllllll"
		def aaa = session[UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY]

		println "username=== "+aaa

		String msg = message(code:'login.denied.undefined')
		def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
		if (exception) {
			if (exception instanceof SativaAuthException) {
				msg = message(code:"login.denied.invalidRole")
			} 
			else if (exception instanceof AccountExpiredException) {
				msg = message(code:"login.denied.expired")
			}
			else if (exception instanceof CredentialsExpiredException) {
				msg = message(code:"login.denied.passwordExpired")
			}
			else if (exception instanceof DisabledException) {
				String username = session[UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY]?.decodeHTML()
				def currentUser = Partner.findByUsername(username);
				if (!currentUser){
					throw new NotFoundException()
				}
				msf = "AEREDSA"
			}
			else if (exception instanceof LockedException) {
				msg = message(code:"login.denied.locked")
			}
			else {
				msg = message(code:"login.denied.fail")
			}
		}
		render (view:"/sativaTemplate/login", model:[error:msg])
		
	}
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	def checkSession() {
		render (status:HttpServletResponse.SC_OK)
	}
}
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatemanagementMembers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/managementMembers.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',2,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('form','g',73,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'all',controller:'member'])],1)
printHtmlPart(3)
if(true && (listMembers)) {
printHtmlPart(4)
for( _it202457351 in (listMembers) ) {
changeItVariable(_it202457351)
printHtmlPart(5)
expressionOut.print(it.code)
printHtmlPart(6)
expressionOut.print(it.firstname)
printHtmlPart(7)
expressionOut.print(it.lastname)
printHtmlPart(6)
expressionOut.print(it.identificationNumber)
printHtmlPart(8)
if(true && (it.status.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(9)
invokeTag('img','g',95,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(10)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(9)
invokeTag('img','g',98,['dir':("css/img"),'file':("semaforoAzul.jpg ")],-1)
printHtmlPart(10)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(9)
invokeTag('img','g',101,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(10)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(9)
invokeTag('img','g',104,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(10)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(9)
invokeTag('img','g',107,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(10)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(9)
invokeTag('img','g',110,['dir':("css/img"),'file':("semaforoLila.jpg")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(createLink(controller:'member', action:'showEdit', params:[memberId:it.id]))
printHtmlPart(12)
expressionOut.print(it.id)
printHtmlPart(13)
}
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('render','g',144,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425592697000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

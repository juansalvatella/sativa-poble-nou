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
expressionOut.print(listMembers?.size())
printHtmlPart(4)
if(true && (listMembers)) {
printHtmlPart(5)
for( _it39149205 in (listMembers) ) {
changeItVariable(_it39149205)
printHtmlPart(6)
expressionOut.print(it.code)
printHtmlPart(7)
expressionOut.print(it.firstname)
printHtmlPart(8)
expressionOut.print(it.lastname)
printHtmlPart(7)
expressionOut.print(it.identificationNumber)
printHtmlPart(9)
if(true && (it.status.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(10)
invokeTag('img','g',96,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(11)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(10)
invokeTag('img','g',99,['dir':("css/img"),'file':("semaforoAzul.jpg ")],-1)
printHtmlPart(11)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(10)
invokeTag('img','g',102,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(11)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(10)
invokeTag('img','g',105,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(11)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(10)
invokeTag('img','g',108,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(11)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(10)
invokeTag('img','g',111,['dir':("css/img"),'file':("semaforoLila.jpg")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(createLink(controller:'member', action:'showEdit', params:[memberId:it.id]))
printHtmlPart(13)
expressionOut.print(it.id)
printHtmlPart(14)
}
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('render','g',145,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434307901000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
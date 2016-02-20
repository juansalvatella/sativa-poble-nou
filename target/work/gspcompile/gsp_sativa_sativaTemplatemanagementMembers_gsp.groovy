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
createTagBody(1, {->
printHtmlPart(2)
invokeTag('set','g',73,['var':("isGreen"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',74,['var':("isYellow"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',75,['var':("isOrange"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',76,['var':("isRed"),'value':("false")],-1)
printHtmlPart(4)
for( _it341167646 in (statusMembers) ) {
changeItVariable(_it341167646)
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__ACTIVED")) {
printHtmlPart(6)
invokeTag('set','g',81,['var':("isGreen"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__UNKNOWN")) {
printHtmlPart(6)
invokeTag('set','g',84,['var':("isYellow"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__DETOXIFIED")) {
printHtmlPart(6)
invokeTag('set','g',87,['var':("isOrange"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__BANNED")) {
printHtmlPart(6)
invokeTag('set','g',90,['var':("isRed"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(3)
}
printHtmlPart(7)
invokeTag('img','g',96,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(6)
if(true && (isGreen == 'true')) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('img','g',105,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(6)
if(true && (isYellow == 'true')) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(10)
invokeTag('img','g',114,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(6)
if(true && (isOrange == 'true')) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('img','g',123,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(6)
if(true && (isRed == 'true')) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('form','g',137,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'all',controller:'member'])],1)
printHtmlPart(19)
expressionOut.print(listMembers?.totalCount)
printHtmlPart(20)
if(true && (listMembers)) {
printHtmlPart(21)
for( _it223288832 in (listMembers) ) {
changeItVariable(_it223288832)
printHtmlPart(22)
expressionOut.print(it.code)
printHtmlPart(23)
expressionOut.print(it.firstname)
printHtmlPart(24)
expressionOut.print(it.lastname)
printHtmlPart(23)
expressionOut.print(it.identificationNumber)
printHtmlPart(25)
if(true && (it.status.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(26)
invokeTag('img','g',162,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(27)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(26)
invokeTag('img','g',165,['dir':("css/img"),'file':("semaforoAzul.jpg ")],-1)
printHtmlPart(27)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(26)
invokeTag('img','g',168,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(27)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(26)
invokeTag('img','g',171,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(27)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(26)
invokeTag('img','g',174,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(27)
}
else if(true && (it.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(26)
invokeTag('img','g',177,['dir':("css/img"),'file':("semaforoLila.jpg")],-1)
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(createLink(controller:'member', action:'showEdit', params:[memberId:it.id]))
printHtmlPart(29)
expressionOut.print(it.id)
printHtmlPart(30)
if(true && (it.consum.name() == 'CONSUM_THERAPEUTIC')) {
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
}
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (offset==0)) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (listMembers.size() < 50)) {
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
invokeTag('render','g',235,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(43)
expressionOut.print(offset)
printHtmlPart(44)
expressionOut.print(offset)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1455967220000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

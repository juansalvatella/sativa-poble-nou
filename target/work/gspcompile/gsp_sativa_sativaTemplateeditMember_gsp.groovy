import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplateeditMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/editMember.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
if(true && (success)) {
printHtmlPart(2)
expressionOut.print(success)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (member.image)) {
printHtmlPart(5)
invokeTag('img','g',16,['dir':("css/img/partners"),'file':(member.image),'width':("200"),'height':("180")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('img','g',19,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(6)
}
printHtmlPart(5)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(8)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(member.code)
printHtmlPart(11)
invokeTag('formatDate','g',32,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(12)
invokeTag('formatDate','g',35,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(13)
expressionOut.print(card?.code)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
expressionOut.print(member.id)
printHtmlPart(16)
expressionOut.print(member.firstname)
printHtmlPart(17)
expressionOut.print(member.lastname)
printHtmlPart(18)
expressionOut.print(member.identificationNumber)
printHtmlPart(19)
expressionOut.print(member.address)
printHtmlPart(20)
expressionOut.print(member.email)
printHtmlPart(21)
})
invokeTag('form','g',79,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(22)
for( _it575244400 in (listGenetics) ) {
changeItVariable(_it575244400)
printHtmlPart(23)
expressionOut.print(it.name)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('cookie','g',100,['name':("myCookie")],-1)
printHtmlPart(26)
createTagBody(1, {->
printHtmlPart(27)
expressionOut.print(member.id)
printHtmlPart(28)
})
invokeTag('form','g',107,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(29)
for( _it161252006 in (listEvents) ) {
changeItVariable(_it161252006)
printHtmlPart(30)
expressionOut.print(it.writer)
printHtmlPart(31)
invokeTag('formatDate','g',110,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(32)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(33)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(34)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(it.observation)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(40)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(41)
}
printHtmlPart(42)
invokeTag('set','g',141,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(43)
invokeTag('set','g',142,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(43)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(44)
invokeTag('set','g',144,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(43)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(44)
invokeTag('set','g',147,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(43)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(44)
invokeTag('set','g',150,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(43)
}
printHtmlPart(45)
createTagBody(1, {->
printHtmlPart(46)
expressionOut.print(member.id)
printHtmlPart(47)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(48)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(51)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(52)
}
printHtmlPart(53)
})
invokeTag('form','g',175,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(54)
invokeTag('render','g',190,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(55)
expressionOut.print(member.status.name())
printHtmlPart(56)
expressionOut.print(member.status.name())
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416352707000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

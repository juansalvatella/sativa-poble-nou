import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplateshowMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/showMember.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
expressionOut.print(resource(dir:'js/scriptsSativa', file: 'signature.js'))
printHtmlPart(2)
if(true && (member.image)) {
printHtmlPart(3)
invokeTag('img','g',13,['dir':("css/img/partners"),'file':(member.image),'width':("225"),'height':("180")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('img','g',16,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(member.id)
printHtmlPart(9)
})
invokeTag('form','g',25,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],1)
printHtmlPart(10)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('ifAllGranted','sec',30,['roles':("ROLE_ADMIN")],2)
printHtmlPart(3)
}
printHtmlPart(13)
expressionOut.print(member.firstname)
printHtmlPart(14)
expressionOut.print(member.lastname)
printHtmlPart(15)
expressionOut.print(member.identificationNumber)
printHtmlPart(16)
expressionOut.print(member.address)
printHtmlPart(17)
expressionOut.print(member.email)
printHtmlPart(18)
invokeTag('formatDate','g',41,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',42,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(20)
expressionOut.print(card?.code)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
expressionOut.print(member.id)
printHtmlPart(23)
})
invokeTag('form','g',58,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(24)
if(true && ((member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams > 90.00)) {
printHtmlPart(4)
for( _it1572061559 in (listGenetics) ) {
changeItVariable(_it1572061559)
printHtmlPart(25)
expressionOut.print(it.type.color)
printHtmlPart(26)
expressionOut.print(it.type.color)
printHtmlPart(27)
expressionOut.print(it.id)
printHtmlPart(28)
expressionOut.print(it.type.price)
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(32)
expressionOut.print(member.id)
printHtmlPart(33)
invokeTag('cookie','g',85,['name':("myCookie")],-1)
printHtmlPart(34)
createTagBody(1, {->
printHtmlPart(35)
expressionOut.print(member.id)
printHtmlPart(36)
})
invokeTag('form','g',91,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(37)
for( _it1147313072 in (listEvents) ) {
changeItVariable(_it1147313072)
printHtmlPart(38)
expressionOut.print(it.writer)
printHtmlPart(39)
invokeTag('formatDate','g',95,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(40)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(41)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(42)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(43)
}
else {
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(it.observation)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(48)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(49)
}
printHtmlPart(50)
invokeTag('set','g',126,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(51)
invokeTag('set','g',127,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(51)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(52)
invokeTag('set','g',129,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(51)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(52)
invokeTag('set','g',132,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(51)
}
printHtmlPart(53)
createTagBody(1, {->
printHtmlPart(54)
expressionOut.print(member.id)
printHtmlPart(55)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(56)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(59)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(60)
}
printHtmlPart(61)
})
invokeTag('form','g',156,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(62)
invokeTag('set','g',171,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(51)
invokeTag('set','g',172,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(63)
createTagBody(1, {->
printHtmlPart(54)
expressionOut.print(member.id)
printHtmlPart(64)
})
invokeTag('form','g',183,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(65)
invokeTag('set','g',197,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(51)
invokeTag('set','g',198,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(63)
createTagBody(1, {->
printHtmlPart(66)
expressionOut.print(member.id)
printHtmlPart(67)
})
invokeTag('form','g',210,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(68)
invokeTag('render','g',234,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(69)
expressionOut.print(grams)
printHtmlPart(70)
expressionOut.print(member.status.name())
printHtmlPart(71)
expressionOut.print(member.status.name())
printHtmlPart(72)
expressionOut.print(grams)
printHtmlPart(73)
expressionOut.print(notification)
printHtmlPart(74)
expressionOut.print(notification?.dateCreated)
printHtmlPart(75)
expressionOut.print(notification?.id)
printHtmlPart(76)
expressionOut.print(notification?.observation)
printHtmlPart(77)
expressionOut.print(member.id)
printHtmlPart(78)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416353701000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

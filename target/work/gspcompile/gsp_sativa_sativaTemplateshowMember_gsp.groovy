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
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(10)
}
printHtmlPart(11)
})
invokeTag('form','g',27,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],1)
printHtmlPart(12)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('ifAllGranted','sec',32,['roles':("ROLE_ADMIN")],2)
printHtmlPart(3)
}
printHtmlPart(15)
expressionOut.print(member.firstname)
printHtmlPart(16)
expressionOut.print(member.lastname)
printHtmlPart(17)
expressionOut.print(member.identificationNumber)
printHtmlPart(18)
expressionOut.print(member.address)
printHtmlPart(19)
expressionOut.print(member.phone)
printHtmlPart(20)
invokeTag('formatDate','g',43,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',44,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(22)
expressionOut.print(card?.code)
printHtmlPart(23)
if(true && (member.friend)) {
printHtmlPart(24)
expressionOut.print(member.friend.firstname)
printHtmlPart(25)
expressionOut.print(member.friend.lastname)
printHtmlPart(26)
}
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
expressionOut.print(member.id)
printHtmlPart(29)
})
invokeTag('form','g',63,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(30)
if(true && ((member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams > 90.00)) {
printHtmlPart(4)
for( _it1627789537 in (listGenetics) ) {
changeItVariable(_it1627789537)
printHtmlPart(31)
expressionOut.print(it.type.color)
printHtmlPart(32)
expressionOut.print(it.type.color)
printHtmlPart(33)
expressionOut.print(it.id)
printHtmlPart(34)
expressionOut.print(it.type.price)
printHtmlPart(35)
expressionOut.print(it.name)
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(member.id)
printHtmlPart(39)
invokeTag('cookie','g',90,['name':("myCookie")],-1)
printHtmlPart(40)
createTagBody(1, {->
printHtmlPart(41)
expressionOut.print(member.id)
printHtmlPart(42)
})
invokeTag('form','g',96,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(43)
for( _it1464569226 in (listEvents) ) {
changeItVariable(_it1464569226)
printHtmlPart(44)
expressionOut.print(it.writer)
printHtmlPart(45)
invokeTag('formatDate','g',100,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(46)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(47)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(48)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(49)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(it.observation)
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(54)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(55)
}
printHtmlPart(56)
invokeTag('set','g',131,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(57)
invokeTag('set','g',132,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(57)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(58)
invokeTag('set','g',134,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(57)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(58)
invokeTag('set','g',137,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(57)
}
printHtmlPart(59)
createTagBody(1, {->
printHtmlPart(60)
expressionOut.print(member.id)
printHtmlPart(61)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(62)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(65)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(66)
}
printHtmlPart(67)
})
invokeTag('form','g',161,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(68)
invokeTag('set','g',176,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(57)
invokeTag('set','g',177,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(69)
createTagBody(1, {->
printHtmlPart(60)
expressionOut.print(member.id)
printHtmlPart(70)
})
invokeTag('form','g',188,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(71)
invokeTag('set','g',202,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(57)
invokeTag('set','g',203,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(69)
createTagBody(1, {->
printHtmlPart(72)
expressionOut.print(member.id)
printHtmlPart(73)
})
invokeTag('form','g',215,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(74)
invokeTag('render','g',239,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(75)
expressionOut.print(grams)
printHtmlPart(76)
expressionOut.print(member.status.name())
printHtmlPart(77)
expressionOut.print(member.status.name())
printHtmlPart(78)
expressionOut.print(grams)
printHtmlPart(79)
expressionOut.print(notification)
printHtmlPart(80)
expressionOut.print(notification?.dateCreated)
printHtmlPart(81)
expressionOut.print(notification?.id)
printHtmlPart(82)
expressionOut.print(notification?.observation)
printHtmlPart(83)
expressionOut.print(member.id)
printHtmlPart(84)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418894465000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

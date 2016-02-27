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
expressionOut.print(imagePerson)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('img','g',17,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(6)
}
printHtmlPart(6)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(7)
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(member.id)
printHtmlPart(11)
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(12)
}
printHtmlPart(13)
})
invokeTag('form','g',30,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],2)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('ifAllGranted','sec',36,['roles':("ROLE_ADMIN")],2)
printHtmlPart(14)
}
printHtmlPart(18)
if(true && (yellowCard > 0)) {
printHtmlPart(19)
for( _it142123474 in (1..yellowCard) ) {
changeItVariable(_it142123474)
printHtmlPart(20)
invokeTag('img','g',43,['dir':("css/img"),'file':("yellowCard.jpg"),'width':("50")],-1)
printHtmlPart(21)
expressionOut.print(createLink(controller:'member', action:'forgiveAmonished', params:[page:"show", memberId:member.id]))
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(member.code)
printHtmlPart(25)
expressionOut.print(member.firstname)
printHtmlPart(26)
expressionOut.print(member.lastname)
printHtmlPart(27)
expressionOut.print(member.identificationNumber)
printHtmlPart(28)
expressionOut.print(member.address)
printHtmlPart(29)
expressionOut.print(member.phone)
printHtmlPart(30)
invokeTag('formatDate','g',61,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy"),'date':(member.birthday)],-1)
printHtmlPart(31)
invokeTag('formatDate','g',62,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(32)
invokeTag('formatDate','g',63,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(33)
expressionOut.print(card?.code)
printHtmlPart(34)
expressionOut.print(member.consum.getHumanName())
printHtmlPart(35)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(36)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(37)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(38)
}
printHtmlPart(39)
createTagBody(1, {->
printHtmlPart(40)
expressionOut.print(member.id)
printHtmlPart(41)
})
invokeTag('form','g',83,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(42)
expressionOut.print(grams.monthly)
printHtmlPart(43)
expressionOut.print(grams.anualy)
printHtmlPart(44)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(45)
}
else {
printHtmlPart(46)
for( _it667412054 in (listCustomEvents) ) {
changeItVariable(_it667412054)
printHtmlPart(47)
expressionOut.print(it.writer)
printHtmlPart(48)
invokeTag('formatDate','g',96,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(49)
expressionOut.print(it.observation)
printHtmlPart(50)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(51)
}
printHtmlPart(52)
}
printHtmlPart(53)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(54)
for( _it887303297 in (listGenetics) ) {
changeItVariable(_it887303297)
printHtmlPart(55)
expressionOut.print(it.type.color)
printHtmlPart(56)
expressionOut.print(it.type.color)
printHtmlPart(57)
expressionOut.print(it.id)
printHtmlPart(58)
expressionOut.print(it.type.price)
printHtmlPart(59)
expressionOut.print(it.name)
printHtmlPart(60)
}
printHtmlPart(61)
expressionOut.print(member.id)
printHtmlPart(62)
}
printHtmlPart(63)
invokeTag('cookie','g',130,['name':("myCookie")],-1)
printHtmlPart(64)
createTagBody(1, {->
printHtmlPart(65)
expressionOut.print(member.id)
printHtmlPart(66)
})
invokeTag('form','g',136,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(67)
for( _it780067911 in (listEvents) ) {
changeItVariable(_it780067911)
printHtmlPart(68)
expressionOut.print(it.writer)
printHtmlPart(48)
invokeTag('formatDate','g',140,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(69)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(70)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(71)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(72)
}
else {
printHtmlPart(73)
}
printHtmlPart(74)
expressionOut.print(it.observation)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(77)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(78)
}
printHtmlPart(79)
invokeTag('set','g',171,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(80)
invokeTag('set','g',172,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(80)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(81)
invokeTag('set','g',174,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(80)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(81)
invokeTag('set','g',177,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(80)
}
printHtmlPart(82)
createTagBody(1, {->
printHtmlPart(83)
expressionOut.print(member.id)
printHtmlPart(84)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(85)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(88)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(89)
}
printHtmlPart(90)
})
invokeTag('form','g',201,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(91)
invokeTag('set','g',216,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(80)
invokeTag('set','g',217,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(92)
createTagBody(1, {->
printHtmlPart(83)
expressionOut.print(member.id)
printHtmlPart(93)
})
invokeTag('form','g',228,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(94)
invokeTag('set','g',242,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(80)
invokeTag('set','g',243,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(92)
createTagBody(1, {->
printHtmlPart(95)
expressionOut.print(member.id)
printHtmlPart(96)
})
invokeTag('form','g',255,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(97)
invokeTag('render','g',279,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(98)
expressionOut.print(grams.monthly)
printHtmlPart(99)
expressionOut.print(member.status.name())
printHtmlPart(100)
expressionOut.print(member.status.name())
printHtmlPart(101)
expressionOut.print(grams.monthly)
printHtmlPart(102)
expressionOut.print(notification)
printHtmlPart(103)
expressionOut.print(notification?.dateCreated)
printHtmlPart(104)
expressionOut.print(notification?.id)
printHtmlPart(105)
expressionOut.print(notification?.observation)
printHtmlPart(106)
expressionOut.print(member.id)
printHtmlPart(107)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1456567988000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

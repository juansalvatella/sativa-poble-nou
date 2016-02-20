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
for( _it856006509 in (1..yellowCard) ) {
changeItVariable(_it856006509)
printHtmlPart(19)
invokeTag('img','g',42,['dir':("css/img"),'file':("yellowCard.jpg"),'width':("50")],-1)
printHtmlPart(20)
expressionOut.print(createLink(controller:'member', action:'forgiveAmonished', params:[page:"show", memberId:member.id]))
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(member.code)
printHtmlPart(23)
expressionOut.print(member.firstname)
printHtmlPart(24)
expressionOut.print(member.lastname)
printHtmlPart(25)
expressionOut.print(member.identificationNumber)
printHtmlPart(26)
expressionOut.print(member.address)
printHtmlPart(27)
expressionOut.print(member.phone)
printHtmlPart(28)
invokeTag('formatDate','g',58,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy"),'date':(member.birthday)],-1)
printHtmlPart(29)
invokeTag('formatDate','g',59,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(30)
invokeTag('formatDate','g',60,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(31)
expressionOut.print(card?.code)
printHtmlPart(32)
expressionOut.print(member.consum.getHumanName())
printHtmlPart(33)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(34)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(35)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(36)
}
printHtmlPart(37)
createTagBody(1, {->
printHtmlPart(38)
expressionOut.print(member.id)
printHtmlPart(39)
})
invokeTag('form','g',80,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(40)
expressionOut.print(grams.monthly)
printHtmlPart(41)
expressionOut.print(grams.anualy)
printHtmlPart(42)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(43)
}
else {
printHtmlPart(44)
for( _it908445510 in (listCustomEvents) ) {
changeItVariable(_it908445510)
printHtmlPart(45)
expressionOut.print(it.writer)
printHtmlPart(46)
invokeTag('formatDate','g',93,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(47)
expressionOut.print(it.observation)
printHtmlPart(48)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(49)
}
printHtmlPart(50)
}
printHtmlPart(51)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(52)
for( _it1782440047 in (listGenetics) ) {
changeItVariable(_it1782440047)
printHtmlPart(53)
expressionOut.print(it.type.color)
printHtmlPart(54)
expressionOut.print(it.type.color)
printHtmlPart(55)
expressionOut.print(it.id)
printHtmlPart(56)
expressionOut.print(it.type.price)
printHtmlPart(57)
expressionOut.print(it.name)
printHtmlPart(58)
}
printHtmlPart(59)
expressionOut.print(member.id)
printHtmlPart(60)
}
printHtmlPart(61)
invokeTag('cookie','g',127,['name':("myCookie")],-1)
printHtmlPart(62)
createTagBody(1, {->
printHtmlPart(63)
expressionOut.print(member.id)
printHtmlPart(64)
})
invokeTag('form','g',133,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(65)
for( _it72994279 in (listEvents) ) {
changeItVariable(_it72994279)
printHtmlPart(66)
expressionOut.print(it.writer)
printHtmlPart(46)
invokeTag('formatDate','g',137,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(67)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(68)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(69)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(70)
}
else {
printHtmlPart(71)
}
printHtmlPart(72)
expressionOut.print(it.observation)
printHtmlPart(73)
}
printHtmlPart(74)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(75)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(76)
}
printHtmlPart(77)
invokeTag('set','g',168,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(78)
invokeTag('set','g',169,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(78)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(79)
invokeTag('set','g',171,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(78)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(79)
invokeTag('set','g',174,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(78)
}
printHtmlPart(80)
createTagBody(1, {->
printHtmlPart(81)
expressionOut.print(member.id)
printHtmlPart(82)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(83)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(86)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(87)
}
printHtmlPart(88)
})
invokeTag('form','g',198,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(89)
invokeTag('set','g',213,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(78)
invokeTag('set','g',214,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(90)
createTagBody(1, {->
printHtmlPart(81)
expressionOut.print(member.id)
printHtmlPart(91)
})
invokeTag('form','g',225,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(92)
invokeTag('set','g',239,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(78)
invokeTag('set','g',240,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(90)
createTagBody(1, {->
printHtmlPart(93)
expressionOut.print(member.id)
printHtmlPart(94)
})
invokeTag('form','g',252,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(95)
invokeTag('render','g',276,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(96)
expressionOut.print(grams.monthly)
printHtmlPart(97)
expressionOut.print(member.status.name())
printHtmlPart(98)
expressionOut.print(member.status.name())
printHtmlPart(99)
expressionOut.print(grams.monthly)
printHtmlPart(100)
expressionOut.print(notification)
printHtmlPart(101)
expressionOut.print(notification?.dateCreated)
printHtmlPart(102)
expressionOut.print(notification?.id)
printHtmlPart(103)
expressionOut.print(notification?.observation)
printHtmlPart(104)
expressionOut.print(member.id)
printHtmlPart(105)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1455977488000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

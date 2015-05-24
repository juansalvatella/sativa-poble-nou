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
invokeTag('img','g',14,['dir':("css/img/partners"),'file':(member.image),'width':("225"),'height':("180")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('img','g',17,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(6)
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(member.id)
printHtmlPart(10)
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(11)
}
printHtmlPart(12)
})
invokeTag('form','g',30,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],2)
printHtmlPart(3)
}
printHtmlPart(13)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('ifAllGranted','sec',36,['roles':("ROLE_ADMIN")],2)
printHtmlPart(3)
}
printHtmlPart(16)
expressionOut.print(member.code)
printHtmlPart(17)
expressionOut.print(member.firstname)
printHtmlPart(18)
expressionOut.print(member.lastname)
printHtmlPart(19)
expressionOut.print(member.identificationNumber)
printHtmlPart(20)
expressionOut.print(member.address)
printHtmlPart(21)
expressionOut.print(member.phone)
printHtmlPart(22)
invokeTag('formatDate','g',48,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',49,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(24)
expressionOut.print(card?.code)
printHtmlPart(25)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(26)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(27)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(28)
}
printHtmlPart(29)
createTagBody(1, {->
printHtmlPart(30)
expressionOut.print(member.id)
printHtmlPart(31)
})
invokeTag('form','g',68,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(32)
expressionOut.print(grams.monthly)
printHtmlPart(33)
expressionOut.print(grams.anualy)
printHtmlPart(34)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
for( _it214617617 in (listCustomEvents) ) {
changeItVariable(_it214617617)
printHtmlPart(37)
expressionOut.print(it.writer)
printHtmlPart(38)
invokeTag('formatDate','g',81,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(39)
expressionOut.print(it.observation)
printHtmlPart(40)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(44)
for( _it1378717230 in (listGenetics) ) {
changeItVariable(_it1378717230)
printHtmlPart(45)
expressionOut.print(it.type.color)
printHtmlPart(46)
expressionOut.print(it.type.color)
printHtmlPart(47)
expressionOut.print(it.id)
printHtmlPart(48)
expressionOut.print(it.type.price)
printHtmlPart(49)
expressionOut.print(it.name)
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(member.id)
printHtmlPart(52)
}
printHtmlPart(53)
invokeTag('cookie','g',115,['name':("myCookie")],-1)
printHtmlPart(54)
createTagBody(1, {->
printHtmlPart(55)
expressionOut.print(member.id)
printHtmlPart(56)
})
invokeTag('form','g',121,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(57)
for( _it751933480 in (listEvents) ) {
changeItVariable(_it751933480)
printHtmlPart(58)
expressionOut.print(it.writer)
printHtmlPart(38)
invokeTag('formatDate','g',125,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(59)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(60)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(61)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(62)
}
else {
printHtmlPart(63)
}
printHtmlPart(64)
expressionOut.print(it.observation)
printHtmlPart(65)
}
printHtmlPart(66)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(67)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(68)
}
printHtmlPart(69)
invokeTag('set','g',156,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(70)
invokeTag('set','g',157,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(70)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(71)
invokeTag('set','g',159,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(70)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(71)
invokeTag('set','g',162,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(70)
}
printHtmlPart(72)
createTagBody(1, {->
printHtmlPart(73)
expressionOut.print(member.id)
printHtmlPart(74)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(75)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(78)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(79)
}
printHtmlPart(80)
})
invokeTag('form','g',186,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(81)
invokeTag('set','g',201,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(70)
invokeTag('set','g',202,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(82)
createTagBody(1, {->
printHtmlPart(73)
expressionOut.print(member.id)
printHtmlPart(83)
})
invokeTag('form','g',213,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(84)
invokeTag('set','g',227,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(70)
invokeTag('set','g',228,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(82)
createTagBody(1, {->
printHtmlPart(85)
expressionOut.print(member.id)
printHtmlPart(86)
})
invokeTag('form','g',240,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(87)
invokeTag('render','g',264,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(88)
expressionOut.print(grams.monthly)
printHtmlPart(89)
expressionOut.print(member.status.name())
printHtmlPart(90)
expressionOut.print(member.status.name())
printHtmlPart(91)
expressionOut.print(grams.monthly)
printHtmlPart(92)
expressionOut.print(notification)
printHtmlPart(93)
expressionOut.print(notification?.dateCreated)
printHtmlPart(94)
expressionOut.print(notification?.id)
printHtmlPart(95)
expressionOut.print(notification?.observation)
printHtmlPart(96)
expressionOut.print(member.id)
printHtmlPart(97)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431104844000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

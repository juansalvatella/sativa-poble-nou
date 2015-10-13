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
expressionOut.print(member.code)
printHtmlPart(19)
expressionOut.print(member.firstname)
printHtmlPart(20)
expressionOut.print(member.lastname)
printHtmlPart(21)
expressionOut.print(member.identificationNumber)
printHtmlPart(22)
expressionOut.print(member.address)
printHtmlPart(23)
expressionOut.print(member.phone)
printHtmlPart(24)
invokeTag('formatDate','g',48,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy"),'date':(member.birthday)],-1)
printHtmlPart(25)
invokeTag('formatDate','g',49,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(26)
invokeTag('formatDate','g',50,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(27)
expressionOut.print(card?.code)
printHtmlPart(28)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(29)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(30)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(31)
}
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(33)
expressionOut.print(member.id)
printHtmlPart(34)
})
invokeTag('form','g',69,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(35)
expressionOut.print(grams.monthly)
printHtmlPart(36)
expressionOut.print(grams.anualy)
printHtmlPart(37)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
for( _it1988265491 in (listCustomEvents) ) {
changeItVariable(_it1988265491)
printHtmlPart(40)
expressionOut.print(it.writer)
printHtmlPart(41)
invokeTag('formatDate','g',82,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(42)
expressionOut.print(it.observation)
printHtmlPart(43)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(44)
}
printHtmlPart(45)
}
printHtmlPart(46)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(47)
for( _it2010733901 in (listGenetics) ) {
changeItVariable(_it2010733901)
printHtmlPart(48)
expressionOut.print(it.type.color)
printHtmlPart(49)
expressionOut.print(it.type.color)
printHtmlPart(50)
expressionOut.print(it.id)
printHtmlPart(51)
expressionOut.print(it.type.price)
printHtmlPart(52)
expressionOut.print(it.name)
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(member.id)
printHtmlPart(55)
}
printHtmlPart(56)
invokeTag('cookie','g',116,['name':("myCookie")],-1)
printHtmlPart(57)
createTagBody(1, {->
printHtmlPart(58)
expressionOut.print(member.id)
printHtmlPart(59)
})
invokeTag('form','g',122,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(60)
for( _it1602004915 in (listEvents) ) {
changeItVariable(_it1602004915)
printHtmlPart(61)
expressionOut.print(it.writer)
printHtmlPart(41)
invokeTag('formatDate','g',126,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(62)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(63)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(64)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(65)
}
else {
printHtmlPart(66)
}
printHtmlPart(67)
expressionOut.print(it.observation)
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(70)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(71)
}
printHtmlPart(72)
invokeTag('set','g',157,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(73)
invokeTag('set','g',158,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(73)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(74)
invokeTag('set','g',160,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(73)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(74)
invokeTag('set','g',163,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(73)
}
printHtmlPart(75)
createTagBody(1, {->
printHtmlPart(76)
expressionOut.print(member.id)
printHtmlPart(77)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(78)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(81)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(82)
}
printHtmlPart(83)
})
invokeTag('form','g',187,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(84)
invokeTag('set','g',202,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(73)
invokeTag('set','g',203,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(85)
createTagBody(1, {->
printHtmlPart(76)
expressionOut.print(member.id)
printHtmlPart(86)
})
invokeTag('form','g',214,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(87)
invokeTag('set','g',228,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(73)
invokeTag('set','g',229,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(85)
createTagBody(1, {->
printHtmlPart(88)
expressionOut.print(member.id)
printHtmlPart(89)
})
invokeTag('form','g',241,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(90)
invokeTag('render','g',265,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(91)
expressionOut.print(grams.monthly)
printHtmlPart(92)
expressionOut.print(member.status.name())
printHtmlPart(93)
expressionOut.print(member.status.name())
printHtmlPart(94)
expressionOut.print(grams.monthly)
printHtmlPart(95)
expressionOut.print(notification)
printHtmlPart(96)
expressionOut.print(notification?.dateCreated)
printHtmlPart(97)
expressionOut.print(notification?.id)
printHtmlPart(98)
expressionOut.print(notification?.observation)
printHtmlPart(99)
expressionOut.print(member.id)
printHtmlPart(100)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1438281738000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

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
invokeTag('formatDate','g',48,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy"),'date':(member.birthday)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',49,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(24)
invokeTag('formatDate','g',50,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(25)
expressionOut.print(card?.code)
printHtmlPart(26)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(27)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(28)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(29)
}
printHtmlPart(30)
createTagBody(1, {->
printHtmlPart(31)
expressionOut.print(member.id)
printHtmlPart(32)
})
invokeTag('form','g',69,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(33)
expressionOut.print(grams.monthly)
printHtmlPart(34)
expressionOut.print(grams.anualy)
printHtmlPart(35)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(36)
}
else {
printHtmlPart(37)
for( _it844372228 in (listCustomEvents) ) {
changeItVariable(_it844372228)
printHtmlPart(38)
expressionOut.print(it.writer)
printHtmlPart(39)
invokeTag('formatDate','g',82,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(40)
expressionOut.print(it.observation)
printHtmlPart(41)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(42)
}
printHtmlPart(43)
}
printHtmlPart(44)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(45)
for( _it838545241 in (listGenetics) ) {
changeItVariable(_it838545241)
printHtmlPart(46)
expressionOut.print(it.type.color)
printHtmlPart(47)
expressionOut.print(it.type.color)
printHtmlPart(48)
expressionOut.print(it.id)
printHtmlPart(49)
expressionOut.print(it.type.price)
printHtmlPart(50)
expressionOut.print(it.name)
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(member.id)
printHtmlPart(53)
}
printHtmlPart(54)
invokeTag('cookie','g',116,['name':("myCookie")],-1)
printHtmlPart(55)
createTagBody(1, {->
printHtmlPart(56)
expressionOut.print(member.id)
printHtmlPart(57)
})
invokeTag('form','g',122,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(58)
for( _it1642173873 in (listEvents) ) {
changeItVariable(_it1642173873)
printHtmlPart(59)
expressionOut.print(it.writer)
printHtmlPart(39)
invokeTag('formatDate','g',126,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(60)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(61)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(62)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(63)
}
else {
printHtmlPart(64)
}
printHtmlPart(65)
expressionOut.print(it.observation)
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(68)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(69)
}
printHtmlPart(70)
invokeTag('set','g',157,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(71)
invokeTag('set','g',158,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(71)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(72)
invokeTag('set','g',160,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(71)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(72)
invokeTag('set','g',163,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(71)
}
printHtmlPart(73)
createTagBody(1, {->
printHtmlPart(74)
expressionOut.print(member.id)
printHtmlPart(75)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(76)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(77)
}
printHtmlPart(78)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(79)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(80)
}
printHtmlPart(81)
})
invokeTag('form','g',187,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(82)
invokeTag('set','g',202,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(71)
invokeTag('set','g',203,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(83)
createTagBody(1, {->
printHtmlPart(74)
expressionOut.print(member.id)
printHtmlPart(84)
})
invokeTag('form','g',214,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(85)
invokeTag('set','g',228,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(71)
invokeTag('set','g',229,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(83)
createTagBody(1, {->
printHtmlPart(86)
expressionOut.print(member.id)
printHtmlPart(87)
})
invokeTag('form','g',241,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(88)
invokeTag('render','g',265,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(89)
expressionOut.print(grams.monthly)
printHtmlPart(90)
expressionOut.print(member.status.name())
printHtmlPart(91)
expressionOut.print(member.status.name())
printHtmlPart(92)
expressionOut.print(grams.monthly)
printHtmlPart(93)
expressionOut.print(notification)
printHtmlPart(94)
expressionOut.print(notification?.dateCreated)
printHtmlPart(95)
expressionOut.print(notification?.id)
printHtmlPart(96)
expressionOut.print(notification?.observation)
printHtmlPart(97)
expressionOut.print(member.id)
printHtmlPart(98)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434312358000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

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
invokeTag('form','g',29,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],2)
printHtmlPart(3)
}
printHtmlPart(13)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('ifAllGranted','sec',35,['roles':("ROLE_ADMIN")],2)
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
invokeTag('formatDate','g',47,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',48,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(24)
expressionOut.print(card?.code)
printHtmlPart(25)
if(true && (member.friend)) {
printHtmlPart(26)
expressionOut.print(member.friend.firstname)
printHtmlPart(27)
expressionOut.print(member.friend.lastname)
printHtmlPart(28)
}
printHtmlPart(29)
createTagBody(1, {->
printHtmlPart(30)
expressionOut.print(member.id)
printHtmlPart(31)
})
invokeTag('form','g',67,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(32)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(33)
}
else {
printHtmlPart(34)
for( _it1907475056 in (listCustomEvents) ) {
changeItVariable(_it1907475056)
printHtmlPart(35)
expressionOut.print(it.writer)
printHtmlPart(36)
invokeTag('formatDate','g',77,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(37)
expressionOut.print(it.observation)
printHtmlPart(38)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(39)
}
printHtmlPart(40)
}
printHtmlPart(41)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams > 90.00)) {
printHtmlPart(42)
for( _it575244400 in (listGenetics) ) {
changeItVariable(_it575244400)
printHtmlPart(43)
expressionOut.print(it.type.color)
printHtmlPart(44)
expressionOut.print(it.type.color)
printHtmlPart(45)
expressionOut.print(it.id)
printHtmlPart(46)
expressionOut.print(it.type.price)
printHtmlPart(47)
expressionOut.print(it.name)
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(member.id)
printHtmlPart(50)
}
printHtmlPart(51)
invokeTag('cookie','g',109,['name':("myCookie")],-1)
printHtmlPart(52)
createTagBody(1, {->
printHtmlPart(53)
expressionOut.print(member.id)
printHtmlPart(54)
})
invokeTag('form','g',115,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(55)
for( _it161252006 in (listEvents) ) {
changeItVariable(_it161252006)
printHtmlPart(56)
expressionOut.print(it.writer)
printHtmlPart(36)
invokeTag('formatDate','g',119,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(57)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(58)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(59)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(60)
}
else {
printHtmlPart(61)
}
printHtmlPart(62)
expressionOut.print(it.observation)
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
invokeTag('set','g',150,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(68)
invokeTag('set','g',151,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(68)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(69)
invokeTag('set','g',153,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(68)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(69)
invokeTag('set','g',156,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(68)
}
printHtmlPart(70)
createTagBody(1, {->
printHtmlPart(71)
expressionOut.print(member.id)
printHtmlPart(72)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(73)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(74)
}
printHtmlPart(75)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(76)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(77)
}
printHtmlPart(78)
})
invokeTag('form','g',180,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(79)
invokeTag('set','g',195,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(68)
invokeTag('set','g',196,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(80)
createTagBody(1, {->
printHtmlPart(71)
expressionOut.print(member.id)
printHtmlPart(81)
})
invokeTag('form','g',207,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(82)
invokeTag('set','g',221,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(68)
invokeTag('set','g',222,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(80)
createTagBody(1, {->
printHtmlPart(83)
expressionOut.print(member.id)
printHtmlPart(84)
})
invokeTag('form','g',234,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(85)
invokeTag('render','g',258,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(86)
expressionOut.print(grams)
printHtmlPart(87)
expressionOut.print(member.status.name())
printHtmlPart(88)
expressionOut.print(member.status.name())
printHtmlPart(89)
expressionOut.print(grams)
printHtmlPart(90)
expressionOut.print(notification)
printHtmlPart(91)
expressionOut.print(notification?.dateCreated)
printHtmlPart(92)
expressionOut.print(notification?.id)
printHtmlPart(93)
expressionOut.print(notification?.observation)
printHtmlPart(94)
expressionOut.print(member.id)
printHtmlPart(95)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425330882000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

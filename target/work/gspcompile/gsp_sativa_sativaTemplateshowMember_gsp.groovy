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
invokeTag('img','g',17,['dir':("css/img"),'file':("avatar.png"),'width':("302"),'height':("220")],-1)
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
invokeTag('form','g',31,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],2)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('ifAllGranted','sec',37,['roles':("ROLE_ADMIN")],2)
printHtmlPart(14)
}
printHtmlPart(18)
if(true && (yellowCard > 0)) {
printHtmlPart(19)
for( _it3101319 in (1..yellowCard) ) {
changeItVariable(_it3101319)
printHtmlPart(20)
invokeTag('img','g',44,['dir':("css/img"),'file':("yellowCard.jpg"),'width':("50")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(member.code)
printHtmlPart(24)
expressionOut.print(member.firstname)
printHtmlPart(25)
expressionOut.print(member.lastname)
printHtmlPart(26)
expressionOut.print(member.identificationNumber)
printHtmlPart(27)
expressionOut.print(member.address)
printHtmlPart(28)
expressionOut.print(member.phone)
printHtmlPart(29)
invokeTag('formatDate','g',57,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy"),'date':(member.birthday)],-1)
printHtmlPart(30)
invokeTag('formatDate','g',58,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(31)
invokeTag('formatDate','g',59,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(32)
expressionOut.print(card?.code)
printHtmlPart(33)
expressionOut.print(member.consum.getHumanName())
printHtmlPart(34)
if(true && (member.lastFriend() != null)) {
printHtmlPart(35)
expressionOut.print(member.lastFriend().code)
printHtmlPart(36)
}
printHtmlPart(37)
createTagBody(1, {->
printHtmlPart(38)
expressionOut.print(member.id)
printHtmlPart(39)
})
invokeTag('form','g',79,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(40)
expressionOut.print(grams.monthly)
printHtmlPart(41)
if(true && (member.status.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(42)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(43)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(44)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(45)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(46)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(47)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__REMOVED')) {
printHtmlPart(48)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(51)
for( _it584260905 in (listGenetics) ) {
changeItVariable(_it584260905)
printHtmlPart(52)
expressionOut.print(it.type.color)
printHtmlPart(53)
expressionOut.print(it.type.color)
printHtmlPart(54)
expressionOut.print(it.id)
printHtmlPart(55)
expressionOut.print(it.type.price)
printHtmlPart(56)
expressionOut.print(it.name)
printHtmlPart(57)
}
printHtmlPart(58)
expressionOut.print(member.id)
printHtmlPart(59)
}
printHtmlPart(60)
invokeTag('cookie','g',116,['name':("myCookie")],-1)
printHtmlPart(61)
if(true && (listWithdrawals != null && listWithdrawals.size() == 0)) {
printHtmlPart(62)
}
else {
printHtmlPart(63)
for( _it1377796251 in (listWithdrawals) ) {
changeItVariable(_it1377796251)
printHtmlPart(64)
expressionOut.print(it.writer)
printHtmlPart(65)
invokeTag('formatDate','g',127,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(66)
expressionOut.print(it.observation)
printHtmlPart(67)
}
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (listCustomEvents != null && listCustomEvents.size() == 0)) {
printHtmlPart(70)
createTagBody(2, {->
printHtmlPart(71)
expressionOut.print(member.id)
printHtmlPart(72)
})
invokeTag('form','g',142,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],2)
printHtmlPart(73)
}
else {
printHtmlPart(74)
createTagBody(2, {->
printHtmlPart(71)
expressionOut.print(member.id)
printHtmlPart(72)
})
invokeTag('form','g',149,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],2)
printHtmlPart(75)
for( _it305424956 in (listCustomEvents) ) {
changeItVariable(_it305424956)
printHtmlPart(76)
expressionOut.print(it.writer)
printHtmlPart(65)
invokeTag('formatDate','g',152,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(77)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(78)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(79)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(80)
}
else {
printHtmlPart(81)
}
expressionOut.print(it.observation)
printHtmlPart(82)
if(true && (it.type.name() == 'EVENT_TYPE__CUSTOM')) {
printHtmlPart(83)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(84)
}
printHtmlPart(85)
}
printHtmlPart(68)
}
printHtmlPart(86)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(87)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(88)
}
printHtmlPart(89)
invokeTag('set','g',190,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(90)
invokeTag('set','g',191,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(90)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(91)
invokeTag('set','g',193,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(90)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(91)
invokeTag('set','g',196,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(90)
}
printHtmlPart(92)
createTagBody(1, {->
printHtmlPart(93)
expressionOut.print(member.id)
printHtmlPart(94)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(95)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(96)
}
printHtmlPart(97)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(98)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(99)
}
printHtmlPart(100)
})
invokeTag('form','g',220,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(101)
invokeTag('set','g',236,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(90)
invokeTag('set','g',237,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(102)
createTagBody(1, {->
printHtmlPart(93)
expressionOut.print(member.id)
printHtmlPart(103)
})
invokeTag('form','g',248,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'notpayed'])],1)
printHtmlPart(104)
invokeTag('set','g',262,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(90)
invokeTag('set','g',263,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(102)
createTagBody(1, {->
printHtmlPart(105)
expressionOut.print(member.id)
printHtmlPart(106)
})
invokeTag('form','g',275,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(107)
invokeTag('render','g',299,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(108)
expressionOut.print(grams.monthly)
printHtmlPart(109)
expressionOut.print(member.status.name())
printHtmlPart(110)
expressionOut.print(member.status.name())
printHtmlPart(111)
expressionOut.print(grams.monthly)
printHtmlPart(112)
expressionOut.print(notification)
printHtmlPart(113)
expressionOut.print(notification?.dateCreated)
printHtmlPart(114)
expressionOut.print(notification?.id)
printHtmlPart(115)
expressionOut.print(notification?.observation)
printHtmlPart(116)
expressionOut.print(member.id)
printHtmlPart(117)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496171762599L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

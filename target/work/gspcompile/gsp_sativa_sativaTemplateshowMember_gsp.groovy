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
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams > 90.00)) {
printHtmlPart(33)
for( _it398281120 in (listGenetics) ) {
changeItVariable(_it398281120)
printHtmlPart(34)
expressionOut.print(it.type.color)
printHtmlPart(35)
expressionOut.print(it.type.color)
printHtmlPart(36)
expressionOut.print(it.id)
printHtmlPart(37)
expressionOut.print(it.type.price)
printHtmlPart(38)
expressionOut.print(it.name)
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(member.id)
printHtmlPart(41)
}
printHtmlPart(42)
invokeTag('cookie','g',96,['name':("myCookie")],-1)
printHtmlPart(43)
createTagBody(1, {->
printHtmlPart(44)
expressionOut.print(member.id)
printHtmlPart(45)
})
invokeTag('form','g',102,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(46)
for( _it3862662 in (listEvents) ) {
changeItVariable(_it3862662)
printHtmlPart(47)
expressionOut.print(it.writer)
printHtmlPart(48)
invokeTag('formatDate','g',106,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(49)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(50)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(51)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(52)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(it.observation)
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(57)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(58)
}
printHtmlPart(59)
invokeTag('set','g',137,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(60)
invokeTag('set','g',138,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(60)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(61)
invokeTag('set','g',140,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(60)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(61)
invokeTag('set','g',143,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(60)
}
printHtmlPart(62)
createTagBody(1, {->
printHtmlPart(63)
expressionOut.print(member.id)
printHtmlPart(64)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(65)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
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
})
invokeTag('form','g',167,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(71)
invokeTag('set','g',182,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(60)
invokeTag('set','g',183,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(72)
createTagBody(1, {->
printHtmlPart(63)
expressionOut.print(member.id)
printHtmlPart(73)
})
invokeTag('form','g',194,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(74)
invokeTag('set','g',208,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(60)
invokeTag('set','g',209,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(72)
createTagBody(1, {->
printHtmlPart(75)
expressionOut.print(member.id)
printHtmlPart(76)
})
invokeTag('form','g',221,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(77)
invokeTag('render','g',245,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(78)
expressionOut.print(grams)
printHtmlPart(79)
expressionOut.print(member.status.name())
printHtmlPart(80)
expressionOut.print(member.status.name())
printHtmlPart(81)
expressionOut.print(grams)
printHtmlPart(82)
expressionOut.print(notification)
printHtmlPart(83)
expressionOut.print(notification?.dateCreated)
printHtmlPart(84)
expressionOut.print(notification?.id)
printHtmlPart(85)
expressionOut.print(notification?.observation)
printHtmlPart(86)
expressionOut.print(member.id)
printHtmlPart(87)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421673322000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

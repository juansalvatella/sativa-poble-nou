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
expressionOut.print(member.firstname)
printHtmlPart(17)
expressionOut.print(member.lastname)
printHtmlPart(18)
expressionOut.print(member.identificationNumber)
printHtmlPart(19)
expressionOut.print(member.address)
printHtmlPart(20)
expressionOut.print(member.phone)
printHtmlPart(21)
invokeTag('formatDate','g',46,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(22)
invokeTag('formatDate','g',47,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(23)
expressionOut.print(card?.code)
printHtmlPart(24)
if(true && (member.friend)) {
printHtmlPart(25)
expressionOut.print(member.friend.firstname)
printHtmlPart(26)
expressionOut.print(member.friend.lastname)
printHtmlPart(27)
}
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
expressionOut.print(member.id)
printHtmlPart(30)
})
invokeTag('form','g',66,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(31)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams > 90.00)) {
printHtmlPart(32)
for( _it1173032620 in (listGenetics) ) {
changeItVariable(_it1173032620)
printHtmlPart(33)
expressionOut.print(it.type.color)
printHtmlPart(34)
expressionOut.print(it.type.color)
printHtmlPart(35)
expressionOut.print(it.id)
printHtmlPart(36)
expressionOut.print(it.type.price)
printHtmlPart(37)
expressionOut.print(it.name)
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(member.id)
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('cookie','g',95,['name':("myCookie")],-1)
printHtmlPart(42)
createTagBody(1, {->
printHtmlPart(43)
expressionOut.print(member.id)
printHtmlPart(44)
})
invokeTag('form','g',101,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(45)
for( _it1259364880 in (listEvents) ) {
changeItVariable(_it1259364880)
printHtmlPart(46)
expressionOut.print(it.writer)
printHtmlPart(47)
invokeTag('formatDate','g',105,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(48)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(49)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(50)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(it.observation)
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(56)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(57)
}
printHtmlPart(58)
invokeTag('set','g',136,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(59)
invokeTag('set','g',137,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(59)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(60)
invokeTag('set','g',139,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(59)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(60)
invokeTag('set','g',142,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(59)
}
printHtmlPart(61)
createTagBody(1, {->
printHtmlPart(62)
expressionOut.print(member.id)
printHtmlPart(63)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(64)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
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
})
invokeTag('form','g',166,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(70)
invokeTag('set','g',181,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(59)
invokeTag('set','g',182,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(71)
createTagBody(1, {->
printHtmlPart(62)
expressionOut.print(member.id)
printHtmlPart(72)
})
invokeTag('form','g',193,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(73)
invokeTag('set','g',207,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(59)
invokeTag('set','g',208,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(71)
createTagBody(1, {->
printHtmlPart(74)
expressionOut.print(member.id)
printHtmlPart(75)
})
invokeTag('form','g',220,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(76)
invokeTag('render','g',244,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(77)
expressionOut.print(grams)
printHtmlPart(78)
expressionOut.print(member.status.name())
printHtmlPart(79)
expressionOut.print(member.status.name())
printHtmlPart(80)
expressionOut.print(grams)
printHtmlPart(81)
expressionOut.print(notification)
printHtmlPart(82)
expressionOut.print(notification?.dateCreated)
printHtmlPart(83)
expressionOut.print(notification?.id)
printHtmlPart(84)
expressionOut.print(notification?.observation)
printHtmlPart(85)
expressionOut.print(member.id)
printHtmlPart(86)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1420020578000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplateeditMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/editMember.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
expressionOut.print(createLink(controller:'member', action:'delete', params:[memberId:member.id]))
printHtmlPart(2)
if(true && (success)) {
printHtmlPart(3)
expressionOut.print(success)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (error)) {
printHtmlPart(6)
expressionOut.print(error)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (member.image)) {
printHtmlPart(9)
expressionOut.print(imagePerson)
printHtmlPart(10)
}
else {
printHtmlPart(11)
invokeTag('img','g',41,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(14)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(member.code)
printHtmlPart(17)
invokeTag('formatDate','g',55,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(18)
invokeTag('formatDate','g',58,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(19)
expressionOut.print(card?.code)
printHtmlPart(20)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(21)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(22)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(23)
}
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
expressionOut.print(member.id)
printHtmlPart(26)
expressionOut.print(member.firstname)
printHtmlPart(27)
expressionOut.print(member.lastname)
printHtmlPart(28)
expressionOut.print(member.identificationNumber)
printHtmlPart(29)
expressionOut.print(member.address)
printHtmlPart(30)
expressionOut.print(member.phone)
printHtmlPart(31)
})
invokeTag('form','g',116,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(32)
if(true && (numInvitations >= 5)) {
printHtmlPart(33)
invokeTag('img','g',121,['id':("imageAlertGuest"),'dir':("images/imageSativa"),'file':("warning.png"),'width':("80"),'height':("80")],-1)
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(grams.monthly)
printHtmlPart(36)
expressionOut.print(grams.anualy)
printHtmlPart(37)
for( _it2012360255 in (listGenetics) ) {
changeItVariable(_it2012360255)
printHtmlPart(38)
expressionOut.print(it.name)
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('cookie','g',148,['name':("myCookie")],-1)
printHtmlPart(41)
createTagBody(1, {->
printHtmlPart(42)
expressionOut.print(member.id)
printHtmlPart(43)
})
invokeTag('form','g',155,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(44)
for( _it1018849182 in (listEvents) ) {
changeItVariable(_it1018849182)
printHtmlPart(45)
expressionOut.print(it.writer)
printHtmlPart(46)
invokeTag('formatDate','g',158,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(47)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(48)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(49)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(50)
}
else {
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(it.observation)
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(55)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(56)
}
printHtmlPart(57)
invokeTag('set','g',189,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(58)
invokeTag('set','g',190,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(58)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(59)
invokeTag('set','g',192,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(58)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(59)
invokeTag('set','g',195,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(58)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(59)
invokeTag('set','g',198,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(58)
}
printHtmlPart(60)
createTagBody(1, {->
printHtmlPart(61)
expressionOut.print(member.id)
printHtmlPart(62)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(63)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(64)
}
printHtmlPart(65)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(66)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(67)
}
printHtmlPart(68)
})
invokeTag('form','g',223,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(69)
invokeTag('render','g',238,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(70)
expressionOut.print(member.status.name())
printHtmlPart(71)
expressionOut.print(member.status.name())
printHtmlPart(72)
expressionOut.print(member.birthday)
printHtmlPart(73)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1438432362000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

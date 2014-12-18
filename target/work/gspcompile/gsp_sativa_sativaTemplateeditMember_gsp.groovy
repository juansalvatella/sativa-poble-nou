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
if(true && (success)) {
printHtmlPart(2)
expressionOut.print(success)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (member.image)) {
printHtmlPart(5)
invokeTag('img','g',16,['dir':("css/img/partners"),'file':(member.image),'width':("200"),'height':("180")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('img','g',19,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(6)
}
printHtmlPart(5)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(8)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(member.code)
printHtmlPart(11)
invokeTag('formatDate','g',32,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(12)
invokeTag('formatDate','g',35,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(13)
expressionOut.print(card?.code)
printHtmlPart(14)
if(true && (member.friend)) {
printHtmlPart(15)
expressionOut.print(member.friend.firstname)
printHtmlPart(16)
expressionOut.print(member.friend.lastname)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(19)
expressionOut.print(member.id)
printHtmlPart(20)
expressionOut.print(member.firstname)
printHtmlPart(21)
expressionOut.print(member.lastname)
printHtmlPart(22)
expressionOut.print(member.identificationNumber)
printHtmlPart(23)
expressionOut.print(member.address)
printHtmlPart(24)
expressionOut.print(member.phone)
printHtmlPart(25)
})
invokeTag('form','g',84,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(26)
for( _it1480219089 in (listGenetics) ) {
changeItVariable(_it1480219089)
printHtmlPart(27)
expressionOut.print(it.name)
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('cookie','g',105,['name':("myCookie")],-1)
printHtmlPart(30)
createTagBody(1, {->
printHtmlPart(31)
expressionOut.print(member.id)
printHtmlPart(32)
})
invokeTag('form','g',112,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(33)
for( _it1591661975 in (listEvents) ) {
changeItVariable(_it1591661975)
printHtmlPart(34)
expressionOut.print(it.writer)
printHtmlPart(35)
invokeTag('formatDate','g',115,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(36)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(37)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(38)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(it.observation)
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(44)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(45)
}
printHtmlPart(46)
invokeTag('set','g',146,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(47)
invokeTag('set','g',147,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(47)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(48)
invokeTag('set','g',149,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(47)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(48)
invokeTag('set','g',152,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(47)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(48)
invokeTag('set','g',155,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(47)
}
printHtmlPart(49)
createTagBody(1, {->
printHtmlPart(50)
expressionOut.print(member.id)
printHtmlPart(51)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(52)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
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
})
invokeTag('form','g',180,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(58)
invokeTag('render','g',195,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(59)
expressionOut.print(member.status.name())
printHtmlPart(60)
expressionOut.print(member.status.name())
printHtmlPart(61)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418894465000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

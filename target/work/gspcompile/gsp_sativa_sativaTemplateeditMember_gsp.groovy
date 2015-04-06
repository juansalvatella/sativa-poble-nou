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
if(true && (member.image)) {
printHtmlPart(6)
invokeTag('img','g',34,['dir':("css/img/partners"),'file':(member.image),'width':("200"),'height':("180")],-1)
printHtmlPart(7)
}
else {
printHtmlPart(8)
invokeTag('img','g',37,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(7)
}
printHtmlPart(6)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(9)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(member.code)
printHtmlPart(12)
invokeTag('formatDate','g',51,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',54,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(14)
expressionOut.print(card?.code)
printHtmlPart(15)
if(true && (member.friend)) {
printHtmlPart(16)
expressionOut.print(member.friend.firstname)
printHtmlPart(17)
expressionOut.print(member.friend.lastname)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
expressionOut.print(member.id)
printHtmlPart(21)
expressionOut.print(member.firstname)
printHtmlPart(22)
expressionOut.print(member.lastname)
printHtmlPart(23)
expressionOut.print(member.identificationNumber)
printHtmlPart(24)
expressionOut.print(member.address)
printHtmlPart(25)
expressionOut.print(member.phone)
printHtmlPart(26)
})
invokeTag('form','g',103,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(27)
if(true && (member.numInvitations >= 5)) {
printHtmlPart(28)
invokeTag('img','g',108,['id':("imageAlertGuest"),'dir':("images/imageSativa"),'file':("warning.png"),'width':("80"),'height':("80")],-1)
printHtmlPart(29)
}
printHtmlPart(30)
for( _it992381724 in (listGenetics) ) {
changeItVariable(_it992381724)
printHtmlPart(31)
expressionOut.print(it.name)
printHtmlPart(32)
}
printHtmlPart(33)
invokeTag('cookie','g',132,['name':("myCookie")],-1)
printHtmlPart(34)
createTagBody(1, {->
printHtmlPart(35)
expressionOut.print(member.id)
printHtmlPart(36)
})
invokeTag('form','g',139,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(37)
for( _it1601632666 in (listEvents) ) {
changeItVariable(_it1601632666)
printHtmlPart(38)
expressionOut.print(it.writer)
printHtmlPart(39)
invokeTag('formatDate','g',142,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(40)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(41)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(42)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(43)
}
else {
printHtmlPart(44)
}
printHtmlPart(45)
expressionOut.print(it.observation)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(48)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(49)
}
printHtmlPart(50)
invokeTag('set','g',173,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(51)
invokeTag('set','g',174,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(51)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(52)
invokeTag('set','g',176,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(51)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(52)
invokeTag('set','g',179,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(51)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(52)
invokeTag('set','g',182,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(51)
}
printHtmlPart(53)
createTagBody(1, {->
printHtmlPart(54)
expressionOut.print(member.id)
printHtmlPart(55)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(56)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(59)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(60)
}
printHtmlPart(61)
})
invokeTag('form','g',207,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(62)
invokeTag('render','g',222,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(63)
expressionOut.print(member.status.name())
printHtmlPart(64)
expressionOut.print(member.status.name())
printHtmlPart(65)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425592697000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

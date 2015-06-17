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
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(16)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(17)
expressionOut.print(member.lastFriend().lastname)
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
invokeTag('form','g',112,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(27)
if(true && (numInvitations >= 5)) {
printHtmlPart(28)
invokeTag('img','g',117,['id':("imageAlertGuest"),'dir':("images/imageSativa"),'file':("warning.png"),'width':("80"),'height':("80")],-1)
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(grams.monthly)
printHtmlPart(31)
expressionOut.print(grams.anualy)
printHtmlPart(32)
for( _it1496055688 in (listGenetics) ) {
changeItVariable(_it1496055688)
printHtmlPart(33)
expressionOut.print(it.name)
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('cookie','g',144,['name':("myCookie")],-1)
printHtmlPart(36)
createTagBody(1, {->
printHtmlPart(37)
expressionOut.print(member.id)
printHtmlPart(38)
})
invokeTag('form','g',151,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(39)
for( _it1469409140 in (listEvents) ) {
changeItVariable(_it1469409140)
printHtmlPart(40)
expressionOut.print(it.writer)
printHtmlPart(41)
invokeTag('formatDate','g',154,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(42)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(43)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(44)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(45)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(it.observation)
printHtmlPart(48)
}
printHtmlPart(49)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(50)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(51)
}
printHtmlPart(52)
invokeTag('set','g',185,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(53)
invokeTag('set','g',186,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(53)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(54)
invokeTag('set','g',188,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(53)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(54)
invokeTag('set','g',191,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(53)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(54)
invokeTag('set','g',194,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(53)
}
printHtmlPart(55)
createTagBody(1, {->
printHtmlPart(56)
expressionOut.print(member.id)
printHtmlPart(57)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(58)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(61)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(62)
}
printHtmlPart(63)
})
invokeTag('form','g',219,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(64)
invokeTag('render','g',234,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(65)
expressionOut.print(member.status.name())
printHtmlPart(66)
expressionOut.print(member.status.name())
printHtmlPart(67)
expressionOut.print(member.birthday)
printHtmlPart(68)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434539020000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

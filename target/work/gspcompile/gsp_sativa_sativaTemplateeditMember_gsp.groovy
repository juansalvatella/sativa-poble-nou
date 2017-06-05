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
expressionOut.print(createLink(controller:'member', action:'amonished', params:[memberId:member.id]))
printHtmlPart(3)
if(true && (success)) {
printHtmlPart(4)
expressionOut.print(success)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (error)) {
printHtmlPart(7)
expressionOut.print(error)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (member.image)) {
printHtmlPart(10)
expressionOut.print(imagePerson)
printHtmlPart(11)
}
else {
printHtmlPart(12)
invokeTag('img','g',61,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(15)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(member.code)
printHtmlPart(18)
invokeTag('formatDate','g',76,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',79,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(20)
expressionOut.print(card?.code)
printHtmlPart(21)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(22)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(23)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (yellowCard > 0)) {
printHtmlPart(26)
for( _it432112010 in (1..yellowCard) ) {
changeItVariable(_it432112010)
printHtmlPart(27)
invokeTag('img','g',93,['dir':("css/img"),'file':("yellowCard.jpg"),'width':("50")],-1)
printHtmlPart(28)
expressionOut.print(createLink(controller:'member', action:'forgiveAmonished', params:[memberId:member.id]))
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(1, {->
printHtmlPart(32)
expressionOut.print(member.id)
printHtmlPart(33)
expressionOut.print(member.firstname)
printHtmlPart(34)
expressionOut.print(member.lastname)
printHtmlPart(35)
expressionOut.print(member.identificationNumber)
printHtmlPart(36)
expressionOut.print(member.address)
printHtmlPart(37)
expressionOut.print(member.phone)
printHtmlPart(38)
if(true && (member.consum.name() == 'CONSUM_LUDIC')) {
printHtmlPart(39)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (member.consum.name() == 'CONSUM_THERAPEUTIC')) {
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
})
invokeTag('form','g',166,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(44)
if(true && (numInvitations >= 5)) {
printHtmlPart(45)
invokeTag('img','g',170,['id':("imageAlertGuest"),'dir':("images/imageSativa"),'file':("warning.png"),'width':("80"),'height':("80")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
createTagBody(1, {->
printHtmlPart(48)
expressionOut.print(member.id)
printHtmlPart(49)
})
invokeTag('form','g',187,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(50)
expressionOut.print(grams.monthly)
printHtmlPart(51)
if(true && (member.status.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(52)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(53)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(54)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(55)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(56)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(57)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__REMOVED')) {
printHtmlPart(58)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
for( _it1864341563 in (listGenetics) ) {
changeItVariable(_it1864341563)
printHtmlPart(61)
expressionOut.print(it.name)
printHtmlPart(62)
}
printHtmlPart(63)
invokeTag('cookie','g',210,['name':("myCookie")],-1)
printHtmlPart(64)
createTagBody(1, {->
printHtmlPart(65)
expressionOut.print(member.id)
printHtmlPart(66)
})
invokeTag('form','g',217,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(67)
for( _it54755964 in (listEvents) ) {
changeItVariable(_it54755964)
printHtmlPart(68)
expressionOut.print(it.writer)
printHtmlPart(69)
invokeTag('formatDate','g',220,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(70)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(71)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(72)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(73)
}
else {
printHtmlPart(74)
}
printHtmlPart(75)
expressionOut.print(it.observation)
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(78)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(79)
}
printHtmlPart(80)
invokeTag('set','g',251,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(81)
invokeTag('set','g',252,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(81)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(82)
invokeTag('set','g',254,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(81)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(82)
invokeTag('set','g',257,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(81)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(82)
invokeTag('set','g',260,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(81)
}
printHtmlPart(83)
createTagBody(1, {->
printHtmlPart(84)
expressionOut.print(member.id)
printHtmlPart(85)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(86)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(87)
}
printHtmlPart(88)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(89)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(90)
}
printHtmlPart(91)
})
invokeTag('form','g',285,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(92)
invokeTag('render','g',300,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(93)
expressionOut.print(member.status.name())
printHtmlPart(94)
expressionOut.print(member.status.name())
printHtmlPart(95)
expressionOut.print(member.birthday)
printHtmlPart(96)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1495836084046L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

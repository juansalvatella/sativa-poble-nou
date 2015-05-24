import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplateshowInvitates_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/showInvitates.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('form','g',47,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'searchInvitate',controller:'member'])],1)
printHtmlPart(3)
expressionOut.print(listInvitates?.size())
printHtmlPart(4)
if(true && (historicGuests)) {
printHtmlPart(5)
loop:{
int i = 0
for( mem in (historicGuests) ) {
printHtmlPart(6)
expressionOut.print(i+1)
printHtmlPart(7)
expressionOut.print(mem.guest.code)
printHtmlPart(8)
if(true && (mem.guest.image)) {
printHtmlPart(9)
invokeTag('img','g',70,['dir':("css/img/partners"),'id':(mem.guest.image),'class':("seeImage"),'file':(mem.guest.image),'width':("50"),'height':("50")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(11)
invokeTag('img','g',73,['dir':("css/img"),'id':("avatar.png"),'class':("seeImage"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(mem.guest.firstname)
printHtmlPart(7)
expressionOut.print(mem.guest.lastname)
printHtmlPart(14)
expressionOut.print(mem.guest.identificationNumber)
printHtmlPart(14)
expressionOut.print(mem.entry)
printHtmlPart(14)
expressionOut.print(mem.friend.firstname)
printHtmlPart(7)
expressionOut.print(mem.friend.lastname)
printHtmlPart(14)
expressionOut.print(mem.numberEntries)
printHtmlPart(15)
if(true && (mem.numberEntries >= 5)) {
printHtmlPart(16)
invokeTag('img','g',82,['dir':("images/imageSativa"),'file':("warning.png"),'width':("20"),'height':("20")],-1)
printHtmlPart(15)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('render','g',108,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432477142000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

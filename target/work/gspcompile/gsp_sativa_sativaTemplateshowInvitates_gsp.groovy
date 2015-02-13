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
if(true && (listInvitates)) {
printHtmlPart(5)
loop:{
int i = 0
for( mem in (listInvitates) ) {
printHtmlPart(6)
expressionOut.print(i+1)
printHtmlPart(7)
if(true && (mem.image)) {
printHtmlPart(8)
invokeTag('img','g',69,['dir':("css/img/partners"),'id':(mem.image),'class':("seeImage"),'file':(mem.image),'width':("50"),'height':("50")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(10)
invokeTag('img','g',72,['dir':("css/img"),'id':("avatar.png"),'class':("seeImage"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(mem.firstname)
printHtmlPart(13)
expressionOut.print(mem.lastname)
printHtmlPart(14)
expressionOut.print(mem.identificationNumber)
printHtmlPart(14)
expressionOut.print(mem.dateCreated)
printHtmlPart(14)
expressionOut.print(mem.friend.firstname)
printHtmlPart(13)
expressionOut.print(mem.friend.lastname)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('render','g',102,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1421676726000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

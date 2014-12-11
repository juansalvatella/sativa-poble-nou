import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatecreateMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/createMember.gsp" }
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
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(memberId)
printHtmlPart(6)
for( _it472880938 in (listMembers) ) {
changeItVariable(_it472880938)
printHtmlPart(7)
expressionOut.print(it.id)
printHtmlPart(8)
expressionOut.print(it.firstname)
printHtmlPart(9)
expressionOut.print(it.lastname)
printHtmlPart(10)
}
printHtmlPart(11)
})
invokeTag('form','g',73,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'member'])],1)
printHtmlPart(12)
for( _it2020431066 in (listGenetics) ) {
changeItVariable(_it2020431066)
printHtmlPart(13)
expressionOut.print(it.name)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('render','g',99,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(16)
expressionOut.print(numCard)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416007103000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

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
if(true && (error)) {
printHtmlPart(5)
expressionOut.print(error)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(memberId)
printHtmlPart(9)
for( _it516612091 in (listMembers) ) {
changeItVariable(_it516612091)
printHtmlPart(10)
expressionOut.print(it.id)
printHtmlPart(11)
expressionOut.print(it.firstname)
printHtmlPart(12)
expressionOut.print(it.lastname)
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('form','g',76,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'member'])],1)
printHtmlPart(15)
for( _it423028616 in (listGenetics) ) {
changeItVariable(_it423028616)
printHtmlPart(16)
expressionOut.print(it.name)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('render','g',102,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(19)
expressionOut.print(numCard)
printHtmlPart(20)
expressionOut.print(memberId)
printHtmlPart(21)
expressionOut.print(memberId)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1418917934000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

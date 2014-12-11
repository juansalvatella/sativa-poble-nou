import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplategenetics_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/genetics.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
for( _it941371872 in (listTypes) ) {
changeItVariable(_it941371872)
printHtmlPart(3)
expressionOut.print(it.id)
printHtmlPart(4)
expressionOut.print(it.name)
printHtmlPart(5)
}
printHtmlPart(6)
})
invokeTag('form','g',38,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'genetic'])],1)
printHtmlPart(7)
invokeTag('set','g',43,['var':("count"),'value':(1)],-1)
printHtmlPart(8)
for( _it1125025255 in (listGenetics) ) {
changeItVariable(_it1125025255)
printHtmlPart(9)
if(true && (it.status.name()=='GENETIC_STATUS__ENABLED')) {
printHtmlPart(10)
expressionOut.print(createLink(controller:'genetic', action:'disabled', params:[geneticId:it.id]))
printHtmlPart(11)
invokeTag('img','g',51,['dir':("css/img"),'file':("publicado.png")],-1)
printHtmlPart(12)
}
else if(true && (it.status.name()=='GENETIC_STATUS__DISABLED')) {
printHtmlPart(10)
expressionOut.print(createLink(controller:'genetic', action:'enabled', params:[geneticId:it.id]))
printHtmlPart(11)
invokeTag('img','g',56,['dir':("css/img"),'file':("despublicado.png")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(it.name)
printHtmlPart(14)
if(true && (count % 3 == 0 && count!=0)) {
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('set','g',63,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('render','g',82,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416156835000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

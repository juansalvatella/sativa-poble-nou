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
if(true && (error)) {
printHtmlPart(3)
expressionOut.print(error)
printHtmlPart(4)
}
printHtmlPart(5)
for( _it88901532 in (listTypes) ) {
changeItVariable(_it88901532)
printHtmlPart(6)
expressionOut.print(it.id)
printHtmlPart(7)
expressionOut.print(it.name)
printHtmlPart(8)
}
printHtmlPart(9)
})
invokeTag('form','g',41,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'genetic'])],1)
printHtmlPart(10)
invokeTag('set','g',51,['var':("count"),'value':(1)],-1)
printHtmlPart(11)
for( _it1666913659 in (listGenetics) ) {
changeItVariable(_it1666913659)
printHtmlPart(12)
if(true && (it.status.name()=='GENETIC_STATUS__ENABLED')) {
printHtmlPart(13)
expressionOut.print(createLink(controller:'genetic', action:'disabled', params:[geneticId:it.id]))
printHtmlPart(14)
invokeTag('img','g',59,['dir':("css/img"),'file':("publicado.png")],-1)
printHtmlPart(15)
}
else if(true && (it.status.name()=='GENETIC_STATUS__DISABLED')) {
printHtmlPart(13)
expressionOut.print(createLink(controller:'genetic', action:'enabled', params:[geneticId:it.id]))
printHtmlPart(14)
invokeTag('img','g',64,['dir':("css/img"),'file':("despublicado.png")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(it.name)
printHtmlPart(17)
if(true && (count % 3 == 0 && count!=0)) {
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('set','g',71,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('set','g',77,['var':("count"),'value':(1)],-1)
printHtmlPart(22)
for( _it1893691698 in (listGenetics) ) {
changeItVariable(_it1893691698)
printHtmlPart(12)
expressionOut.print(it.name)
printHtmlPart(23)
expressionOut.print(createLink(controller:'genetic', action:'remove', params:[geneticId:it.id]))
printHtmlPart(7)
invokeTag('img','g',83,['width':("20"),'dir':("css/img"),'file':("delete-genetic.png")],-1)
printHtmlPart(24)
if(true && (count % 3 == 0 && count!=0)) {
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('set','g',87,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(20)
}
printHtmlPart(25)
invokeTag('render','g',109,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(26)
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

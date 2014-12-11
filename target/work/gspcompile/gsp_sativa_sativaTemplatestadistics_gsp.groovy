import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatestadistics_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/stadistics.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('form','g',30,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'day',controller:'geneticOrders'])],1)
printHtmlPart(3)
if(true && (stadisticsPerDay)) {
printHtmlPart(4)
for( _it824445694 in (stadisticsPerDay) ) {
changeItVariable(_it824445694)
printHtmlPart(5)
expressionOut.print(it.partner.code)
printHtmlPart(6)
expressionOut.print(it.genetic.name)
printHtmlPart(6)
expressionOut.print(it.amount)
printHtmlPart(6)
expressionOut.print(it.genetic.type.grams*it.amount)
printHtmlPart(7)
expressionOut.print(it.genetic.type.price*it.amount)
printHtmlPart(8)
invokeTag('formatDate','g',56,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(9)
invokeTag('img','g',57,['dir':("css/img/geneticOrdersSigns"),'file':("${it.id}.png"),'class':("imageSign"),'base':(grailsApplication.config.grails.serverURL)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(16)
})
invokeTag('form','g',95,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'periodic',controller:'geneticOrders'])],1)
printHtmlPart(17)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(18)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(19)
for( _it530810224 in (stadisticsPerPeriod) ) {
changeItVariable(_it530810224)
printHtmlPart(20)
expressionOut.print(it.partner.id)
printHtmlPart(21)
expressionOut.print(it.amount)
printHtmlPart(22)
}
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(15)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(16)
})
invokeTag('form','g',152,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'genetics',controller:'geneticOrders'])],1)
printHtmlPart(17)
if(true && (listGenetics)) {
printHtmlPart(28)
invokeTag('set','g',157,['var':("count"),'value':(1)],-1)
printHtmlPart(29)
for( _it680365130 in (listGenetics) ) {
changeItVariable(_it680365130)
printHtmlPart(30)
expressionOut.print(it.name.name)
printHtmlPart(31)
expressionOut.print(it.amount)
printHtmlPart(32)
expressionOut.print(it.name.type.grams * it.amount)
printHtmlPart(33)
if(true && (count % 5 == 0 && count!=0)) {
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('set','g',166,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('render','g',182,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(39)
expressionOut.print(daySelected)
printHtmlPart(40)
expressionOut.print(start)
printHtmlPart(41)
expressionOut.print(end)
printHtmlPart(42)
expressionOut.print(page)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1416352716000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

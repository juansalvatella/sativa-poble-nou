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
for( _it655764443 in (stadisticsPerDay) ) {
changeItVariable(_it655764443)
printHtmlPart(5)
expressionOut.print(it.partner?.code)
printHtmlPart(6)
expressionOut.print(it.genetic.name)
printHtmlPart(6)
expressionOut.print(it.genetic.type.grams*it.amount)
printHtmlPart(7)
invokeTag('formatDate','g',53,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(8)
invokeTag('img','g',54,['dir':("css/img/geneticOrdersSigns"),'file':("${it.id}.png"),'class':("imageSign"),'base':(grailsApplication.config.grails.serverURL)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(15)
})
invokeTag('form','g',92,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'periodic',controller:'geneticOrders'])],1)
printHtmlPart(16)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(17)
expressionOut.print(totalPerPeriod)
printHtmlPart(18)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(19)
for( _it546917097 in (stadisticsPerPeriod) ) {
changeItVariable(_it546917097)
printHtmlPart(20)
expressionOut.print(it.partner?.code)
printHtmlPart(21)
expressionOut.print(it.grams)
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
printHtmlPart(14)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(28)
})
invokeTag('form','g',150,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'genetics',controller:'geneticOrders'])],1)
printHtmlPart(16)
if(true && (listGenetics)) {
printHtmlPart(29)
invokeTag('set','g',155,['var':("count"),'value':(1)],-1)
printHtmlPart(30)
expressionOut.print(totalBuys)
printHtmlPart(31)
expressionOut.print(totalGrams)
printHtmlPart(32)
for( _it805640119 in (listGenetics) ) {
changeItVariable(_it805640119)
printHtmlPart(33)
expressionOut.print(it.name.name)
printHtmlPart(34)
expressionOut.print(it.amount)
printHtmlPart(35)
expressionOut.print(it.name.type.grams * it.amount)
printHtmlPart(36)
if(true && (count % 5 == 0 && count!=0)) {
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('set','g',165,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(39)
}
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('render','g',188,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(42)
expressionOut.print(resource(dir:'js/pluginsSativa/chart', file: 'jquery.flot.js'))
printHtmlPart(43)
expressionOut.print(daySelected)
printHtmlPart(44)
expressionOut.print(start)
printHtmlPart(45)
expressionOut.print(start)
printHtmlPart(46)
expressionOut.print(end)
printHtmlPart(47)
expressionOut.print(end)
printHtmlPart(48)
expressionOut.print(graph)
printHtmlPart(49)
expressionOut.print(graph?.name)
printHtmlPart(50)
expressionOut.print(graph?.buys)
printHtmlPart(51)
expressionOut.print(graph?.days)
printHtmlPart(52)
expressionOut.print(page)
printHtmlPart(53)
expressionOut.print(page)
printHtmlPart(54)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434546207000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

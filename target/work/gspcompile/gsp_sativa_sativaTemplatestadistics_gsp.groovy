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
for( _it822933517 in (stadisticsPerDay) ) {
changeItVariable(_it822933517)
printHtmlPart(5)
expressionOut.print(it.partner.code)
printHtmlPart(6)
expressionOut.print(it.genetic.name)
printHtmlPart(6)
expressionOut.print(it.genetic.type.grams*it.amount)
printHtmlPart(7)
invokeTag('formatDate','g',51,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(8)
invokeTag('img','g',52,['dir':("css/img/geneticOrdersSigns"),'file':("${it.id}.png"),'class':("imageSign"),'base':(grailsApplication.config.grails.serverURL)],-1)
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
invokeTag('form','g',90,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'periodic',controller:'geneticOrders'])],1)
printHtmlPart(16)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(17)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(18)
for( _it1248933539 in (stadisticsPerPeriod) ) {
changeItVariable(_it1248933539)
printHtmlPart(19)
expressionOut.print(it.partner.code)
printHtmlPart(20)
expressionOut.print(it.amount)
printHtmlPart(21)
}
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(26)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(27)
})
invokeTag('form','g',147,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'genetics',controller:'geneticOrders'])],1)
printHtmlPart(16)
if(true && (listGenetics)) {
printHtmlPart(28)
invokeTag('set','g',152,['var':("count"),'value':(1)],-1)
printHtmlPart(29)
for( _it1320824195 in (listGenetics) ) {
changeItVariable(_it1320824195)
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
invokeTag('set','g',161,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('render','g',177,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(39)
expressionOut.print(daySelected)
printHtmlPart(40)
expressionOut.print(start)
printHtmlPart(41)
expressionOut.print(start)
printHtmlPart(42)
expressionOut.print(end)
printHtmlPart(43)
expressionOut.print(end)
printHtmlPart(44)
expressionOut.print(page)
printHtmlPart(45)
expressionOut.print(page)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425592697000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

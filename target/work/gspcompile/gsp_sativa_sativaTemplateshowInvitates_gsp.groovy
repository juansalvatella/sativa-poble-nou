import sun.misc.BASE64Encoder
import sun.misc.BASE64Decoder
import javax.imageio.ImageIO
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
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
invokeTag('render','g',5,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('form','g',49,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'searchInvitate',controller:'member'])],1)
printHtmlPart(5)
expressionOut.print(listInvitates?.size())
printHtmlPart(6)
if(true && (historicGuests)) {
printHtmlPart(7)
loop:{
int i = 0
for( mem in (historicGuests) ) {
printHtmlPart(8)
expressionOut.print(i+1)
printHtmlPart(9)
expressionOut.print(mem.guest.code)
printHtmlPart(10)
if(true && (mem.guest.image)) {
printHtmlPart(11)

def guestImage
					 										try {
																def imageAux		  = ImageIO.read(new File("/usr/sativaImages/partners/"+mem.guest.image));
																ByteArrayOutputStream bos = new ByteArrayOutputStream();
															 	ImageIO.write(imageAux, "png", bos);
																byte[] imageBytes	  = bos.toByteArray();
																BASE64Encoder encoder = new BASE64Encoder();
													        	guestImage = encoder.encode(imageBytes);
													        }catch(all){}

printHtmlPart(12)
expressionOut.print(guestImage)
printHtmlPart(13)
expressionOut.print(mem.guest.image)
printHtmlPart(14)
}
else {
printHtmlPart(15)
invokeTag('img','g',87,['dir':("css/img"),'id':("avatar.png"),'class':("seeImage"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(mem.guest.firstname)
printHtmlPart(9)
expressionOut.print(mem.guest.lastname)
printHtmlPart(18)
expressionOut.print(mem.guest.identificationNumber)
printHtmlPart(18)
expressionOut.print(mem.entry)
printHtmlPart(18)
expressionOut.print(mem.friend.firstname)
printHtmlPart(9)
expressionOut.print(mem.friend.lastname)
printHtmlPart(18)
expressionOut.print(mem.numberEntries)
printHtmlPart(19)
if(true && (mem.numberEntries >= 5)) {
printHtmlPart(20)
invokeTag('img','g',96,['dir':("images/imageSativa"),'file':("warning.png"),'width':("20"),'height':("20")],-1)
printHtmlPart(19)
}
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('render','g',122,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1438283124000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

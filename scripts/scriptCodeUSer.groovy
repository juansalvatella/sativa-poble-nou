
import com.sativa.domain.*
  
  
  def listPartners = Partner.createCriteria().list {}

  



listPartners.each {Partner p -> 
  
  Date now = p.dateCreated
  String dayString   = now.getAt(Calendar.DATE)
  String monthString = now.getAt(Calendar.MONTH)+1
  String yearString  = now.getAt(Calendar.YEAR)
  yearString 		   = yearString.substring(2)
  dayString   	   = dayString.padLeft(2, '0')
  monthString 	   = monthString.padLeft(2, '0')
  
  String countString = p.code.substring(p.code.size()-3)
  
 	 
  p.code = dayString+monthString+yearString+countString.padLeft(3,'0')
  
}

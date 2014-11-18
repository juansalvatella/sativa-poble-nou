import com.sativa.domain.Partner
import com.sativa.domain.Role
import com.sativa.domain.PartnerRole
import com.sativa.domain.Genetic
import com.sativa.domain.GeneticOrders
import com.sativa.domain.GeneticType

import com.sativa.enums.PartnerStatusEnum
class BootStrap {

   def init = { servletContext ->
   	 TimeZone.setDefault(TimeZone.getTimeZone("UTC"))

   	def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_PARTNER').save(flush: true)
      def sellerRole = new Role(authority: 'ROLE_SELLER').save(flush: true)
      def testUser
      try {
         testUser = new Partner(username: 'me', password: 'password', code:"001", firstname:"pedro", lastname:"garcia", email:"aa", address:"calle anonimo 123 Barcelona", identificationNumber:"38879780M", status:PartnerStatusEnum.PARTNER_STATUS__ACTIVED)
         if (!testUser.validate()) println "eroress "+testUser.errors
         testUser.save(flush: true)
         testUser.encodePassword()

      }
      catch(all){
         println "all "+all.getMessage()
         println "aaaaaaa "+all.dump()
      }
      def testUser2 = new Partner(username: 'me2', password: 'password2', code:"002", firstname:"juan", lastname:"garcia", email:"aa", address:"calle anonimo 123 Barcelona", identificationNumber:"38879780M", status:PartnerStatusEnum.PARTNER_STATUS__ACTIVED)
      
      testUser2.save(flush: true)
      testUser2.encodePassword()


println "user 1 "+testUser.id
println "user 2 "+testUser2.id
      PartnerRole.create testUser, adminRole, true
      PartnerRole.create testUser, userRole, true
      PartnerRole.create testUser, sellerRole, true
      PartnerRole.create testUser, userRole, true

      def geneticType = new GeneticType(name:"TIPO1", price:1.34, grams:0.80, color:"#088A08")
      geneticType.save(flush:true)

      def genetic = new Genetic(name:"genetica1", type:geneticType)
      def genetic2 = new Genetic(name:"genetica2", type:geneticType)
      def genetic3 = new Genetic(name:"genetica3", type:geneticType)
      def genetic4 = new Genetic(name:"genetica4", type:geneticType)
      def genetic5 = new Genetic(name:"genetica5", type:geneticType)
      def genetic6 = new Genetic(name:"genetica6", type:geneticType)
      def genetic7 = new Genetic(name:"genetica7", type:geneticType)
      def genetic8 = new Genetic(name:"genetica8", type:geneticType)
      def genetic9 = new Genetic(name:"genetica9", type:geneticType)
      def genetic10 = new Genetic(name:"genetica10", type:geneticType)
      def genetic11 = new Genetic(name:"genetica12", type:geneticType)
      def genetic12 = new Genetic(name:"genetica13", type:geneticType)
      def genetic13 = new Genetic(name:"genetica14", type:geneticType)
      def genetic14= new Genetic(name:"genetica15", type:geneticType)
      def genetic15 = new Genetic(name:"genetica16", type:geneticType)
      def genetic16 = new Genetic(name:"genetica17", type:geneticType)
      def genetic17 = new Genetic(name:"genetica18", type:geneticType)
      def genetic18= new Genetic(name:"genetica19", type:geneticType)
      genetic.save(flush:true)
      genetic2.save(flush:true)
      genetic3.save(flush:true)
      genetic4.save(flush:true)
      genetic5.save(flush:true)
      genetic6.save(flush:true)
      genetic7.save(flush:true)
      genetic8.save(flush:true)
      genetic9.save(flush:true)
      genetic10.save(flush:true)
      genetic11.save(flush:true)
      genetic12.save(flush:true)
      genetic13.save(flush:true)
      genetic14.save(flush:true)
      genetic15.save(flush:true)
      genetic16.save(flush:true)
      genetic17.save(flush:true)
      genetic18.save(flush:true)

        Date.metaClass.'static'.fromISO = { String date ->
            if (!date) return null
            try {
                return new java.sql.Timestamp(javax.xml.bind.DatatypeConverter.parseDateTime(date).getTimeInMillis())
            }
            catch(IllegalArgumentException iae) {
                log.error "Invalid date input. Must be a String with format 'yyyy-MM-dd'T'HH:mm:ssZ'"
                return null
            }
        }
   }
}
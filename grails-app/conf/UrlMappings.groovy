class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/sativaTemplate/login")
        name createMember: "/crear-socio"(view:"/sativaTemplate/createMember")
        name searchMember: "/buscar-socio"(view:"/sativaTemplate/searchMembers")
        name managementMembers: "/gestionar-socios"(controller:"member", action:"list")
        name managementGenetics: "/gestionar-geneticas" (controller:"genetic", action:"list")
        name stadistics: "/estadisticas"(view:"/sativaTemplate/stadistics")
        name searchPartner: "/gestionar-socio"(controller:"partner", action:"list")

        
        "500"(view:'/error')
	}
}

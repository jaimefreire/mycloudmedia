class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        //"/"(controller:"info")
        "/"(view: "index")

        "500"(view: '/error')
    }
}

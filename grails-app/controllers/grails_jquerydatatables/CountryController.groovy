package grails_jquerydatatables


class CountryController {

    DatatablesSourceService datatablesSourceService

    def index() {
        render("hello")
    }

    def dataTablesRenderer() {
        List<String> propertiesToRender = ["id", "name", "capital", "flag", "coatOfArms"]
        def entityName = Country.class
        println datatablesSourceService.dataTablesSource(propertiesToRender, entityName, params)
        render(datatablesSourceService.dataTablesSource(propertiesToRender, entityName, params))
    }
}

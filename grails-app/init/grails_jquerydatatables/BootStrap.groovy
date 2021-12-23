package grails_jquerydatatables


import groovy.json.JsonSlurper

class BootStrap {

    def init = { servletContext ->

        if (Country.list().size() == 0) {

            try {
                File inputFile = new File("/home/raffi/IdeaProjects/Grails_JquerydataTables/grails-app/assets/package.json")
                def InputJSON = new JsonSlurper().parseText(inputFile.text)

                InputJSON.each {
                    String name = it?.name?.common
                    String coatOfArms = it?.coatOfArms?.svg
                    String capital = it?.capital?.get(0)
                    String flag = it?.flag

                    new Country(name, capital, flag, coatOfArms).save()
                }
            }
            catch (Exception e) {
                e.getCause()
            }

        }
    }

    def destroy = {
    }
}

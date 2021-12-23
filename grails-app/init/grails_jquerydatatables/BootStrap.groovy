package grails_jquerydatatables


import groovy.json.JsonSlurper
import org.grails.io.support.ClassPathResource
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class BootStrap {

    private final static LOGGER = LoggerFactory.getLogger(BootStrap.class)

    def init = { servletContext ->
        if (Country.list().size() == 0) {

            try {
                ClassPathResource classPathResource = new ClassPathResource("data.json");

//              File inputFile = new File(this.class.classLoader.getResource('data.json').getFile())
                File inputFile = classPathResource.getFile()


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
                LOGGER.error(e.message)
            }

        }
    }

    def destroy = {
    }
}

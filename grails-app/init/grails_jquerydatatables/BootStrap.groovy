package grails_jquerydatatables

import groovy.json.JsonSlurper
import org.grails.io.support.ClassPathResource
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class BootStrap {

    private final static Logger LOGGER = LoggerFactory.getLogger(BootStrap.class)

    def init = { servletContext ->
        if (Country.list().size() == 0) {

            try {
                /*
                see also http://docs.grails.org/3.1.2/api/org/grails/io/support/ClassPathResource.html
                OR CEN USE File inputFile = new File(this.class.classLoader.getResource('data.json').getFile())
                */
                ClassPathResource classPathResource = new ClassPathResource("data.json");
                if (!classPathResource.exists()) {
                    throw new Exception("File NOT EXIST")
                }

                //create file
                File inputFile = classPathResource.getFile()

                //create json object
                def inputJSON = new JsonSlurper().parseText(inputFile.text)
                inputJSON.each {
                    String name = it?.name?.common
                    String coatOfArms = it?.coatOfArms?.svg
                    String capital = it?.capital?.get(0)
                    String flag = it?.flag

                    //create Country entity and saved
                    new Country(name, capital, flag, coatOfArms).save()
                }
                println("ALL DATA LOADED ${inputJSON.size()}-data ")
            }
            catch (Exception e) {
                LOGGER.error(e.message)
            }

        }
    }

    def destroy = {
    }
}

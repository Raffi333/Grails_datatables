package grails_jquerydatatables

class Country {

    String name;
    String capital;
    String flag;
    String coatOfArms;

    Country(String name, String capital, String flag, String coatOfArms) {
        this.name = name
        this.capital = capital
        this.flag = flag
        this.coatOfArms = coatOfArms
    }
    static constraints = {
        name()
        capital()
        flag()
        coatOfArms()
    }
}

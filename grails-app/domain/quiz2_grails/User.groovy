package quiz2_grails

class User {

    String cedula
    String name
    String lastName
    String email
    Date bornDate

    static constraints = {
        cedula maxSize: 13
        name maxSize: 255
        cedula(cedula: true)
        name(name: true)
        lastName(lastName: true)
        email(email: true)
        bornDate(bornDate:true)
    }
}

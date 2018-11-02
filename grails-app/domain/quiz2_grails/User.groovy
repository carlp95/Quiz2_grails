package quiz2_grails

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes = 'cedula')
@ToString(includes = 'cedula', includeNames = true, includePackage = false)
class User implements Serializable{

    private static final long serialVersionUID = 1

    transient springSecurityService

    String cedula
    String password
    String name
    String lastName
    String email
    Date bornDate

    Set<Roles> getAuthorities() {
        UserRoles.findAllByUsuario(this)*.roles
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (this.isDirty('password')) { //TODO: verificar en en foro.
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']


    static constraints = {
        cedula maxSize: 13
        name maxSize: 255
        password blank: false, password: true
        cedula blank: false, unique: true
        name(name: true)
        lastName(lastName: true)
        email(email: true)
        bornDate(bornDate:true)
    }
}

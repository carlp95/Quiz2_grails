package quiz2_grails

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    transient springSecurityService

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    String username
    String cedula
    String password
    String name
    String lastName
    String email
    Date bornDate

    Set<Roles> getAuthorities() {
        (UserRoles.findAllByUsuario(this) as List<UserRoles>)*.role as Set<Roles>
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (this.isDirty('password')) {
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

    static mapping = {
        password column: '`password`'
    }
}

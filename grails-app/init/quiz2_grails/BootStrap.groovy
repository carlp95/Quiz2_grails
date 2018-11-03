package quiz2_grails

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        User admin = new User(username: 'admin',
                cedula: '40223847837',
                password: springSecurityService.encodePassword("admin123"),
                name: 'Juanito',
                lastName: 'Rodríguez',
                email: 'juanito1@gmail.com',
                bornDate: new Date(1990,11,02)).save(failOnError: true)

        def adminRole = new Roles(authority: 'ROLE_ADMIN').save( failOnError: true )
        def userRole = new Roles(authority: 'ROLE_USER').save( failOnError: true )

        UserRoles.create( admin, adminRole )
        UserRoles.create( admin, userRole )
    }
    def destroy = {
    }
}

package quiz2_grails

class BootStrap {

    def init = { servletContext ->
        User user = new User(cedula: '40223847837',password: 'admin123', name: 'Juanito', lastName: 'Rodríguez', email: 'juanito1@gmail.com', bornDate: new Date(1990,11,02)).save(failOnError: true)

        def adminRole = new Roles(authority: 'ROLE_ADMIN').save( failOnError: true )
        def userRole = new Roles(authority: 'ROLE_USER').save( failOnError: true )

        UserRoles.create( user,adminRole )
    }
    def destroy = {
    }
}

package quiz2_grails

class BootStrap {

    def init = { servletContext ->
        new User(cdeula: '40223847837', name: 'Juanito', lastName: 'Rodríguez', email: 'juanito1@gmail.com', bornDate: new Date(1990,11,02))
    }
    def destroy = {
    }
}

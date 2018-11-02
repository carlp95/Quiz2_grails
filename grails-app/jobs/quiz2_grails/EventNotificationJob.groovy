package quiz2_grails

import groovy.time.TimeCategory

class EventNotificationJob {
    EventService eventService

    static triggers = {
      simple repeatInterval: 60_000l // execute job once in 60 seconds
    }

    def execute() {
        List<Event> eventList = eventService.list()
        Date now = new Date()
        for (Event event : eventList) {
            if (TimeCategory.minus(event.startDate, now).minutes <= 5) {
                println "Faltan 5 minutos para que el evento " + event.getName() + " comienze!"
            }
        }
    }
}

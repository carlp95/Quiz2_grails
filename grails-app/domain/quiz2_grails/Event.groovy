package quiz2_grails

class Event {

    String name
    String description
    Date startDate
    Date endDate
    Integer minimunAge

    static constraints = {
        minimunAge min: 0
        minimunAge max: 100
        name maxSize: 255
        name(name: true)
        description(description:true)
        startDate(startDate:true)
        endDate(endDate:true)
        minimunAge(minimunAge:true)
    }
}

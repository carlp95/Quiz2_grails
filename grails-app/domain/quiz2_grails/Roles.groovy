package quiz2_grails

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes = 'authority')
@ToString(includes = 'authority', includeNames = true, includePackage = false)
class Roles {

    String authority

    static constraints = {
        authority blank: false, unique: true
    }
}

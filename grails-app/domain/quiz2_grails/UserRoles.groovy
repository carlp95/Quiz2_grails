package quiz2_grails

import grails.gorm.DetachedCriteria
import groovy.transform.ToString
import org.apache.commons.lang.builder.HashCodeBuilder


@ToString(cache = true, includeNames = true, includePackage = false)
class UserRoles implements Serializable{

    private static final long serialVersionUID = 1

    User user
    Roles role
    @Override
    boolean equals(other) {
        if (other instanceof UserRoles) {
            other.userId == user?.id && other.roleId == role?.id
        }
    }

    @Override
    int hashCode() {
        def builder = new HashCodeBuilder()
        if (user) builder.append(user.id)
        if (role) builder.append(role.id)
        builder.toHashCode()
    }

    static UserRoles get(long userId, long roleId) {
        criteriaFor(userId, roleId).get()
    }

    static boolean exists(long userId, long roleId) {
        criteriaFor(userId, roleId).count()
    }

    private static DetachedCriteria criteriaFor(long userId, long roleId) {
        UserRoles.where {
            user == User.load(userId) &&
                    role == Roles.load(roleId)
        }
    }

    static UserRoles create(User user, Roles role) {
        def instance = new UserRoles(user: user, role: role)
        instance.save()
        instance
    }

    static boolean remove(User u, Roles r) {
        if (u != null && r != null) {
            UserRoles.where { user == u && role == r }.deleteAll()
        }
    }

    static int removeAll(User u) {
        u == null ? 0 : UserRoles.where { user == u }.deleteAll()
    }

    static int removeAll(Roles r) {
        r == null ? 0 : UserRoles.where { role == r }.deleteAll()
    }

    static constraints = {
        role validator: { Roles r, UserRoles ur ->
            if (ur.user?.id) {
                UserRoles.withNewSession {
                    if (UserRoles.exists(ur.user.id, r.id)) {
                        return ['userRole.exists']
                    }
                }
            }
        }
    }

    static mapping = {
        id composite: ['user', 'roles']
        version false
    }
}

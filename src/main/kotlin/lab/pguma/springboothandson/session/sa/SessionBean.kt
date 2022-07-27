package lab.pguma.springboothandson.session.sa

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.SessionScope

@Component
@SessionScope
class SessionBean(var count: Int = 1)
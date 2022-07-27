package lab.pguma.springboothandson.session

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpSession

@RestController
@RequestMapping("/hs")
class HandsOnHttpSessionController constructor(
    @Autowired private val session: HttpSession
) {

    @GetMapping("/call")
    fun visit(): String {
        val counter = Optional.ofNullable(session.getAttribute("count"))
            .map { count -> count as Int + 1 }
            .orElse(1)

        session.setAttribute("count", counter)
        return "あなたのコール回数は${counter}回です"
    }

    @GetMapping("/reset")
    fun reset(): String {
        session.invalidate()
        return "コール回数をクリアしました"
    }

}
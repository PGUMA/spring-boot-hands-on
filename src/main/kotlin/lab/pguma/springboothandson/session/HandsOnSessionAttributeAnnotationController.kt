package lab.pguma.springboothandson.session

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.SessionStatus

class Container(var count: Int)

@RestController
@RequestMapping("/saa")
@SessionAttributes(value = ["count"])
class HandsOnSessionAttributeAnnotationController {

    @ModelAttribute("count")
    fun count(): Container? {
        return Container(0)
    }

    @GetMapping("/call")
    fun visit(@ModelAttribute("count") count: Container): String {
        val counter = count.count + 1
        count.count = counter

        return "あなたのコール回数は${counter}回です"
    }

    @GetMapping("reset")
    fun reset(sessionStatus: SessionStatus): String {
        sessionStatus.setComplete()
        return "コール回数をクリアしました"
    }

}
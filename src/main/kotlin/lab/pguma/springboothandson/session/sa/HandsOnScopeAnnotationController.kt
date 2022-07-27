package lab.pguma.springboothandson.session.sa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ssa")
class HandsOnScopeAnnotationController(
    private val count: SessionBean
) {

    @GetMapping("/call")
    fun visit(): String {
        val counter = count.count + 1
        count.count = counter

        return "あなたのコール回数は${counter}回です"
    }

    @GetMapping("/reset")
    fun reset(): String {
        // TODO 明示的に破棄する手段はあるのか？
        return "コール回数をクリアしました"
    }

}
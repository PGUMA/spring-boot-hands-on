package lab.pguma.springboothandson.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@RestController
class HandsOnRestController {

    @GetMapping("/get_path/{country}")
    fun get(
        @PathVariable country: Locale,
        @RequestParam("sei") familyName: String?,
        @RequestParam("mei") firstName: String?
    ): String {
        return if(country == Locale.JAPAN) {
            return "こんにちは ${familyName}${firstName}!!"
        } else {
            return "Hello ${familyName}${firstName}!!"
        }
    }

    @PostMapping("/post_path")
    fun post(@ModelAttribute data: PostData): String {
        return "${data.name}は${data.age}歳です"
    }

    class PostData(
        val name: String,
        val age: Int
    )
}
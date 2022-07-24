package lab.pguma.springboothandson

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootHandsOnApplication

fun main(args: Array<String>) {
	runApplication<SpringBootHandsOnApplication>(*args)
}

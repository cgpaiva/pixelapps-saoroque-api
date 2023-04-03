package br.com.pixelapps.saoroque.controller

import br.com.pixelapps.saoroque.model.Liturgia
import br.com.pixelapps.saoroque.service.LiturgiaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/home")
class LiturgiaController(private val service: LiturgiaService) {

    @GetMapping
    fun getLiturgia(
        @RequestHeader("dataLiturgia")
        dataLiturgia: String,
        @RequestHeader("authorization")
        authorization: String
    ): ResponseEntity<out Any> {
        return if (authorization == "7086a9d2-98d4-4e57-ad26-2319347a91db") {
            service.getHomeInformations(dataLiturgia)
        }else  {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PostMapping
    fun addLiturgia(
        @RequestBody
        liturgia: Liturgia,
        @RequestHeader("dataLiturgia")
        data: String
    ) {
        return service.addLiturgia(liturgia, data)
    }
}
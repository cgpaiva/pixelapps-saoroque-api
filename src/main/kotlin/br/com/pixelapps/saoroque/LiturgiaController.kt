package br.com.pixelapps.saoroque

import br.com.pixelapps.saoroque.model.Liturgia
import br.com.pixelapps.saoroque.service.LiturgiaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/liturgia")
class LiturgiaController(private val service: LiturgiaService) {

    @GetMapping
    fun getLiturgia(): Liturgia {
        return service.getLiturgia()
    }
}
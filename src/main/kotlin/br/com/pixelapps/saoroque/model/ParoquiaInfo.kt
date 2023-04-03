package br.com.pixelapps.saoroque.model

data class ParoquiaInfo(val pixSaoRoque: String, val whatsappSecretaria: String) {
    constructor() : this("", "")
}
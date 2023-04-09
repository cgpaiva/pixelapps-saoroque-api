package br.com.pixelapps.saoroque.model

import com.google.gson.annotations.SerializedName

data class Liturgia(
        val corLiturgica: String,
        val liturgiaTitulo: String,
        val liturgia: List<LiturgiaData>,
) {
    constructor() : this("", "", emptyList())
}

data class LiturgiaData(
        @SerializedName("liturgia")
        val liturgia: String,
        @SerializedName("liturgiaPosicao")
        val liturgiaPosicao: Int,
        @SerializedName("liturgiaTipo")
        val liturgiaTipo: String,
        @SerializedName("liturgiaTitulo")
        val liturgiaTitulo: String,
        @SerializedName("menuTitulo")
        val menuTitulo: String
) {
    constructor() : this("",1,"", "", "")
}
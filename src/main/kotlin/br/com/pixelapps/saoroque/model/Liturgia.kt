package br.com.pixelapps.saoroque.model

data class Liturgia(
        val corLiturgica: String,
        val evangelho: String,
        val evangelhoTitulo: String,
        val leituras: List<Leitura>,
        val liturgiaTitulo: String,
        val salmo: String,
        val salmoTitulo: String
) {
    constructor() : this("", "", "", emptyList(), "", "", "")
}

data class Leitura(
        val leitura: String,
        val livroLeitura: String,
        val tituloLeitura: String
) {
    constructor() : this("", "", "")
}

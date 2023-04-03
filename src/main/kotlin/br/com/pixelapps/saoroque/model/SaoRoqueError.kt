package br.com.pixelapps.saoroque.model

data class SaoRoqueError(val description: String): Exception(description)

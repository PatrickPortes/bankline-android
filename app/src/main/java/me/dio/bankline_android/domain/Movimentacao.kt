package me.dio.bankline_android.domain

data class Movimentacao(

    val id: Int,
    val dataHora: String,
    val descricao: String,
    val number: Double,
    val tipo: TipoMovimentacao,

    //TODO Mapear "idConta -> idCorrentista"
    val idCorrentista: Int

)

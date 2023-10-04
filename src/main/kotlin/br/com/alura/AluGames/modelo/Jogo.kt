package br.com.alura.AluGames.modelo

data class Jogo(
    val titulo: String,
    val capa: String
) {
    var descricao:String? = null
    override fun toString(): String {
        return "-----br.com.alura.AluGames.modelo.Jogo solicitado---- \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao"
    }
}
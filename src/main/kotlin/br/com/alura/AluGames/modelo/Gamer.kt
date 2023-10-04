package br.com.alura.AluGames.modelo

data class Gamer(var nome: String, var email: String) {
    var dataDeNascimento: String? = null
    var usuario: String? = null
    val idInterno: String? = null


    constructor(nome: String, email: String, dataDeNascimento: String, usuario: String) :
            this(nome, email) {
            this.dataDeNascimento = dataDeNascimento
            this.usuario = usuario
        }


    override fun toString(): String {

        return "-----Cadastrin---- \n" +
                "Gamer: $nome \n" +
                "Email: $email \n" +
                "Data de Nascimento: $dataDeNascimento\n" +
                "Usuario: $usuario \n" +
                "Identificador Interto: $idInterno"
    }
}


package br.com.alura.AluGames.modelo

import kotlin.random.Random


data class Gamer(var nome: String, var email: String) {
    var dataDeNascimento: String? = null
    var usuario: String? = null
    var idInterno: String? = null
        private set



    constructor(nome: String, email: String, dataDeNascimento: String, usuario: String) :
            this(nome, email) {
            this.dataDeNascimento = dataDeNascimento
            this.usuario = usuario
            criarIdInterno()
        }


    override fun toString(): String {

        return "-----Cadastrin---- \n" +
                "Gamer: $nome \n" +
                "Email: $email \n" +
                "Data de Nascimento: $dataDeNascimento\n" +
                "Usuario: $usuario \n" +
                "Identificador Interto: $idInterno"
    }


    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"

    }
}


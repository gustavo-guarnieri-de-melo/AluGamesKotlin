package br.com.alura.AluGames.principal

import br.com.alura.AluGames.modelo.Gamer
import java.util.Scanner

fun main(){
    var ler = Scanner(System.`in`)

//    val gamer1 = Gamer(
//        nome = "Gustavo",
//        email = "gustavo@email.com")
//    println(gamer1)

//    val gamer2 = Gamer(
//        "Davi",
//        "davi@email.com",
//        "19/08/2001",
//        "davijbatista",
//    )
//    println(gamer2)

//    gamer1.let {
//        it.usuario = "gustavoMelo"
//        it.dataDeNascimento = "19/09/2000"
//        it.nome = "Ola mundo"
//    }
//    println(gamer1)

    println("insira seu nome, email, data de nascimento e usuario")
    val gamer1 = Gamer(
        nome = "",
        email = "",
        dataDeNascimento = "",
        usuario = ""
    )
    gamer1.let {
        println("Insira o nome: ")
        it.nome= ler.nextLine()

        println("insira o email: ")
        it.email= ler.nextLine()

        println("Insira a data de nascimento: ")
        it.dataDeNascimento= ler.nextLine()

        println("Insira o nome do usuario: ")
        it.usuario = ler.nextLine()

    }.also {
        println(gamer1)
    }


}
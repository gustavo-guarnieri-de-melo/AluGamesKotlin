package br.com.alura.AluGames.principal

import br.com.alura.AluGames.modelo.*
import br.com.alura.AluGames.servicos.ConsumoApi
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)

    println("Digite o numero do ID: ")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val informacaoJogo = buscaApi.buscaJogo(busca)
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }
    resultado.onFailure {
        println("Digite o id novamente")
    }

    resultado.onSuccess {

        println("Vc deseja inserir uma descrição personalizada? (S/N)")
        val opcao = leitura.nextLine()

        descricao(opcao, leitura, meuJogo)
    }
    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }
}

private fun descricao(opcao: String?, leitura: Scanner, meuJogo: Jogo?) {
    if (opcao.equals("s", true)) {
        println("Insira a descrição: ")
        val descricaoPersonalizada = leitura.nextLine()


        meuJogo?.descricao = descricaoPersonalizada
    } else {
        meuJogo?.descricao = meuJogo?.titulo
    }
    println(meuJogo)
}

package br.com.alura.AluGames.servicos

import br.com.alura.AluGames.modelo.InfoJogo
import br.com.alura.AluGames.modelo.Jogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String):InfoJogo {

        val numeroDoId = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(numeroDoId))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()


        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo

    }
}
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.lang.NullPointerException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner
import kotlin.coroutines.coroutineContext


fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o numero do ID: ")
    val busca = leitura.next()

    val numeroDoId = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(numeroDoId))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
//            println(json)

    val gson = Gson()

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        val meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb
        )
        println(meuJogo)
    }
    resultado.onFailure {
        println("Digite o id novamente")
    }

    resultado.onSuccess {
        println("Vc deseja inserir uma descrição personalizada? (S/N)")
        val opcao = leitura.nextLine()
        if (opcao.equals("S", true)) {
            println("Insira a descrição: ")
            val descricao = leitura.nextLine()
            meuJogo?.descricao
        } else {
            return
        }
    }
}

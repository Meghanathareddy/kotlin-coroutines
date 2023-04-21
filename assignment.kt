import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {

    val values = mapOf("loyaltyId" to "56603160968","brand" to "BBW","email" to "l2@gmail.nz")
    val client = HttpClient.newBuilder().build()
    val request = HttpRequest.newBuilder().uri(URI.create("https://bbwmobiletest.lbidts.com/modules/v3/topnav/Home/post")).POST(formData(values).header("Content-Type", "application/json").build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    println(response.body())
}



fun String.utf8():String = URLEncoder.encode(this,"UTF-8")
fun formData(data:Map<String, String>):HttpRequest.BodyPublisher?{
    val res = data.map { (k, v) -> "${(k.utf8())} = $${v.utf8()}" }.joinToString("&")
    return HttpResponse.BodyPublishers.ofString(res)
}
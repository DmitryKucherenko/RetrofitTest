package data

import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("/book")
    suspend fun getBooks():ApiData
}

object ApiDateImpl{
  private val retrofit = Retrofit.Builder()
      .addConverterFactory(MoshiConverterFactory.create())
      .baseUrl("http://10.0.2.2:3000")
      .build()

    private val booksService = retrofit.create(Api::class.java)


     suspend fun getBooks(): List<String?> {
        return withContext(Dispatchers.IO) {
            booksService.getBooks().books
                                .map{
                result -> result.title
            }

        }
    }

}
package com.example.rdiandroiddevelopertest.api

import com.example.diggieservice.model.jual.Jual
import com.example.diggieservice.model.teknisi.Teknisi
import com.example.rdiandroiddevelopertest.model.Author
import com.example.rdiandroiddevelopertest.model.Genre
import com.example.rdiandroiddevelopertest.model.ItemsMovie
import com.example.rdiandroiddevelopertest.model.Movie
import retrofit2.Call
import retrofit2.http.*

interface DigieServiceInterface {
    @GET("/3/genre/movie/list")
    fun getGenre(
        @Query("api_key") api_key:String,
        @Query("language") language:String
    ): Call<Genre>
    @GET("/3/discover/movie")
    fun getListMovieByGenre(
        @Query("api_key") api_key:String,
        @Query("with_genres") genresId:String,
        @Query("page") page:Int
    ): Call<Movie>
    @GET("/3/movie/{movie_id}")
    fun getDetailsMovie(
        @Path("movie_id")movie_id:String?,
        @Query("api_key") api_key:String,
        @Query("language")language:String
    ):Call<ItemsMovie>
    @GET("/3/movie/{movie_id}/reviews")
    fun getReviewMovie(
        @Path("movie_id")movie_id:String,
        @Query("api_key")api_key: String,
        @Query("language")language: String,
        @Query("page")page: Int,
    ):Call<Author>


    @GET("/api/jual-all/{pelanggan}/{order}")
    fun getJual(
        @Path("pelanggan")pelanggan:String,
        @Path("order")order:String,
    ):Call<Jual>
    @GET("/api/teknisi-all/{param}/{order}")
    fun getTechnician(
        @Path("param")param:String,
        @Path("order")order:String
    ):Call<Teknisi>
//    @FormUrlEncoded
//    @POST("/api/user-one")(
//        @Path("username")
//    )
}
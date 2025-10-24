package com.belajar.responsi1mobileh1d023081.data.network


import com.belajar.responsi1mobileh1d023081.data.model.ClubSquadResponse
import com.belajar.responsi1mobileh1d023081.data.model.HeadCoachResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballDataApi {
    @GET("{clubId}")
    suspend fun getClubSquad(@Path("clubId") clubId: Int): Response<ClubSquadResponse>

    @GET("{clubId}")
    suspend fun getHeadCoach(@Path("clubId") clubId: Int): Response<HeadCoachResponse>
}
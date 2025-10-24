package com.belajar.responsi1mobileh1d023081.data.model


import com.google.gson.annotations.SerializedName

data class ClubSquadResponse(
    @SerializedName("squad")
    val squad: List<Squad>,
)

data class Squad(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String,
)
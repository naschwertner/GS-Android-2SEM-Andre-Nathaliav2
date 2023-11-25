package com.example.gs2semandrenathalia.Models.RequestBody

data class Params(
    val apiKey: String,
    val max: Int,
    val min: Int,
    val n: Int,
    val replacement: Boolean
)
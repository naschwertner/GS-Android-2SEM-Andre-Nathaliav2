package com.example.gs2semandrenathalia.Models.ResponseBody

data class Result(
    val advisoryDelay: Int,
    val bitsLeft: Int,
    val bitsUsed: Int,
    val random: Random,
    val requestsLeft: Int
)
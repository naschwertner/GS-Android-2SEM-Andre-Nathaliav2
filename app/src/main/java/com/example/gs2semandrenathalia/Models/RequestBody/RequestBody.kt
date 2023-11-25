package com.example.gs2semandrenathalia.Models.RequestBody

data class RequestBody(
    val id: Int,
    val jsonrpc: String,
    val method: String,
    val params: Params
)
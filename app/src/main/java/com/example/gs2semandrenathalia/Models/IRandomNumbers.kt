package com.example.gs2semandrenathalia.Models

import com.example.gs2semandrenathalia.Models.RequestBody.RequestBody
import com.example.gs2semandrenathalia.Models.ResponseBody.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IRandomNumbers {
    @POST("json-rpc/4/invoke")
    fun invokeNumbers(
        @Body requestBody: RequestBody
    ): Call<ResponseBody>
}
package com.example.gs2semandrenathalia.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gs2semandrenathalia.Models.IRandomNumbers
import com.example.gs2semandrenathalia.Models.RequestBody.Params
import com.example.gs2semandrenathalia.Models.RequestBody.RequestBody
import com.example.gs2semandrenathalia.Models.ResponseBody.ResponseBody
import com.example.gs2semandrenathalia.api.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RandomNumbersViewModel (private val retroFitClient: Retrofit) : ViewModel() {

    private var responseBody: ResponseBody? = null

    val liveResponseBody = MutableLiveData<ResponseBody?>()
    val liveError = MutableLiveData<String>()

    private fun invokeNumbersEndpoint(): IRandomNumbers {
        val retroFitClient = NetworkUtils.retrofitInstance("https://api.random.org")
        return retroFitClient.create(IRandomNumbers::class.java)
    }

    fun invokeNumbers() {
        val endpoint = invokeNumbersEndpoint()
        val callback = endpoint.invokeNumbers(RequestBody(
            id = 1020,
            jsonrpc = "4.0",
            method = "generateIntegers",
            params = Params(
                apiKey = "3713f9cc-c596-4e7a-89e8-212f3444e42b",
                n = 6,
                min = 1,
                max = 100,
                replacement = true
            )
        ))

        callback.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                responseBody = response.body()
                liveResponseBody.value = responseBody
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                liveError.value = t.message
            }
        })
    }
}
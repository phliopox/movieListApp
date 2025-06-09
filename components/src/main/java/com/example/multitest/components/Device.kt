package com.example.multitest.components

interface Device {

    fun sendSms(phoneNumber: String, text: String? = null)

    fun call(phoneNumber: String)

    fun dial(phoneNumber: String)

    fun showWebUrl(url: String)

    val modelName : String

    val osVersion : String

    val phoneNumber : String

    suspend fun getUserUniqueId() : String

    suspend fun getAdvertisingId() : String?

    val saveUserUniqueId : String?

    val deviceId : String

    val language: String

    val country : String
}
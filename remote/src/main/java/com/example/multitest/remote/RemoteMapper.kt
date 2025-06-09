package com.example.multitest.remote

interface RemoteMapper<DataModel> {
    fun toData(): DataModel
}

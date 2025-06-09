@file:Suppress("UNCHECKED_CAST")

package com.example.multitest.data

internal interface DataMapper <DomainModel>{
    fun toDomain() : DomainModel
}

internal fun <EntityModel,DomainModel> EntityModel.toDomainModel() : DomainModel{
    return when(this){
        is DataMapper<*> -> toDomain()
        is List<*> -> map{
            val domainModel : DomainModel = it.toDomainModel()
            domainModel
        }
        is Unit -> this
        is Boolean -> this
        is Int -> this
        is String -> this
        is Byte -> this
        is Short -> this
        is Long -> this
        is Char -> this
        else -> {
            throw IllegalArgumentException("DataModel은 DataMapper<>, List<DataMapper<>>, Unit중 하나여야 함")
        }
     } as DomainModel
}


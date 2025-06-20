package com.example.multitest.data

import com.example.multitest.data_resource.DataResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <T, R> safeFlowCall(
    fetch: suspend () -> T,
    map: (T) -> R = { it.toDomainModel() }
): Flow<DataResource<R>> = flow {
    emit(DataResource.loading())
    try {
        val result = fetch()
        emit(DataResource.success(map(result)))
    } catch (e: Exception) {
        emit(DataResource.error(e))
    }
}

fun <T, R> safeFlowCallWithCache(
    localFetch: suspend () -> T?,
    remoteFetch: suspend () -> T,
    saveCache: suspend (T) -> Unit,
    map: (T) -> R = { it.toDomainModel() }
): Flow<DataResource<R>> = flow {
    // 1. 로컬 데이터 먼저 시도, 있다면 로딩 상태로 emit
    val localData = try {
        localFetch()
    } catch (e: Exception) {
        null
    }

    emit(DataResource.loading(localData?.let(map)))

    try {
        // 2. 원격 데이터 받아오기
        val remoteData = remoteFetch()
        // 3. 캐시 저장
        saveCache(remoteData)
        // 4. 성공 emit
        emit(DataResource.success(map(remoteData)))
    } catch (e: Exception) {
        // 5. 실패 시 로컬 데이터가 있으면 그것을 Success로, 없으면 Error로 emit
        if (localData != null) {
            emit(DataResource.success(map(localData)))
        } else {
            emit(DataResource.error(e))
        }
    }
}
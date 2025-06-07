package com.example.multitest.presentation.base

import androidx.lifecycle.ViewModel
import com.example.multitest.common.util.logw
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.sql.DataSource
import kotlin.math.max

abstract class BaseViewModel<VE : ViewEvent> : ViewModel() {

    private val loadingCountMap = mutableMapOf<String, Int>()
    private val jobMap: MutableMap<String, Job> = mutableMapOf()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    // todo 공부
    private val _eventChannel: Channel<VE> = Channel()
    val eventFlow: Flow<VE> = _eventChannel.receiveAsFlow()

    // 로딩 시작
    fun showLoading(tag: String = DEFAULT_LOADING_TAG) {
        if (loadingCountMap.values.sum() == 0) {
            _loading.value = true
        }
        loadingCountMap[tag] = (loadingCountMap[tag] ?: 0) + 1
    }

    //로딩 완료 처리
    fun hideLoading(tag: String = DEFAULT_LOADING_TAG) {
        loadingCountMap[tag] = max((loadingCountMap[tag] ?: 0) - 1, 0)
        if (loadingCountMap.values.sum() == 0) {
            _loading.value = false
        }
    }

    // 로딩 오류/취소 시 강제 로딩 종료 clear
    fun clearLoading(tag: String = DEFAULT_LOADING_TAG) {
        loadingCountMap[tag] = 0
        if (loadingCountMap.values.sum() == 0) {
            _loading.value = false
        }
    }

    open fun handleError(throwable: Throwable?){
        handleError(throwable, DEFAULT_LOADING_TAG)
    }
    fun handleError(throwable: Throwable?,tag:String = DEFAULT_LOADING_TAG){
        hideLoading(tag)
        logw(throwable.toString())
        //todo handle throwable
    }


    companion object {
        const val DEFAULT_LOADING_TAG = "DEFAULT_LOADING_TAG"
        const val DEFAULT_JOB_TAG = "DEFAULT_JOB_TAG"
    }
}
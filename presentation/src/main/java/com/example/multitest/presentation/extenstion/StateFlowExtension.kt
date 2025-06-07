package com.example.multitest.presentation.extenstion

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

fun <T> StateFlow<T?>.observe(lifecycleOwner: LifecycleOwner, action: (value: T) -> Unit) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            collect { it?.let(action) }
        }
    }
}
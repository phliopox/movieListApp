package com.example.multitest.common.util

import com.example.multitest.common.BuildConfig

private const val TAG = "mm"

private fun buildLogMsg(message : String) : String{
    val ste = Thread.currentThread().stackTrace[4]
    val fileName = ste.fileName.replace(".java","").replace(".kt","")
    return "[$fileName::${ste.methodName} (${ste.fileName}:${ste.lineNumber}] $message"
}

private fun isNotDebugMode() = !BuildConfig.DEBUG
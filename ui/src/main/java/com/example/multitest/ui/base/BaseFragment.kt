package com.example.multitest.ui.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.multitest.presentation.base.BaseViewModel
import com.example.multitest.presentation.base.ViewEvent

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel<VE>, VE : ViewEvent>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    }
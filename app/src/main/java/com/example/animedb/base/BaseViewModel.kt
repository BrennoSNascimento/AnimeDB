package com.example.animedb.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel() : ViewModel(), LifecycleObserver {
    protected val disposable = CompositeDisposable()
}
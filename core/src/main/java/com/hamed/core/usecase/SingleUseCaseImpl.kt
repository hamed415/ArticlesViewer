package com.hamed.core.usecase

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCaseImpl<T, Params> : SingleUseCase<T, Params> {
    protected fun buildUseCaseSingle(params: Params): Single<T>? {
        return null
    }

    abstract override fun getSingle(params: Params): Single<T>?
    protected fun subscribeSingleOn(params: Params, scheduler: Scheduler?): Single<T> {
        return buildUseCaseSingle(params)!!.subscribeOn(scheduler)
    }
}
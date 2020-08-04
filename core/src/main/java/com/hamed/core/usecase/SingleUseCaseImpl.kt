package com.hamed.core.usecase

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCaseImpl<T, Params> : SingleUseCase<T, Params> {
    abstract override fun getSingle(params: Params): Single<T>?
}
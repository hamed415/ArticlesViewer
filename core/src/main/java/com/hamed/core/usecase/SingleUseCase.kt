package com.hamed.core.usecase

import io.reactivex.Single

interface SingleUseCase<T, Params> {
    fun getSingle(params: Params): Single<T>?
}
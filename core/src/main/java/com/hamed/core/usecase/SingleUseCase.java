package com.hamed.core.usecase;

import io.reactivex.Single;

public interface SingleUseCase<T, Params> {
    Single<T> getSingle(Params params);
}

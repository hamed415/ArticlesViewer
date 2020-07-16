package com.hamed.core.usecase;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public abstract class SingleUseCaseImpl<T, Params> implements SingleUseCase<T, Params> {
    protected Single<T> buildUseCaseSingle(Params params) {
        return null;
    }

    public abstract Single<T> getSingle(Params params);

    protected Single<T> subscribeSingleOn(Params params, Scheduler scheduler) {
        return buildUseCaseSingle(params).subscribeOn(scheduler);
    }
}

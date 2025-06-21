package io.reactivex.internal.operators.mixed;

/* loaded from: classes11.dex */
final class ScalarXMapZHelper {
    public ScalarXMapZHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T> boolean a(java.lang.Object obj, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, io.reactivex.CompletableObserver completableObserver) {
        if (!(obj instanceof java.util.concurrent.Callable)) {
            return false;
        }
        try {
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) ((java.util.concurrent.Callable) obj).call();
            io.reactivex.CompletableSource completableSource = mJShareMethod != null ? (io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function.apply(mJShareMethod), "The mapper returned a null CompletableSource") : null;
            if (completableSource == null) {
                io.reactivex.internal.disposables.EmptyDisposable.complete(completableObserver);
            } else {
                completableSource.subscribe(completableObserver);
            }
            return true;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, completableObserver);
            return true;
        }
    }

    public static <T, R> boolean b(java.lang.Object obj, io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, io.reactivex.Observer<? super R> observer) {
        if (!(obj instanceof java.util.concurrent.Callable)) {
            return false;
        }
        try {
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) ((java.util.concurrent.Callable) obj).call();
            io.reactivex.MaybeSource maybeSource = mJShareMethod != null ? (io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function.apply(mJShareMethod), "The mapper returned a null MaybeSource") : null;
            if (maybeSource == null) {
                io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
            } else {
                maybeSource.subscribe(io.reactivex.internal.operators.maybe.MaybeToObservable.create(observer));
            }
            return true;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
            return true;
        }
    }

    public static <T, R> boolean c(java.lang.Object obj, io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, io.reactivex.Observer<? super R> observer) {
        if (!(obj instanceof java.util.concurrent.Callable)) {
            return false;
        }
        try {
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) ((java.util.concurrent.Callable) obj).call();
            io.reactivex.SingleSource singleSource = mJShareMethod != null ? (io.reactivex.SingleSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function.apply(mJShareMethod), "The mapper returned a null SingleSource") : null;
            if (singleSource == null) {
                io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
            } else {
                singleSource.subscribe(io.reactivex.internal.operators.single.SingleToObservable.create(observer));
            }
            return true;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
            return true;
        }
    }
}

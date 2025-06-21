package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableResumeNext extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.CompletableSource> t;

    public static final class ResumeNextObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 5018523762564524046L;
        final io.reactivex.CompletableObserver downstream;
        final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.CompletableSource> errorMapper;
        boolean once;

        public ResumeNextObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.CompletableSource> function) {
            this.downstream = completableObserver;
            this.errorMapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            if (this.once) {
                this.downstream.onError(th);
                return;
            }
            this.once = true;
            try {
                ((io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.errorMapper.apply(th), "The errorMapper returned a null CompletableSource")).subscribe(this);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableResumeNext(io.reactivex.CompletableSource completableSource, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.CompletableSource> function) {
        this.n = completableSource;
        this.t = function;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.operators.completable.CompletableResumeNext.ResumeNextObserver resumeNextObserver = new io.reactivex.internal.operators.completable.CompletableResumeNext.ResumeNextObserver(completableObserver, this.t);
        completableObserver.onSubscribe(resumeNextObserver);
        this.n.subscribe(resumeNextObserver);
    }
}

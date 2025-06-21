package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class ConnectConsumer implements io.reactivex.functions.Consumer<io.reactivex.disposables.Disposable> {
    public io.reactivex.disposables.Disposable disposable;

    @Override // io.reactivex.functions.Consumer
    public void accept(io.reactivex.disposables.Disposable disposable) throws java.lang.Exception {
        this.disposable = disposable;
    }
}

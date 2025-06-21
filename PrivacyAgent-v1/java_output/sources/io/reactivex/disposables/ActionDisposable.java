package io.reactivex.disposables;

/* loaded from: classes9.dex */
final class ActionDisposable extends io.reactivex.disposables.ReferenceDisposable<io.reactivex.functions.Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(io.reactivex.functions.Action action) {
        super(action);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@io.reactivex.annotations.NonNull io.reactivex.functions.Action action) {
        try {
            action.run();
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }
}

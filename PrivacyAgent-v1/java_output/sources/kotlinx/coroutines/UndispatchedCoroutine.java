package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "oldValue", "", "saveThreadContext", "", "clearThreadContext", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "afterResume", com.umeng.analytics.pro.bo.aN, "Lkotlin/coroutines/CoroutineContext;", "savedContext", "v", "Ljava/lang/Object;", "savedOldValue", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class UndispatchedCoroutine<T> extends kotlinx.coroutines.internal.ScopeCoroutine<T> {

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlin.coroutines.CoroutineContext savedContext;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object savedOldValue;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UndispatchedCoroutine(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        super(coroutineContext.get(r0) == null ? coroutineContext.plus(r0) : coroutineContext, continuation);
        kotlinx.coroutines.UndispatchedMarker undispatchedMarker = kotlinx.coroutines.UndispatchedMarker.n;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void afterResume(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        kotlin.coroutines.CoroutineContext coroutineContext = this.savedContext;
        if (coroutineContext != null) {
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(coroutineContext, this.savedOldValue);
            this.savedContext = null;
            this.savedOldValue = null;
        }
        java.lang.Object recoverResult = kotlinx.coroutines.CompletionStateKt.recoverResult(state, this.uCont);
        kotlin.coroutines.Continuation<T> continuation = this.uCont;
        kotlin.coroutines.CoroutineContext context = continuation.getContext();
        java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, null);
        kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext) : null;
        try {
            this.uCont.resumeWith(recoverResult);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        } finally {
            if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    public final boolean clearThreadContext() {
        if (this.savedContext == null) {
            return false;
        }
        this.savedContext = null;
        this.savedOldValue = null;
        return true;
    }

    public final void saveThreadContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.Nullable java.lang.Object oldValue) {
        this.savedContext = context;
        this.savedOldValue = oldValue;
    }
}

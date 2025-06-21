package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class DebugStringsKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getClassSimpleName(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        return obj.getClass().getSimpleName();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getHexAddress(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        return java.lang.Integer.toHexString(java.lang.System.identityHashCode(obj));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String toDebugString(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        java.lang.Object m156constructorimpl;
        if (continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        if (kotlin.Result.m159exceptionOrNullimpl(m156constructorimpl) != null) {
            m156constructorimpl = ((java.lang.Object) continuation.getClass().getName()) + '@' + getHexAddress(continuation);
        }
        return (java.lang.String) m156constructorimpl;
    }
}

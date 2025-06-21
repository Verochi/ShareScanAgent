package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "Ljava/lang/ThreadLocal;", "threadLocal", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "other", "", "equals", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@kotlin.PublishedApi
/* loaded from: classes16.dex */
public final /* data */ class ThreadLocalKey implements kotlin.coroutines.CoroutineContext.Key<kotlinx.coroutines.internal.ThreadLocal<?>> {

    /* renamed from: n, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.lang.ThreadLocal<?> threadLocal;

    public ThreadLocalKey(@org.jetbrains.annotations.NotNull java.lang.ThreadLocal<?> threadLocal) {
        this.threadLocal = threadLocal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kotlinx.coroutines.internal.ThreadLocalKey copy$default(kotlinx.coroutines.internal.ThreadLocalKey threadLocalKey, java.lang.ThreadLocal threadLocal, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            threadLocal = threadLocalKey.threadLocal;
        }
        return threadLocalKey.copy(threadLocal);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.ThreadLocalKey copy(@org.jetbrains.annotations.NotNull java.lang.ThreadLocal<?> threadLocal) {
        return new kotlinx.coroutines.internal.ThreadLocalKey(threadLocal);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof kotlinx.coroutines.internal.ThreadLocalKey) && kotlin.jvm.internal.Intrinsics.areEqual(this.threadLocal, ((kotlinx.coroutines.internal.ThreadLocalKey) other).threadLocal);
    }

    public int hashCode() {
        return this.threadLocal.hashCode();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + ')';
    }
}

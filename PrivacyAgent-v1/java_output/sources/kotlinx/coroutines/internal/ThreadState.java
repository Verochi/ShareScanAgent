package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR$\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "Lkotlinx/coroutines/ThreadContextElement;", "element", "value", "", "a", "Lkotlin/coroutines/CoroutineContext;", "context", "b", "Lkotlin/coroutines/CoroutineContext;", "", "[Ljava/lang/Object;", "values", "c", "[Lkotlinx/coroutines/ThreadContextElement;", "elements", "", "d", "I", "i", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class ThreadState {

    /* renamed from: a, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.CoroutineContext context;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object[] values;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.ThreadContextElement<java.lang.Object>[] elements;

    /* renamed from: d, reason: from kotlin metadata */
    public int i;

    public ThreadState(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, int i) {
        this.context = coroutineContext;
        this.values = new java.lang.Object[i];
        this.elements = new kotlinx.coroutines.ThreadContextElement[i];
    }

    public final void a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.ThreadContextElement<?> element, @org.jetbrains.annotations.Nullable java.lang.Object value) {
        java.lang.Object[] objArr = this.values;
        int i = this.i;
        objArr[i] = value;
        kotlinx.coroutines.ThreadContextElement<java.lang.Object>[] threadContextElementArr = this.elements;
        this.i = i + 1;
        threadContextElementArr[i] = element;
    }

    public final void b(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            kotlinx.coroutines.ThreadContextElement<java.lang.Object> threadContextElement = this.elements[length];
            kotlin.jvm.internal.Intrinsics.checkNotNull(threadContextElement);
            threadContextElement.restoreThreadContext(context, this.values[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
